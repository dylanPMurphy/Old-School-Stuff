
//Dylan Murphy
//001169162
//The class newProjectile allows a client to input values of
//velocity, seconds, angle, distance and height to calculate and return 
//height and distance values.  If the client wants to see values for any
//variable it should use the "System.out.println(" object to print values
//for get methods.
public class newProjectile
{
  private double velocity = 0;//-Instance---
  private double seconds = 0;//---Variables---
  private double angle = 0;//------with------
  private double height = 0;//--No Argument----
  private double distance = 0;//-Contructors--
  
  public double getVel()//returns client with velocity value
  {
    return velocity;
  }
  
  public double getHeight()//returns client with height value
  {
    return height;
  }
  
  public double getSecs()//returns client with seconds value
  {
    return seconds;
  }
  
  public double getAngle()//returns client with angle value
  {
    return angle;
  }
  
  public double getDistance()//returns client with distance value
  {
    return distance;
  }
  
  public void setVel(double v)//allows client to set a velocity to be calculated later
  {
    velocity = v;
  }
  
  public void setSecs(double s)//allows client to set seconds to be calculated later
  {
     seconds = s;
     }
  
  public void setAngle(double a)//allows client to set an angle to be calculated later
  {
    angle = a;
  }
  
  public void setHeight(double h)//allows client to set a height to be calculated later
  {
    height = h;
  }
  
  public void setDistance(double d)//allows client to set a distance to be calculated later
  {
    distance = d;
  }
  
  public double calcDistance()//calculates Distance using variables inputed by the client
  {
    double pI = 3.1415926;
    double rad = angle * (pI/180);
    distance = velocity * Math.cos(rad) * seconds;
    return distance;
 
  }
 
  public double calcHeight()//calculates Distance using variables inputed by the client
  {
    double pI = 3.1415926;
    double rad = angle * (pI/180);
    double vFactor = velocity * Math.sin(rad) * seconds;
    height = (-0.5 * (9.8 * (seconds*seconds))) + vFactor;
    return height;
  }//end of main method
}//end of class defn
  
 
  

                   