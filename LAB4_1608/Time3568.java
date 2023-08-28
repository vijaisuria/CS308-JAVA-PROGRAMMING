import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Time3568 {
    public static String nextDay(String day)
    {
        if(day.equals("Sun"))
          return "Mon";
        if(day.equals("Mon"))
          return "Tue";
        if(day.equals("Tue"))
          return "Wed";
        if(day.equals("Wed"))
          return "Thu";
        if(day.equals("Thu"))
          return "Fri";
        if(day.equals("Fri"))
          return "Sat";
          
          return "Sun";
        
    }
    
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        String day;
        int hour,minute,sec;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter day:");
        day=in.nextLine();
        System.out.print("Enter hour:");
        hour = in.nextInt();
        System.out.print("Enter minute:");
        minute = in.nextInt();
        System.out.print("Enter second:");
        sec = in.nextInt();

        if(sec+1 <=59)
            sec+=1;
        else{
            sec =0;
            if(minute+1 <=  59)
                minute++;
            else
            {
                minute =0;
                if(hour+1<=23)
                    hour++;
                else
                {
                    hour = 0;
                    day=nextDay(day);
                }
            }
        }
        System.out.println(day+" "+hour+" "+minute+" "+sec);
        in.close();
    }
}


    
        