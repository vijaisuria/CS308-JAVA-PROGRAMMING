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