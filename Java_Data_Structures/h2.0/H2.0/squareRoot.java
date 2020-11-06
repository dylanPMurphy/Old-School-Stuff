/*
 * Dylan Murphy Homework 2 Recursion
 * 
 * This class will compute to within a reasonable error the square root of any real number
 * The algorithm does this with the use of the Babylonian Method for calculating square roots
 * I've added some text based reporting so the user can see the algorithm in action at every iteration
 */
import java.lang.Math;
public class squareRoot {
	private double source;
	private double guess;
	private double nextGuess;
	private double error;
	private double acceptableError;
	public squareRoot(double a, double b){
		source = a;
		acceptableError = b;
		guess = source/2;
		error = Math.abs(source - (guess*guess));//Absolute value needed to compute the difference 
		System.out.println("Input Accepted:" + source);
		newGuess(guess);
		System.out.println("<:>----------End of calculation------------<:>");
			
		
	}
	//------------------------Recursive Method--------------------------------
	public void newGuess(double i)
	{
		System.out.println("...");
		
		
		if (error <= acceptableError)
		{
			if(nextGuess == 0){//This is made to catch the exception where source is a perfect square
				System.out.println(guess);
			}
			else{
				System.out.println(nextGuess);
			}
			return;
		}
		else//if the error isn't small enough this code will run until an acceptable error is found
		{
			System.out.println("nextGuess:"+ nextGuess);
			System.out.println("error:"+ error);
			nextGuess = 0.5*(i+(source/i));
			error = Math.abs(source - (nextGuess*nextGuess));
			newGuess(nextGuess);//<---------There's the recursion 
			
		}
	}
	public static void main(String []args){
		new squareRoot(81, 0.00002);
		
		new squareRoot(52378237, 0.00002);
		
		new squareRoot(4, .1);
		
		new squareRoot(0.23422345, .0000000000000001);
		
	}
}
	

