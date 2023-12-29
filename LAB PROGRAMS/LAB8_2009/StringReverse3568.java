import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;;
public class StringReverse3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Enter a string: ");
        s = sc.nextLine();
        char[] charArray = s.toCharArray();

        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - 1 - i];
            charArray[length - 1 - i] = temp;
        }

        String reversedString = new String(charArray);
        System.out.println("Reversed String: " + reversedString);

        sc.close();
    }
}
