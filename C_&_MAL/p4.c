/*
Dylan Murphy DM187454 && Anthony Khalil AK939963
CSI333
WED415
Project 4
The work for this project was divided by sections of the project. 
We met up to work on the project a few times as well as talking on 
the phone for several days trying to get this done. 
We ended up splitting the project into multiple parts and combined 
it at the end. We had some difficulty combining the parts at first
but after figuring out where everything goes we got it to working. 
We noted all the important code that each of us did.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NUMARG 4
#define FLAG_ARG 1
#define IN_FILE_ARG 2
#define OUT_FILE_ARG 3

#define FLAG_F "-f"
#define FLAG_V "-v"
#define FLAG_B "-b"

#define LINEMAX 80
#define ARRAY_MAX 100

typedef struct Node {
	/*Linked List Nodes*/
	
	char* data;//Line of MIPS code 
	struct Node *next;

} *nodePtr;//defines nodePtr as type struct Node*

struct ID{
	/*Individual identifiers, each point to the head of a linked list*/
	char flag;//either f or v
	char* identifier;
	nodePtr head;//points to the head of a linked list of the lines of MAL codes that have the identifier
};	
struct ID* idList[ARRAY_MAX];//Creates a list of ID stucts to store each identifier
int listSize = 0;


void printList(nodePtr head_ref, FILE* o);//Created tested and debugged by Dylan Murphy
struct ID* newID(char s[], char f);//Created tested and debugged by Dylan Murphy
nodePtr newNode ( char s[]);//Created tested and debugged by Dylan Murphy
void addID( struct ID* id);//Created tested and debugged by Dylan Murphy
void addNode(nodePtr* head_ref, nodePtr new);//Created tested and debugged by Dylan Murphy
void addToID(char* id, char b[]);//Created tested and debugged by Dylan Murphy
void addNode(nodePtr* head_ref, nodePtr new);//Created tested and debugged by Dylan Murphy
struct ID* idLookup(char* s);//Created tested and debugged by Dylan Murphy
void print(FILE * out);//Created tested and debugged by Dylan Murphy
void destroyList();//Created tested and debugged by Dylan Murphy
void findVID(FILE* in);//Created tested and debugged by Anthony Khalil
void findFID(FILE* in);//Created tested and debugged by Anthony Khalil
void addLine(FILE* in);//Created tested and debugged by Anthony Khalil



int main(int argc, const char * argv[]){//Created tested and debugged by Anthony Khalil
	FILE *inFile;
    FILE *outFile;
    struct ID idList[ARRAY_MAX];//Creates a list of ID stucts to store each identifier
    char flag = argv[1][1];//collects flag from CL Arg


    
    if ((inFile =fopen(argv[IN_FILE_ARG], "r"))==NULL){
        //inputFile did not open correctly
        fprintf(stderr, "Could not open file %s for reading\n", argv[IN_FILE_ARG]);
        exit(1);
    }
    else{
        
        if ((outFile =fopen(argv[OUT_FILE_ARG], "w"))==NULL){
            //outputFile did not open correctly
            fprintf(stderr, "Could not open file %s for writing\n", argv[OUT_FILE_ARG]);
            exit(1);
        }
        else{
        	
        	
        	
        	switch(flag){
        		case 'v'://'v' arg
        			findVID(inFile);
        			addLine(inFile);
        			print(outFile);
        			break;
        		case 'f'://'f' arg
        			findFID(inFile);
        			addLine(inFile);
        			print(outFile);
        			break;
        		case 'b'://'b' arg
        			findVID(inFile);
        			findFID(inFile);
        			addLine(inFile);
        			print(outFile);
        			break;
        		default://bad arg
        			fprintf(stderr, "INVALID ARGUMENT FLAG\n");
        			exit(1);


        	}
        	fclose(inFile);
        	fclose(outFile);
        	printf("DONE.\n");
		}
	}
}	
struct ID* newID(char s[], char f){
    //initializes and allocates memory for a new ID struct
	struct ID * i = (struct ID *) malloc (sizeof (struct ID));
	i->identifier = (char*) malloc (sizeof(char)*strlen(s));
	strcpy(i->identifier, s);
	i->flag = f;
	i->head = NULL;
	addID(i);
	return i;
}

nodePtr newNode ( char s[])
{
    //printf("newNode Test\n");
	/*this function takes an int and a string and initalizes and allocates a node that
	contains these parameters
	*/
	nodePtr listNode = (struct Node *) malloc (sizeof (struct Node));
	listNode->data = (char*) malloc (sizeof(char)*strlen(s));
	
	
	
	strcpy(listNode->data, s);

	listNode->next = NULL;
	
	return listNode;
}
void addID( struct ID* id ){//creates new identifier entry in idList
    
    fflush(stdout);
    
    struct ID* temp = id;
		
	idList[listSize] = temp;
		
	listSize++;
}
	
	
	

void addToID(char* id, char* b){//adds a string to the liked list associated with ID
	struct ID* a = idLookup(id);
	
	nodePtr temp = newNode(b);
	addNode(&(a->head), temp);
}
void addNode(nodePtr* head_ref, nodePtr new){//adds node onto liked list 
    
    fflush(stdout);
    nodePtr temp = *head_ref;
	if(temp == NULL){
		
		new->next = temp;
		*head_ref = new;
	}
	else{
		
		while(temp->next != NULL){
			temp = temp->next;
		}
		temp->next =  new;

	}
}
struct ID* idLookup(char* s){//checks the idList to see if the identifier has been used before
    if(idList[0]==NULL){
        return NULL;
    }
    else
    {
        
    
	//printf("IDLookup Test\n");
	int i=0;
	while(i<=listSize){
		if(strcmp(idList[i]->identifier,s) == 0){
			
			return idList[i];
		}
		i++;
	}
	return NULL;
    }
}
void print(FILE * out){//Prints idList with corresponding linked lists 
	
	int i= 0;
	while(i<listSize){
	    
	    if(idList[i]->flag == 'f'){
		fprintf(out, "Flow Control ID--%s--\n", idList[i]->identifier);
		fflush(stdout);
		if(idList[i]->head != NULL){
				printList(idList[i]->head, out);
			}
		i++;
		}
		else{
			fprintf(out, "Variable ID--%s--\n",  idList[i]->identifier);
			fflush(stdout);
			if(idList[i]->head != NULL){
				printList(idList[i]->head, out);
			}
			
		i++;
		}
}}

void printList(nodePtr head_ref, FILE* o){//prints a linked lists
	nodePtr tmp = head_ref;
	while (tmp != NULL)
	{
		fprintf (o, "%s\n",  tmp->data);
		
		tmp = tmp->next;
	}
}
void destroyList ()
{
	int i;
	for(i=0;i<listSize;i++){


	nodePtr curr = idList[i]->head;
	nodePtr next;
	while (curr != NULL)
	{
		next = curr->next;
		free (curr);
		curr = next;
	}
	

	//printf ("Destroyed\n");
	fflush (stdout);
}


}

void findVID(FILE* in){
	/* Searches the file for regular variables and stores them in idList*/
	
	char* line = (char*) malloc (sizeof(char)*LINEMAX);
    char* token;
    
	while (fgets(line, LINEMAX, in)!=NULL){
    	
   		if(strstr(line, ".text\n")) {
    		
    		
    		
    		break;
    		}
    	else if(line[0] == '\n' || line[0] == '#' || line[0] == '\0'|| line[0] == ' '){
        	continue;
   		}
   		else{
   			token = strtok(line, ": \n\r");
   			if(strcmp(token, ".data") == 0){
   				continue;
   			}
   			
   			else{
   				newID(token, 'v');
   			}
   		}


   	}
   	rewind(in);	

}


void findFID(FILE* in){
	/* Searches the file for flow control variables and stores them in idList*/
	
	
	char* line = (char*) malloc (sizeof(char)*LINEMAX);
    char* token;
    while (fgets(line, LINEMAX, in)!=NULL){

    	if(strstr(line, ".text")) {
    		
    		
    		
    		break;
    		}

    }
    while (fgets(line, LINEMAX, in)!=NULL){
    	if(line[0] == '\n' || line[0] == '\t' || line[0] == '#' || line[0] == '\0'||line[0] == ' '){
        	continue;
   		}
   		else if(strchr(line, '\'') || strchr(line, '\"')){
   				continue;
   			}
   		else{
   			token = strtok(line, ": ");
   			newID(token, 'f');
   		}
   	}
   	rewind(in);


   	

}

void addLine(FILE* in){
	/*Searches the file for pre-defined indentifiers and adds the lines where they 
	appear in the linked list */
	
	char* line = (char*) malloc (sizeof(char)*LINEMAX);
	
    char* token;
    char* comment;
   	
    memset(line, '\0', LINEMAX);
	while (fgets(line, LINEMAX, in)!=NULL){

    	if(strstr(line, ".text")) {
    		
    		
    		
    		break;
    		}

    }
    
    
    
    while (fgets(line, LINEMAX, in)!=NULL){
    	char * oline = (char*) malloc (sizeof(char)*LINEMAX);
    	strcpy(oline, line);
    	
    	if(line[0] == '\n' || line[0] == '#' || line[0] == '\0'){
        	continue;
   		}
   		
   		else if(strchr(line, '#')){

   			token = strtok(line,  "#");

   			
   			if(strchr(token, '\'') || strchr(token, '\"') || strchr(token, '.')){
   				continue;
   			}
   			int i;
   			for(i=0; i<listSize; i++){
		   		if(strstr(token, idList[i]->identifier) ){
		   			if(idList[i]->flag == 'v'){
		   				addToID(idList[i]->identifier, oline);
		   				break;
		   			}	
		   			else if(idList[i]->flag == 'f' && !strchr(oline, ':')){
		   				addToID(idList[i]->identifier, oline);
		   				break;
		   		}
		   		}
		   	}

   		}
   		else{
   			if(strchr(line, '\'') || strchr(line, '\"') || strchr(line, '.')){
   				continue; 
   			}
	   		int i;
		   	
		   	for(i=0; i<listSize; i++){
		   		if(strstr(token, idList[i]->identifier) ){
		   			if(idList[i]->flag == 'v'){
		   				addToID(idList[i]->identifier, line);
		   				break;
		   			}	
		   			else if(idList[i]->flag == 'f' && !strchr(line, ':')){
		   				addToID(idList[i]->identifier, line);
		   				break;
		   		}
		   		}
		   	}
			   	
		    
		}
}
rewind(in);
}













//EOF