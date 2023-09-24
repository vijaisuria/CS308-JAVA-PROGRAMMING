import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DictionaryPL3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        // Define a 2D string array to store programming languages and their definitions
        String[][] programmingLanguages = {
            {"Java", "Pure object-oriented programming language by James Gosling"},
            {"C++", "Object-oriented programming language by Stroustrup"},
            // Add definitions for more programming languages here
            {"Python", "High-level programming language known for its simplicity"},
            {"JavaScript", "Scripting language commonly used for web development"},
            {"C#", "Object-oriented language developed by Microsoft"},
            {"Ruby", "Dynamic, reflective, and object-oriented language"},
            {"Swift", "Apple's programming language for iOS and macOS development"},
            {"Kotlin", "Modern statically-typed language for Android development"},
            {"Go", "Concurrent and statically typed language developed by Google"},
            {"Rust", "Systems programming language focused on safety and performance"}
        };

        Scanner sc = new Scanner(System.in);
        // Example input programming language name
        System.out.print("Enter the Programming Language: ");
        String inputLanguage = sc.nextLine(); // Change this to the language you want to look up

        // Call the method to get the definition and print it
        String definition = getDefinition(programmingLanguages, inputLanguage);
        if (definition != null) {
            System.out.println(inputLanguage + " - " + definition);
        } else {
            System.out.println("Programming language not found in the dictionary.");
        }
    }

    // Method to retrieve the definition for a given programming language
    public static String getDefinition(String[][] languages, String languageName) {
        for (String[] language : languages) {
            if (language[0].equalsIgnoreCase(languageName)) {
                return language[1];
            }
        }
        return null; // Return null if the language is not found
    }
}
