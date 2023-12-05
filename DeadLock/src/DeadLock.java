import java.time.LocalDate;
import java.time.LocalTime;

class Coin{
    public static boolean pickUp=false;
}
public class DeadLock {
    public static void main(String a[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        Thread T1=new Thread(()->{Player1("Player 1");
            //pickHealthPack("Player 1");
            });
        Thread T2=new Thread(()->{Player2("Player 2");
            //pickHealthPack("Player 2");
            });
        T1.start();
        T2.start();


    }

    public static void Player1(String Player) {
        while(!Coin.pickUp) {
            Coin.pickUp=true;
            System.out.println(Player + " trying to pickup Coin");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(Player + " have pickedup the Coin");
            Coin.pickUp=false;
        }


        System.out.println(Player + "waiting for");

    }
    public static void Player2(String Player) {
        while(!Coin.pickUp) {
            Coin.pickUp=true;
            System.out.println(Player + " trying to pickup Coin");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(Player + " have pickedup the Coin");
            Coin.pickUp=false;
        }


        System.out.println(Player + "waiting for");

    }



}
