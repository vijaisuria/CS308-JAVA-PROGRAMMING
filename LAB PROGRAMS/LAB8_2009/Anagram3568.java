import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Arrays;
public class Anagram3568 {
    public static boolean areAnagrams(String str1, String str2) {
        // Remove all whitespace and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert the strings to char arrays and sort them
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted char arrays
        return Arrays.equals(charArray1, charArray2);
    }
    public static void main(String args[]){
        //Write a java program to check the given string is anagram or not
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner sc = new Scanner(System.in);
        String s1, s2;  
        System.out.print("Enter first string: ");
        s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        s2 = sc.nextLine();
        if(areAnagrams(s1, s2)){
            System.out.println("The given strings are anagrams");
        }else{
            System.out.println("The given strings are not anagrams");
        }
        sc.close();
    }
}
