import java.time.LocalDate;
import java.time.LocalTime;

public class StackOverflow3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        recursiveMethod(0);
    }

    public static void recursiveMethod(int depth) {
        System.out.println("Depth: " + depth);
        //recursiveMethod(depth + 1);
    }
}
