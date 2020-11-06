#include <stdio.h>
#include <time.h>
#include <stdlib.h>


//#define FILE "DOUBLEPRECISION_VMA to demonstrate evaluating Cycles per Ops ( CpOPs )"
//#define SIZE 1000 //1000 base.  If vector = 1  and LOOPs=1E10, and /O3 cycle per flop represent approx latency to L1
#define TOTAL_ITERATIONS 1E10  // total iterantions is the produst of SIZE and # of outer accuracy improvement loops (LOOP)
#define CPU_CLK 2.394455e9  //3.43E9 for Dell i7-6600, 2.8E9 for i5 Surface Pro, 3.48E9 for HP i7-7700; 2.394455e9 for Xeon  for Sun 1.593E9
#define MATRIX_DIMENSION 2048
#define CPU_NAME "Intel Xenon"





int  main()
{
	
	int ACC_LOOP = 2048/MATRIX_DIMENSION;

	double **z;
	double **x;
	double **y;
	//double NumOfOps;
	double FLOPS;
	double ElapsedTime;
	double ElapsedTimePerMatrix;
	double ElapsedTimePerMatrixElement;
	double ElapsedTimePerOP;

	long long TotalOps = 2*(MATRIX_DIMENSION*MATRIX_DIMENSION*MATRIX_DIMENSION)-(MATRIX_DIMENSION*MATRIX_DIMENSION);//Ops=2n^3-n^2



	time_t start_time;
	time_t end_time;



	x = (double**)malloc(MATRIX_DIMENSION * sizeof(double*));
	y = (double**)malloc(MATRIX_DIMENSION * sizeof(double*));
	z = (double**)malloc(MATRIX_DIMENSION * sizeof(double*));


	int i, j, k, m;

	
	
    for (i = 0; i < MATRIX_DIMENSION; i++)
    {	
    	x[i] = (double*)malloc(MATRIX_DIMENSION * sizeof(double));
		y[i] = (double*)malloc(MATRIX_DIMENSION * sizeof(double));
		z[i] = (double*)malloc(MATRIX_DIMENSION * sizeof(double));
        for (j = 0; j < MATRIX_DIMENSION; j++)
        {
        	x[i][j] = (double)1 + rand() % 100;
        	y[i][j] = (double)1 + rand() % 100;
        	z[i][j] = 0.0;
                
        }
    }







	start_time = (double)time(0);
	for(m=0;m<ACC_LOOP;m++){
	    for (i = 0; i < MATRIX_DIMENSION; i++)
	    {
	        for (j = 0; j < MATRIX_DIMENSION; j++)
	        {
	        	for (k = 0; k < MATRIX_DIMENSION; k++)
	                z[i][j] += x[i][k]*y[k][j];
	        }
	    }
    }
	end_time = (double)time(0);





	printf("Dylan Murphy\n");
	printf("CSI445 Program3\n");
	printf("CPU NAME: %s\n", CPU_NAME);
	printf("Compiler Optimization: -O3\n");


	printf("START:%d\n", start_time);
	printf("START:%d\n", end_time);
	ElapsedTime = ((end_time - start_time));
	printf("Measured Execution time %0.4e seconds \n\n", ElapsedTime);


	ElapsedTimePerMatrix = ElapsedTime/ACC_LOOP;
	printf("Execution time per Matrix  is:                          %0.4e  seconds\n", ElapsedTimePerMatrix);

	ElapsedTimePerMatrixElement = ElapsedTimePerMatrix/(MATRIX_DIMENSION*MATRIX_DIMENSION);

	printf("Execution time per Matrix Element  is:                          %0.4e  seconds\n", ElapsedTimePerMatrixElement);



	ElapsedTimePerOP = ElapsedTime/TotalOps;

	printf("Execution time per Operation  is:                          %0.4e  seconds\n", ElapsedTimePerOP);


	FLOPS = (TotalOps/ElapsedTime);
	printf("Estimated number of clock cycles per OP is            %0.2f  CPU Clock Cycles per OP\n", (CPU_CLK) / (FLOPS));
	printf("Estimated number of Ops per clock cycle is            %0.2f  OPs per CPU Clock Cycles\n", (FLOPS) / (CPU_CLK));
	printf("Estimated FLOPs per second is:                        %0.3e  OPs per second \n", FLOPS);





	free(x);
	free(y);
	free(z);
	return 0;
}


