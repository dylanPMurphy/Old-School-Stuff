//
//  p2.c
//  
//  WED415

//  Created by Dylan Murphy on 10/14/17.
//  Copyright © 2017 Dylan Murphy. All rights reserved.
//
/*This program takes a text file and reverses the lines to an ouput file given by command line 
arguments. I achieved this by implementing a stack to take each token of the text file. Each word 
or token is pushed onto the stack until the line is done.  Then it pops the stack token by token 
into the output file.  Then the program moves onto the next line to repeat the process until every
line has its words reversed.

*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LINE_MAX 255

#define NUMARG 3
#define IN_FILE_ARG 1
#define OUT_FILE_ARG 2

struct StackNode{
    char* token;
    struct StackNode * next;
};
struct StackNode* newNode(char *tok){
    /*allocates and initializes new nodes to be added to the stack*/
    struct StackNode* stackNode =
              (struct StackNode*) malloc(sizeof(struct StackNode));
    stackNode->token = tok;
    stackNode->next = NULL;
    return stackNode;
}

void push(struct StackNode** root, char* data){
    /*pushes a new node onto the top of the stack*/
    struct StackNode* stackNode = newNode(data);
    stackNode->next = *root;
    *root = stackNode;
    
    
}
char* pop(struct StackNode** root)
{
    /*Pops the top node off the stack and returns the string it held*/
    struct StackNode* temp = *root;
    *root = (*root)->next;
    char *data = malloc(sizeof((*root)->token));
    data = temp->token;
    free (temp);
    
    return data;
}




int main(int argc, const char * argv[]) {
    
    
    FILE *inFile;
    FILE *outFile;
    
    
    if ((inFile =fopen(argv[IN_FILE_ARG], "r"))==NULL){
        /*inputFile did not open correctly*/
        printf("Could not open file %s for reading\n", argv[IN_FILE_ARG]);
        exit(1);
    }
    else{
        
        if ((outFile =fopen(argv[OUT_FILE_ARG], "w"))==NULL){
            /*outputFile did not open correctly*/
            printf("Could not open file %s for reading\n", argv[OUT_FILE_ARG]);
            exit(1);
        }
        else{
            
            char temp[LINE_MAX];
            char* token;
            while (fgets(temp, LINE_MAX, inFile)!= NULL){/*This loop is reading each 
                                                        line and storing a temp array*/
                struct StackNode* Root = NULL;//initalize the stack
                
                token = strtok(temp, " \t\n");//stores the first token
                push(&Root, token);//stores the first token in the stack
               
               while( token != NULL ) {/* walk through other tokens */
                  token = strtok(NULL, " \t\n");
                  if(token == NULL) break;
                  push(&Root, token);
                  
               }
                
                while (Root !=NULL){/*pops each node on the stack into the output file
                                    until the stack is empty*/
                    
                    fputs(pop(&Root),outFile);
                    fputs(" ",outFile);
                     
                }
                fputs("\n", outFile);
                
            }
            
        }
        
    
        
    }
    printf("FINISHED.\n");
    return 0;
}
