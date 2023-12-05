import static java.lang.Thread.currentThread;
import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTicket {
    public static int ticketCount = 10;

    public static void main(String[] a) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        System.out.println("\n");

        Thread user1 = new Thread(() -> bookTicket("J", 2));
        Thread user2 = new Thread(() -> bookTicket("S", 2));
        Thread user3 = new Thread(() -> bookTicket("K", 2));
        Thread user31 = new Thread(() -> bookTicket("E", 2));
        Thread user32 = new Thread(() -> bookTicket("P", 2));
        Thread user323 = new Thread(() -> bookTicket("U", 2));


        user1.start();
        user2.start();
        user3.start();
        user31.start();
        user32.start();
        user323.start();
    }

    public static  void bookTicket(String user, int bookingCount) {
        if (bookingCount > ticketCount) {
            System.out.println("Ticket Full");
            System.out.println(user + " " + "Sorry ticket not booked count " + bookingCount);
        }
         else {
            if (ticketCount >= bookingCount) {
                ticketCount -= bookingCount;
                System.out.println(user + " " + "ticket booked count " + bookingCount);
                System.out.println("total remaining" + ticketCount);
            }


        }
    }
}

