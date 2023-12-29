import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class Palindrome3568{
    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Enter a string: ");
        s = sc.nextLine();
        System.out.println(isPalindrome(s));
        sc.close();
    }
}