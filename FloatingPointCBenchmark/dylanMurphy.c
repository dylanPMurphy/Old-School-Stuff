/*
 *Dylan Murphy
 *CSI 445 
 *Programming Exersize #1
 *Due 2/20/18
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define BUFFER  10000
#define BOOLE 1
#define intelXenonClock (2394455000)
#define sunSparcClock (1593000000)
/*  
    rand_float(double,double) generates random double preciscion floating point values
*/

double rand_float( double low, double high ) {
    return ( ( double )rand() * ( high - low ) ) / ( double )RAND_MAX + low;
}
int main(){
	unsigned int ClockRate;
	switch(BOOLE){
		case 0:
			ClockRate = intelXenonClock;
			break;
		case 1:
			ClockRate = sunSparcClock;
			break;
		default:
			break;
	}
	int ACC_LOOP = 1000000/BUFFER;
  	srand(time(NULL));
    int i;
	double a;
	double *x = (double*) malloc(sizeof(double) * BUFFER);
	double *y = (double*) malloc(sizeof(double) * BUFFER); 
	double *z = (double*) malloc(sizeof(double) * BUFFER);
	a = rand_float(0,100);
	int seed;
	int outer;
	
	double EntireArray_time, TotalExecution_time, ArrayElement_time, ArtithmeticOP_time;




	for(i = 0; i <= BUFFER; i++){
		seed = rand();                      //seed creates more randomness while the first iteration of randomness will be seeded with the system clock
		srand(seed);
		x[ i ] = rand_float(1.0,100.0);     //vector x is populated one at a time
		y[ i ] = rand_float(1.0,100.0);     //vector y is populated one at a time
	}







	clock_t TotalExec_start = clock();

	for(outer = 0; outer<ACC_LOOP; outer++){
	      //seed then re-seeds rand() function to give more randomness
		for(i = 0; i <= BUFFER; i++){
			z[ i ] = (a*x[ i ]) + y[ i ];  		//vector z is populated with (a*x)+y 
		}

	}


	clock_t TotalExec_end = clock();



	TotalExecution_time = (double) (TotalExec_end - TotalExec_start) / ClockRate;
	
	
	
	EntireArray_time = TotalExecution_time/ACC_LOOP;
	ArrayElement_time = EntireArray_time/BUFFER;
	ArtithmeticOP_time = ArrayElement_time/10;
	double OPC = (double) ArtithmeticOP_time/ClockRate;





	printf("Dylan Murphy Programming Asignment 2\n");
	printf("CPU Name: Intel Xenon\n");
	printf("Processor Clock Frequency:%u\n", ClockRate);  //2394.455 MHz
	printf("Vector Dimension: %d\n", BUFFER);
	printf("Number of Accuracy Loops: %d\n", ACC_LOOP);
	printf("Total Execution Time: %E\n", TotalExecution_time ) ;
	printf("Execution Time for Entire Array: %E\n", EntireArray_time);
	printf("Execution Time for Array Element: %E\n", ArrayElement_time);
	printf("Execution Time for Aritimetic Operation: %E\n", ArtithmeticOP_time);
	printf("Clock Cycles per Arithmetic Operation: %E\n", 10/(ArtithmeticOP_time*ClockRate) );
	printf("OPs per Cycle : %E\n", OPC);
	printf("Double Preciscion Ops per Second: %d\n", ClockRate/TotalExecution_time);



	return 0;
}


//double time_spent = (double)(end - begin) / CLOCKS_PER_SEC;