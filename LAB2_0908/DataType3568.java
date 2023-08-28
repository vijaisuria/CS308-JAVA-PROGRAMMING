import java.time.*;

public class DataType3568 {
    public static void main(String args[]) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.print("Name: Vijai Suria M \nRegister Number: (2021503568)");

        byte byteValue1 = 127; // Correct
        // byte byteValue2 = 128; // Incorrect: Value exceeds the valid range (-128 to 127)
        //long longValue1 = 9223372036854775807; // Incorrect, require L at the end
        long longValue2 = 9223372036854775807L; // Correct
        // long longValue3 = 9223372036854775807; // Incorrect, require L at the end
        // long longValue4 = 9223372036854775808L; // Incorrect: Value exceeds the valid range

        // Floating-point data types
        float floatValue1 = 3.14f; // Correct
        //loat floatValue2 = 3.14; // Incorrect: Floating-point literals need 'f' or 'F' suffix

        // Boolean data type
        boolean booleanValue1 = true; // Correct
        //boolean booleanValue2= 0; // Incorrect: Use 'true' or 'false' for boolean values
    }
}
