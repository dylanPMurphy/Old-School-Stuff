/*
**Dylan Murphy
**dm187454
**Wednesday 4:15
*/
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

char value[100];
char returnChar(int g);
void radix(int d, int r);


int main(){
	int ten, base;
	printf("Please enter a number base 10 hit spacebar and enter which base your output will be in");
	fflush(stdout);
	scanf("%d %d", &ten, &base);
	
    radix(ten, base);
	puts(value);
	fflush(stdout);
}	

void radix(int d, int r){

	int i;
	i=0;
	while(d>0){
	    char a;
	    value[i] = returnChar(d%r);
		d = d/r;
		i++;
		
		}

	

}




char returnChar(int g){
	if (g<=9){
		return g;
	}
	else{
	switch(g){
		
		case 10:
			return'a';
			break;
		case 11:
			return'b';
			break;
		case 12:
			return'c';
			break;	
		case 13:
			return'd';
			break;
		case 14:
			return'e';
			break;
		case 15:
			return'f';
			break;
		default:
		return '\0';
		break;

	}}}