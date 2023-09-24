import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class String3568{
    public static void main(String[] args){
       System.out.println("Current Date: " + LocalDate.now());
       System.out.println("Current Time: " + LocalTime.now());
       System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
       System.out.println("\n");
       String s1 = "Welcome to java";
       String s2 = s1;
       String s3 = new String("Welcome to java");
       String s4 = s1.intern();
    
     if(s1 == s2)
         System.out.println("1.String s1 and s2 are equal  checked using s1 == s2 ");
       else  System.out.println("1.String s1 and s2 are not equal checked using s1 == s2");
      if(s2 == s3)
         System.out.println("2.String s2 and s3 are equal checked using s2 == s3");
       else  System.out.println("2.String s2 and s3 are not equal checked using s2 == s3");
        if(s1.equals(s2))
         System.out.println("3.String s1 and s2 are equal checked using s1.equals(s2) ");
       else  System.out.println("3.String s1 and s2 are not equal checked using s1.equals(s2) ");
       if(s2.equals(s3))
         System.out.println("4.String s2 and s3 are equal checked using s2.equals(s3)");
       else  System.out.println("4.String s2 and s3 are not equal checked using s2.equals(s3) ");
        if(s1.compareTo(s2) == 0)
         System.out.println("5.String s1 and s2 are equal checked using s1.compareTo(s2) ");
       else  System.out.println("5.String s1 and s2 are not equal checked using s1.compareTo(s2) ");
       if(s2.compareTo(s3) == 0)
         System.out.println("6.String s2 and s3 are equal checked using s2.compareTo(s3)");
       else  System.out.println("6.String s2 and s3 are not equal checked using s2.compareTo(s3) ");
         if(s1 == s4)
         System.out.println("7.String s1 and s2 are equal  checked using s1 == s4 ");
       else  System.out.println("7.String s1 and s2 are not equal checked using s1 == s4");
       System.out.println("8. s1.charAt(0) : "+s1.charAt(0));
       System.out.println("9. s1.indexOf('j') : "+s1.indexOf('j'));
       System.out.println("10. s1.indexOf(\"to\") : "+s1.indexOf("to"));
       System.out.println("11. s1.lastIndexOf('a') : "+s1.lastIndexOf('a'));
       System.out.println("12. s1.lastIndexOf(\"o\",15) : "+s1.lastIndexOf('a'));
       System.out.println("13. s1.length() : " + s1.length());
       System.out.println("14. s1.substring(5) : " + s1.substring(5));
       System.out.println("15. s1.substring(5,11) : " + s1.substring(5,11));
       System.out.println("16. s1.startsWith(\"Wel\") : " + s1.startsWith("Wel"));
       System.out.println("17. s1.endsWith(\"java\") : " + s1.startsWith("java"));
        System.out.println("18.  s1.toLowerCase() : " +  s1.toLowerCase());
        System.out.println("19.  s1.toUpperCase() : " +  s1.toUpperCase());
        String s7 = " Welcome ";
        System.out.println("20. "+ s7+".trim()"+  " : " +s7.trim());
        System.out.println("21. s1.replace('o','T') : " + s1.replace('o','T') );
        System.out.println("22. s1.replaceAll(\"o\",\"T\") : " + s1.replace("o","T") );
        System.out.println("23. s1.replaceFirst(\"o\",\"T\") : " + s1.replaceFirst("o","T") );
        System.out.println("24. s1.toCharArray() : " );
        char ch[] = s1.toCharArray() ;
        for(char c : ch)
         System.out.print(c);
    }
}
