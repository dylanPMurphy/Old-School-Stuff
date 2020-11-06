//Dylan Murphy
//001169162
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class newTestProjectile
{
  public static void main(String args[])
  {
    newProjectile wam = new newProjectile();//creates newProjectile object
    double inputVelocity = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter velocity, or -1 to quit."));
    while (inputVelocity != -1 && inputVelocity<=0)//first loop to initially test for non positive numbers and -1
    {
      inputVelocity = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter velocity, or -1 to quit."));
      //prompts user to input a velocity value or -1 to quit.  then it converts the string of numbers
      //that the user inputs and converts them to doubles
    }
      
    while(inputVelocity != -1)
      {
        wam.setVel(inputVelocity);
        //sets velcotiy for the newProjectile object
        double inputAngle=Double.parseDouble(JOptionPane.showInputDialog(null, "Enter angle."));
        while(inputAngle <= 0)//Nested loop to provide the user more entries if they enter a neon positive value
        {
          inputAngle = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter angle."));
        }  
        wam.setAngle(inputAngle);
        //prompts user to input an Angle value.  then it converts the string of numbers
        //that the user inputs and converts them to doubles
        //sets angle for the newProjectile object
      
        double inputSecs = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter seconds."));
        while(inputSecs <= 0)//Nested loop to provide the user more entries if they enter a non positive value
        {
        inputSecs = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter seconds."));
        }
        wam.setSecs(inputSecs);
        //prompts user to input  seconds.  Then it converts the string of numbers
        //that the user inputs and converts them to doubles
        //sets seconds for the newProjectile object
      
        wam.calcHeight();
        wam.calcDistance();
        //Calculates height and distance in the newProjectile object
      
        double dist = wam.getDistance();
        double secs = wam.getSecs();
        double height = wam.getHeight();
        //creates variables for our program to use in the showMessageDialog below
      
        DecimalFormat twoDigits = new DecimalFormat("0.00");//creates decimal format object to format our 
        //showMessageDialog below to display our calculations
        JOptionPane.showMessageDialog( null, "After " + twoDigits.format(secs) + " seconds, the projectile is at (in meters) \nHeight:" 
                                      + twoDigits.format(height) + "\nDistance:" + twoDigits.format(dist));
        //Shows messege dialog neatly in 2 decimal format to the user 
        inputVelocity = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter velocity, or -1 to quit."));
        while(inputVelocity<=0 && inputVelocity != 1)
        {
        inputVelocity = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter velocity, or -1 to quit."));
        }//last while loop to avoid an invalid entry from being computed when loop runs again

      }
  }
}


      
        