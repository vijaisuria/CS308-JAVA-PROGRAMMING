import java.time.LocalDate;
import java.time.LocalTime;
import java.lang.Thread;
class Myclass implements Runnable
{
    public void run()
    {
        double result=0;
        for (int i = 0; i < 100000099; i++)
        {
            result = (i / 1.234566) * 1234.567890988;
        }
        System.out.println(result);
    }
}

public class Concurrent3568
{
    public static void main(String [] arg) throws Exception
    {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        final long startTime=System.currentTimeMillis();
        double result=0;
        for(long i=0; i< 100000099; i++)
        {
            result=(i/1.234566)*1234.567890988;
        }
        for(long i=0; i< 100000099; i++)
        {
            result=(i/1.234566)*1234.567890988;
        }
        final long endTime=System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Total Time (using traditional method) : " + (endTime-startTime));

        final long sTime = System.currentTimeMillis();
        Thread t1 = new Thread(new Myclass());
        Thread t2 = new Thread(new Myclass());
        t1.start();
        t2.start();
        if(t1.isAlive())
            t1.join();
        if(t2.isAlive())
            t2.join();
        final long eTime = System.currentTimeMillis();
        System.out.println("Total Time (using multithreading) : " + (eTime-sTime));
    }
}