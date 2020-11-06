 
import java.text.DecimalFormat; 
  //-------------------------------------------- 
  //-------Start of Subclass betterClass--------
  //--------------------------------------------
  public class betterWatch extends Watch
  {
    
    private int days;//-------------|
    private int months;//-----------|-Insance variables
    private int year;//-------------|
    private int febDays = 28;//-----|
    private int[] daysInMonth = {0, 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//Calendar array
    
    public betterWatch()//No Argument
    {
      
      super();
      days= 1;
      months=1;
      year=1980;
    }
    private boolean leapyr(int yrs)//Leap Year (true/false)
    {
      if ((yrs % 4 == 0) && (yrs % 100 != 0) || (yrs % 400 == 0))
      {
        return true;
      }
      else 
      {
        return false;
      }
    }
    
    
    public boolean setWatch(int hrs, int mins, int secs, int mon, int dy, int yr)//(Watch Setter)
    {
      if(super.Set(hrs, mins, secs)==true){
        
      if ( leapyr(yr) == true)//leap year check
        {
          febDays = 29;
        }
        else
        {
          febDays= 28;
        }
     
      if(dy>0 && dy<daysInMonth[mon] && mon>1 && mon<=12)
      {
        months = mon;//---|
        days = dy;//------|-setting watch
        year = yr;//------|
        return true;//----|
      }
      else{
        return false;
      }
      }
      else{
        return false;
      }
      
 
    }
    
    public void increaseDay()
    {
      days ++;
      if (days>=daysInMonth[months])
      {
        months ++;
        days = 1;
      }
      if(months>=12)
      {
        year ++;
        months = 1;
      }
    }
    public void decreaseDay()
    {
      days --;
      if (days<=0)
      {
        months --;
        days = daysInMonth[months];
      }
      if (months<=1)
      {
        year --;
        months = 12;
        days = daysInMonth[months];
      }
    }
    
    
    
    public void increaseSecond()
    {
    super.Increase();//hours mins secs controls from superclass
    if (hours>23)
    {
      
      days ++;
      if (days>=daysInMonth[months])
      {
        months ++;
        days = 1;
      }
      if(months>=12)
      {
        year ++;
        months = 1;
      }
    }
    
    
    
    
  }
  public void decreaseSecond()
  {
   
    super.Decrease();//hours mins secs controls from superclass
    if (hours<0)
    {
      days --;
      if (days<=0)
      {
        months --;
        days = daysInMonth[months];
      }
      if (months<=1)
      {
        year --;
        months = 12;
        days = daysInMonth[months];
      }
    }
    
   
    
  }
  public String showWatch()
  {
    return super.toString() + " " + String.format("%02d/%02d/%04d ", months, days, year);
  }
 }