public class TestWatch
{
  public static void main( String args[] )
  {
    watch time1 = new watch();
    watch time2 = new watch();
    watch time3 = new watch();
    int h = 23; int m = 59; int s = 58;
    time2.watch(h, m, s);
    time3.watch(h, m, s);
    
    System.out.println(time1.toString());
    System.out.println(time2.toString());
    System.out.println(time3.toString());
    time1.Set(25,0,0);
    if (time1.Set(25,0,0) == false)
    {
      System.out.println("Invalid time");
    }
    for(int i=0; i<10; i++)
    {
      time2.Increase();
      System.out.println(time2.toString());
    }
    for(int y=0; y<10; y++)
    {
      time2.Decrease();
      System.out.println(time2.toString());
    }
  }
}