package LAB12_1810;

import java.time.LocalDate;
import java.time.LocalTime;

public class Wrapper3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        int a = 10;
        Integer aWrapper = a; // Autoboxing (int to Integer)
        int aUnboxed = aWrapper; // Unboxing (Integer to int)

        double d = 97.09D;
        Double dWrapper = d; // Autoboxing (double to Double)
        double dUnboxed = dWrapper; // Unboxing (Double to double)

        float f = 9.83F;
        Float fWrapper = f; // Autoboxing (float to Float)
        float fUnboxed = fWrapper; // Unboxing (Float to float)

        boolean b = true;
        Boolean bWrapper = b; // Autoboxing (boolean to Boolean)
        boolean bUnboxed = bWrapper; // Unboxing (Boolean to boolean)

        char c = 'a';
        Character cWrapper = c;
        char cUnboxed = cWrapper;

        System.out.println("Autoboxing and Unboxing Examples:");
        System.out.println("a: " + a + ", aWrapper: " + aWrapper + ", aUnboxed: " + aUnboxed);
        System.out.println("d: " + d + ", dWrapper: " + dWrapper + ", dUnboxed: " + dUnboxed);
        System.out.println("f: " + f + ", fWrapper: " + fWrapper + ", fUnboxed: " + fUnboxed);
        System.out.println("b: " + b + ", bWrapper: " + bWrapper + ", bUnboxed: " + bUnboxed);
        System.out.println("c: " + c + ", cWrapper: " + cWrapper + ", cUnboxed: " + cUnboxed);
    }
}






