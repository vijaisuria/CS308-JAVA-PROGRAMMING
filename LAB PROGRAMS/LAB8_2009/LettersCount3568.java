import java.util.Scanner;
public class LettersCount3568 {
    public static void main(String args[]){
        //Write a java program to count the occurence of each letters in a string
        System.out.println("Current Date: " + java.time.LocalDate.now());
        System.out.println("Current Time: " + java.time.LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s = sc.nextLine();
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                count[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                System.out.println((char)(i + 'a') + " occurs " + count[i] + " times");
            }
        }
        sc.close();
    }
}
