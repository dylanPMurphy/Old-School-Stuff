#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define INSERT_AFTER_FLAG 1

#define INSERT_BEFORE_FLAG 2




typedef struct List
{
	int index;
	char* data;
	struct List *next;


} *nodePtr;


int size;

int flag = 0;

nodePtr newNode (int x, char s[]);
void add (nodePtr * head_ref, char *s, int index);
void addToBegining (nodePtr * head_ref, nodePtr node);
void addToMiddle (nodePtr * head_ref, nodePtr node, int index);
void replace (nodePtr * head_ref, int index, char *string);
nodePtr nodeAtIndex (nodePtr * h_ref, int index);
void addToEnd (nodePtr * head_ref, nodePtr node);
void destroy (nodePtr * head_ref);
void printList (nodePtr * head_ref);
int stringScan (nodePtr * head_ref, char *string);
void delete (nodePtr * head_ref, int index);
char *getData (nodePtr target);



nodePtr
newNode (int x, char s[])
{
	/*this function takes an int and a string and initalizes a node that
	contains these parameters
	*/
	nodePtr listNode = (struct List *) malloc (sizeof (struct List));
	listNode->data = (char*) malloc (sizeof(char)*strlen(s));
	
	listNode->index = x;
	printf("newNode test\n");
	strcpy(listNode->data, s);

	listNode->next = NULL;
	
	return listNode;
}

char *
getData (nodePtr target)
{
	return target->data;
}

void
add (nodePtr * head_ref, char *s, int index)
{
/*the add function takes a head reference a string and an int and adds
a new node to the list with the help of newNode() it then controls where the node
will be positioned on the list and uses the add helper functions to insert precisely
where it needs to be
*/

	nodePtr tmp = newNode (index, s);
	
	if (index == 1)
	{
		addToBegining (head_ref, tmp);
	}
	else if (index<=size)
	{
		addToMiddle(head_ref, tmp, index);
	} 
	else
	{
		if (flag == INSERT_AFTER_FLAG){

			addToEnd(head_ref, tmp);
		}
		else if (flag == INSERT_BEFORE_FLAG){
			tmp->index = 1;

			addToBegining(head_ref, tmp);
		}
	}


}






void
addToBegining (nodePtr * head_ref, nodePtr node)
{
	/*Helper function to add(). this function adds an existing node to the begining
	of the list
	*/
	nodePtr temp = *head_ref;
	node->next = temp;
	*head_ref = node;
	size++;
	while (temp != NULL)//keeps indexes in order
	{
		temp->index++;
		temp = temp->next;
	}
}


void
addToMiddle (nodePtr * head_ref, nodePtr node, int index)
{
	/*
	this is a helper function to add() that inserts a node into the list either before or 
	after the target index based on the flag
	*/

	if (flag == INSERT_BEFORE_FLAG)
	{

		nodePtr prev = nodeAtIndex (head_ref, index - 1);
		nodePtr next = nodeAtIndex (head_ref, index);
		node->next = next;
		prev->next = node;


		while (next != NULL)//keeps indexes in order
		{
			next->index++;
			next = next->next;
		}
		size++;
	}




	else if (flag == INSERT_AFTER_FLAG)
	{	
		if (index==size){
			nodePtr tmp = nodeAtIndex (head_ref, index);
			tmp->next = node;
			size++;

		}	else{

			nodePtr tmp = nodeAtIndex (head_ref, index);

			nodePtr next = nodeAtIndex (head_ref, index + 1);
			node->next = next;
			tmp->next = node;
			node->index = index + 1;


			while (next != NULL)//keeps indexes in order
			{
				next->index++;
				next = next->next;
			}
			size++;
		}
	}
}


void replace (nodePtr * head_ref, int index, char *string)
{
	/*this function takes a head pointer pointer, an index and a string then
	replaces it with the string parameter
	*/
	nodePtr tmp = nodeAtIndex (head_ref, index);
	strcpy(tmp->data, string);
	tmp = NULL;

}
void delete (nodePtr * head_ref, int index)
{
	/*this function takes a heaf refeerence and an index then deletes a node with 
	that specific index.  it then links the list back together and handles the 
	index of all other nodes
	*/
	nodePtr curr, prev, next;
	if (size == 0)
	{
		printf ("theres no list\n");
		fflush (stdout);
	}
	if (index == 1)//node is at front of the list
	{
		curr = *head_ref;
		next = curr->next;
		free (curr);
		*head_ref = next;
		while (next != NULL)
		{

			next->index--;
			next = next->next;

		}
		size--;
		printf ("Deleted\n");
		fflush (stdout);

	}
	else if (index < size)//node is in middle of list
	{
		curr = nodeAtIndex (head_ref, index);
		prev = nodeAtIndex (head_ref, index - 1);
		next = nodeAtIndex (head_ref, index + 1);
		prev->next = next;
		free (curr);
		while (next != NULL)
		{

			next->index--;
			next = next->next;

		}
		size--;
		printf ("Deleted\n");
		fflush (stdout);
	}
	else if (index == size)//node is at end of the list
	{
		curr = nodeAtIndex (head_ref, index);
		prev = nodeAtIndex (head_ref, index - 1);
		free (curr);
		prev->next = NULL;
		size--;
		printf ("Deleted\n");
		fflush (stdout);
	}
	else if (index > size)
	{
		printf ("There is no such index %d\n", size);
		fflush (stdout);
	}

}




int stringScan (nodePtr * head_ref, char *string)
{
	/*this function traverses the list and analyzes the data field to see if there is a string match.  if a 
	string match is found the function returns 0 and if there isnt a match the function returns 1
	*/
	nodePtr tmp = nodeAtIndex (head_ref, 1);
	while (tmp != NULL)
	{
		if (strcmp (string, getData (tmp)) == 0)
		{
			return 0;
		}
		else
		{
			tmp = tmp->next;
		}
	}
	return 1;
}

nodePtr nodeAtIndex (nodePtr * head_ref, int index)
{
	/*This function takes a head reference and an index and returns the specific node that has that index
	*/
	if (head_ref == NULL || index > size)
	{
		return NULL;
	}
	nodePtr tmp = *head_ref;
	int i;
	for (i = 1; i < index; i++)
	{
		tmp = tmp->next;
	}
	return tmp;
}
void printList (nodePtr * head_ref)
{
	/*this function traverses the list and prints the index and data of all nodes i the list
	*/

	nodePtr tmp = nodeAtIndex (head_ref, 1);
	printf("printTest\n");
	while (tmp != NULL)
	{
		printf ("Index:%d %s\n", tmp->index, tmp->data);
		fflush (stdout);
		tmp = tmp->next;
	}
}
void destroy (nodePtr * head_ref)
{
	/*this function deletes the entire list and frees the memory of each node
	*/
	nodePtr curr = nodeAtIndex (head_ref, 1);
	nodePtr next;
	while (curr != NULL)
	{
		next = curr->next;
		free (curr);
		curr = next;
	}
	size = 0;

	printf ("Destroyed\n");
	fflush (stdout);
}

void addToEnd (nodePtr * head_ref, nodePtr node)
{
	/*Helper fucntion to add(). this function takes a list node and inserts it at the end
	of the list
	*/
	if(size ==0){
		addToBegining(head_ref, node);
	}
	nodePtr temp = nodeAtIndex (head_ref, size);

	temp->next = node;
	node->next = NULL;
	size++;
}



int main ()
{
	struct List* head = NULL;
	char buffer[500];//entire Command 
	char command[6];//specified command
	int index;
	char data[50];
	char* token;
	
	memset(command, '\0', 6);
	while (strcmp(command, "end") != 0)//runs program until user types end
	{

		printf ("\n-\n->");//PROMPTS USER FOR COMMAND
		fflush (stdout);
		//scanf("%s %d %s", command, &index, data);
		fgets(buffer, 500, stdin);//READS LINE OF COMMAND and stores the data in buffer
		//sscanf(cmd, "%s %d %s", command, &index, data);
		
		fflush (stdout);
		fflush(stdin);
	
		

		
		token = strtok(buffer, "\n\r ");//separates the string into tokens 

		strcpy(command, token);//copies token into command variable
		
		token = strtok(NULL, "\n\r ");//gets next token
		if(token != NULL){
			index = atoi(token);//stores the index
			token = strtok(NULL, "\n\r ");//gets next token
			if(token != NULL){
				strcpy(data, token);//copies data
			}
			
		}
		//printf("command:[%s] index:%d data:%s", command, index, data);
		//printf("%d", strcmp (command, "end")) ;
		//printf("%lu", strlen(command));
		if (strcmp (command, "ina\0") == 0)//this handles command ina
		{
			flag = INSERT_AFTER_FLAG;
			if (stringScan (&head, data) == 0)
			{

				printf ("Such text exists already\n");
				fflush (stdout);
			}

			else
			{

				add (&head, data, index);
				printf ("OK\n");
				fflush (stdout);
			}


		}
		else if (strcmp (command, "inb\0") == 0)//ths handles command inb
		{
			flag = INSERT_BEFORE_FLAG;
			if (stringScan (&head, data) == 0)
			{
				printf ("Such text exists already\n");
				fflush (stdout);
			}

			else
			{

				add (&head, data, index);
				printf ("OK");
				fflush (stdout);
			}
		}
		else if (strcmp (command, "del\0") == 0)//this handles command del
		{
			delete (&head, index);
		}
		else if (strcmp (command, "rep\0") == 0)//this handles command rep
		{
			replace (&head, index, data);
		}
		else if (strcmp (command, "prn\0") == 0)//this handles command prn
		{
			printList (&head);
		}
		else if (strcmp (command, "end\0") == 0)//this handles command end
		{
			destroy (&head);
			printf ("End.\n");
			fflush (stdout);
			//exit(0);	
		}

	}
}


  //	nodePtr head = NULL;
	//add(&head, "one", 1);
	//add(&head, "two", 2);
	//add(&head, "three", 3);
	//dd(&head, "four", 4);
	//add(&head, "five", 5);
	//add(&head, "six", 6);







	//printList(&head);
	//destroy(&head);}         


