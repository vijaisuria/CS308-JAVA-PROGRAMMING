import java.util.Scanner;
public class WordsCount3568 {
    public static void main(String args[]){
        //Write a java program to count the number of words in a string
        System.out.println("Current Date: " + java.time.LocalDate.now());
        System.out.println("Current Time: " + java.time.LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        s = sc.nextLine();
        int count = 1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                count++;
            }
        }
        System.out.println("Number of words in the string: " + count);
    }
}
