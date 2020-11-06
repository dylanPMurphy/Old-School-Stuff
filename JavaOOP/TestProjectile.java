//Dylan Murphy
//001169162
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class TestProjectile
{
  public static void main(String args[])
  {
    newProjectile wam = new newProjectile();//creates newProjectile object
    double inputVelocity = 0;//initiates the inputVelocity variable for the loop
    while (inputVelocity != -1)//controls the loop to execute as long as inputVelocity doesnt equal 1
    {
      
      inputVelocity = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter velocity, or -1 to quit."));
      //prompts user to input a velocity value or -1 to quit.  then it converts the string of numbers
      //that the user inputs and converts them to doubles
      
      if(inputVelocity == -1)//conditional statement terminating the loop if the user inputs -1
        
      {
        break;
      }
        
      wam.setVel(inputVelocity);
      //sets velcotiy for the newProjectile method
     
    
      double inputAngle = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter angle."));
      wam.setAngle(inputAngle);
       //prompts user to input an Angle value.  then it converts the string of numbers
      //that the user inputs and converts them to doubles
      //sets angle for the newProjectile method
      
      double inputSecs = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter seconds."));
      wam.setSecs(inputSecs);
       //prompts user to input  seconds.  Then it converts the string of numbers
      //that the user inputs and converts them to doubles
      //sets seconds for the newProjectile method
      
      wam.calcHeight();
      wam.calcDistance();
      //Calculates height and distance in the newProjectile class
      
      double dist = wam.getDistance();
      double secs = wam.getSecs();
      double height = wam.getHeight();
      //creates variables for our program to use in the showMessageDialog below
      
      DecimalFormat twoDigits = new DecimalFormat("0.00");//creates decimal format object to format our 
                                                          //showMessageDialog below to display our calculations
      JOptionPane.showMessageDialog( null, "After " + twoDigits.format(secs) + " seconds, the projectile is at (in meters) \nHeight:" 
                                      + twoDigits.format(height) + "\nDistance:" + twoDigits.format(dist));
      //Shows messege dialog neatly in 2 decimal format to the user 
    }

  }
}
      
        