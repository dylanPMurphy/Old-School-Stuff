import java.util.Scanner;

public class projectile
{
  public static void main(String args[])
  {
    Scanner userin = new Scanner(System.in);
    System.out.println("Please input a velocity in meters per second rounded to two decimal places.");
    double velocityIn = userin.nextDouble();
    System.out.println("Please input an angle in degrees rounded to two decimal places.");
    double angleIn = userin.nextDouble();
    System.out.println("Please input a time in seconds rounded to two decimal places.");
    double secondsIn = userin.nextDouble();
    double pI = 3.1415926;
    double rad = angleIn * (pI/180);
    double vFactor = velocityIn * Math.sin(rad) * secondsIn;
    double distance = velocityIn * Math.cos(rad) * secondsIn;
    double height = (-0.5 * (9.8 * (secondsIn*secondsIn))) + vFactor;
    System.out.printf("After %.2f seconds, the projectile is at (in meters) \nHeight: %.2f \nDistance: %.2f", secondsIn, height, distance);  
       
  }
}