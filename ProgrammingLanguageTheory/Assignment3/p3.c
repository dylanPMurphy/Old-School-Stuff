/*  p3.c  */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define INSERT_AFTER_FLAG 1

#define INSERT_BEFORE_FLAG 2



typedef struct List{
	int index;
	char* data;
	struct List * next;
	

}  *nodePtr ;
nodePtr head;
nodePtr tail;
int size;

int flag;

char* getData(struct List* target);
nodePtr newNode(int x, char *s);
void add( char* s, int index);
void addToBegining(struct List node);
void addToMiddle(struct List node, int index);
void replace (int i, char* string);
nodePtr nodeAtIndex(int index);
void addToEnd(struct List node);
void destroy();
void printList();


char* getData(nodePtr target){
	return target->data;
}

nodePtr newNode(int x, char *s){
	nodePtr listNode = 
		(Struct List*)malloc(sizeof(struct List));
	listNode->index = x;
	listNode->data = s;
	listNode->next = NULL;
	return listNode;
}



void add( char* s, int index){
	int i = 1;

	nodePtr tmp = newNode(s);
	if(head  == NULL){
		head = &temp;
		tail = &temp;
		temp->data = s;
		temp->index = 1;
		size = 1;
	}else{
		if(nodeAtIndex(index)->next == NULL){
			addToEnd(tmp);
		}
		addToMiddle(tmp, index);

	}
	
	
}



void addToBegining(nodePtr node){
	nodePtr temp = head;
	node->next = temp;
	head = &node;
	size++;
}


void addToMiddle(nodePtr node, int index){
    
    if(flag = INSERT_BEFORE_FLAG){
    	nodePtr tmp = nodeAtIndex(index-1);
    	tmp->next = node;
    	node->next = nodeAtIndex(index);
    	tmp = node->next;
    	while(tmp != NULL){
    		tmp->index  ++;
    		tmp = tmp->next;
    	}
    	size++;
    }
    else if(flag = INSERT_AFTER_FLAG){
    	nodePtr tmp = nodeAtIndex(index);
    	tmp->next = node;
    	node->index = index+1;
    	node->next = nodeAtIndex(index+1);
    	tmp = node->next;
    	while(tmp != NULL){
    		tmp->index  ++;
    		tmp = tmp->next;
    	}
    	size++;
    }
}

/*void replace (int i, char* string){


}*/


nodePtr nodeAtIndex(int index){
	nodePtr tmp = head;
	int i;
	for(i=1; i != index; i++) {
		tmp = tmp->next;
	}
	return tmp;
}
void printList(){
	nodePtr tmp = nodeAtIndex(1);
	while(tmp !=NULL){
		 printf("Index:%d %s\n", tmp->index, tmp->data);
		 tmp  = tmp->next;
	}
}
void destroy(){
	nodePtr curr = nodeAtIndex(1);
	nodePtr next;
	while (curr !=NULL){
		next = curr->next;
		free(curr);
		curr = next;
	}
} 

void addToEnd(nodePtr node){
	List* temp = nodeAtIndex(size);
		
	temp->next = node;
	size++;
	
}




int main(){
	add("skjdfkj", 1);
	add("skdfghsd", 2);
	add("aksdjh", 3);
	add("kajdsfhsk", 4);
	add("asdasasa", 5);
	add("askfjhsafdkj", 6);

}
