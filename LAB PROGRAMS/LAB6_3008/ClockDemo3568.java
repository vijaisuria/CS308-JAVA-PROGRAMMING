import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

class Clock{
    private int hour;
    private int minute;
    private int second;
    Clock(){
        hour = 12;
        minute = 0;
        second = 0;
    }
    Clock(int h, int m, int s){
        hour = h;
        minute = m;
        second = s;
    }
    Clock(int secondsFromMindnight){
        hour = secondsFromMindnight / 3600;
        minute = (secondsFromMindnight % 3600) / 60;
        second = (secondsFromMindnight % 3600) % 60;
    }
    public void setClock(int secondsFromMindnight){
        hour = secondsFromMindnight / 3600;
        minute = (secondsFromMindnight % 3600) / 60;
        second = (secondsFromMindnight % 3600) % 60;
    }
    public int getHours(){
        return hour;
    }
    public int getMinutes(){
        return minute;
    }
    public int getSeconds(){
        return second;
    }
    public void setHours(int h){
        hour = h;
    }
    public void setMinutes(int m){
        minute = m;
    }
    public void setSeconds(int s){
        second = s;
    }
    public void tick(){
        second++;
        if(second == 60){
            second = 0;
            minute++;
            if(minute == 60){
                minute = 0;
                hour++;
                if(hour == 24){
                    hour = 0;
                }
            }
        }
    }
    public void tickDown(){
        second--;
        if(second == -1){
            second = 59;
            minute--;
            if(minute == -1){
                minute = 59;
                hour--;
                if(hour == -1){
                    hour = 23;
                }
            }
        }
    }
    public Clock addClock(Clock A){
        int s = this.second + A.getSeconds();
        int m = this.minute + A.getMinutes();
        int h = this.hour + A.getHours();
        while(s >= 60){
            s-=60;
            m++;
        }
        while(m >= 60){
            m-=60;
            h++;
        }
        if(h>=24)
            h=0;
        Clock res = new Clock(h,m,s);
        return res;
    }
    public Clock subtractClock(Clock A){
        int h = hour - A.getHours();
        int m = minute - A.getMinutes();
        int s = second - A.getSeconds();
        if(s < 0){
            s += 60;
            m--;
        }
        if(m < 0){
            m += 60;
            h--;
        }
        if(h < 0){
            h += 24;
        }
        Clock res = new Clock(h, m, s);
        return res;
    }
    public void show(){
        System.out.println(hour + ":" + minute + ":" + second);
    }
}

public class ClockDemo3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of seconds from midnight: ");
        int secondsFromMindnight = in.nextInt();
        Clock b = new Clock(secondsFromMindnight);
        Clock a = new Clock();
        System.out.print("Clock 1:");
        a.show();
        System.out.print("Clock 2:");
        b.show();
        Clock c = a.subtractClock(b);
        System.out.print("Clock 3 => Clock_1 - Clock_2 = ");
        c.show();
        in.close();
    }
}