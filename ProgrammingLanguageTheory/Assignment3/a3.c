#include <stdio.h>
#include <string.h>
int total;
int count(char i, char* array){
	int j;
	
	
	for (j = 0; j <= strlen(array); j++){
		if(array[j] == i) {
		    total++;
		}
	}
	return total;
}
int main(){
	char *a = "010101010100202101202132400231240234";
	printf("%d", count('0', a));
	return 0;

}
