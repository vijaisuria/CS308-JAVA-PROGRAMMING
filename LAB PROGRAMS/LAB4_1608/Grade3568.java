import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Grade3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of Subject: ");
        int n = in.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter the Subject marks (space seperated): ");
        for(int i=0;i<n;i++){
            marks[i] = in.nextInt();
        }

        System.out.println("Grade Reports:");
        for(int i=0;i<n;i++){
            if(marks[i]>=90 && marks[i]<=100)
                System.out.println("Subject-"+ (i+1)+" Grade: O");
            else if(marks[i]>=80 && marks[i]<=89)
                System.out.println("Subject-"+ (i+1)+" Grade: A+");
            else if(marks[i]>=70 && marks[i]<=79)
                System.out.println("Subject-"+ (i+1)+" Grade: A");
            else if(marks[i]>=60 && marks[i]<=69)
                System.out.println("Subject-"+ (i+1)+" Grade: B+");
            else if(marks[i]>=50 && marks[i]<=59)
                System.out.println("Subject-"+ (i+1)+" Grade: B");
            else if(marks[i]>=0 && marks[i]<=49)
                System.out.println("Subject-"+ (i+1)+" Grade: U");
            else
                System.out.println("Subject-"+ (i+1)+" Invalis Marks");
        }

        in.close();
    }
}