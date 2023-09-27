import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class Hangman3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        String words[] = { "java", "internship", "college", "computer", "github" };
        String hints[][] = {
                { "Widely used programming language", "Platform independence" },
                { "Temporary work experience", "Academic years" },
                { "Higher education institution", "Beyond high school" },
                { "Data processing device", "Calculations electronically" },
                { "Code collaboration platform", "Version control" }
        };

        Scanner in = new Scanner(System.in);

        int chances, length, mode;
        boolean k = true;
        while (k) {
            int clu = 0;
            Random rand = new Random();
            int ran = rand.nextInt(5);

            String tobe = words[ran];
            length = tobe.length();
            char[] actual = tobe.toCharArray();
            char[] guessword = new char[length];
            for (int i = 0; i < length; i++)
                guessword[i] = ' ';
            chances = length + (length / 3);

            boolean t = false;
            while (chances > 0) {
                for (int i = 0; i < length; i++) {
                    if (guessword[i] == ' ')
                        System.out.print("_ ");
                    else
                        System.out.print(guessword[i]);
                }
                System.out.println("\n" + chances + " chances left");
                char guess;

                if (clu <= 1) {
                    System.out.print("Enter 1 for clue, 2 for guessing:");
                    mode = in.nextInt();
                } else {
                    if (t == false)
                        System.out.println("No clues left");
                    t = true;
                    mode = 2;
                }
                if (mode == 1) {

                    System.out.println("Clue :" + hints[ran][clu]);

                    clu++;
                    chances--;
                } else {
                    in.nextLine();
                    System.out.println("Guess a letter : ");
                    guess = in.next().charAt(0);
                    chances--;
                    if (!(guess >= 'a' && guess <= 'z')) {
                        System.out.println("Invalid input. Only give small letter alphabets!");
                    } else {
                        for (int i = 0; i < actual.length; i++) {
                            if (guess == actual[i]) {
                                guessword[i] = actual[i];
                            }
                        }
                    }
                }
                boolean found = true;
                for (int i = 0; i < length; i++) {
                    if (guessword[i] == ' ') {
                        found = false;
                        break;
                    }
                }
                if (found == true) {
                    break;
                }

            }
            boolean f = true;
            for (int i = 0; i < length; i++) {
                if (guessword[i] == ' ') {
                    f = false;
                    break;
                }
            }
            if (f == true) {
                System.out.println("Congratulations!! You have found the word!!The word is " + tobe);
            } else {
                System.out.println("Chance over..!! Better luck next time");
            }
            int p = 0;
            System.out.print("Enter 0 to exit, 1 to play again:");
            p = in.nextInt();
            if (p == 0)
                k = false;

        }
        in.close();
    }
}
