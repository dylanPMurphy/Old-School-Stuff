import java.text.DecimalFormat;
public class watch
{
  private int hours = 0;
  private int minutes = 0;
  private int seconds = 0;
  private String aMpM = "AM";
  
  public void watch(int h, int m, int s)
  {
    
    if( 0 <= h && h<=23 && 0 <= m && m<=59 &&0 <= s && s<=59)
    {
      hours = h;
      minutes = m;
      seconds = s;
    }
    else
    {
      hours = 0;
      minutes = 0;
      seconds = 0;
    }
    
    if (hours>=12){
     aMpM = "PM";
    }
    else{
      aMpM = "AM";
    }
  }  
    
    
  public String toString()
  {
    DecimalFormat milTime = new DecimalFormat("00");
    return milTime.format(hours) + ":" + milTime.format(minutes) + ":" + milTime.format(seconds) + aMpM;
  }
  
  public boolean Set(int h, int m, int s){
    
    
    if( 0 <= h && h<=23 && 0 <= m && m<=59 &&0 <= s && s<=59)
    {
      hours = h;
      minutes = m;
      seconds = s;
      return true;
    }
    else
    {
      hours = 0;
      minutes = 0;
      seconds = 0;
      return false;
    }
    
    
  }
  
  
  
  public void Increase()
  {
    seconds ++;
    if (seconds > 59)
    {
      seconds = 0;
      minutes++;
    }
    if (minutes>59)
    {
      minutes = 0;
      hours ++;
    }
    if (hours>23)
    {
      hours=0;
    }
    if (hours>=12){
     aMpM = "PM";
    }
    else{
      aMpM = "AM";
    }
    
  }
  public void Decrease()
  {
    seconds --;
    if (seconds<0)
    {
      seconds = 59;
      minutes --;
    }
    if (minutes < 0){
      minutes = 59;
      hours--;
    }
    if (hours<0){
      hours = 23;
  
  }
     if (hours>=12){
     aMpM = "PM";
    }
    else{
      aMpM = "AM";
    }
   
    
  }  
    
    
}

    