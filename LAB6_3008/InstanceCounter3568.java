import java.time.LocalDate;
import java.time.LocalTime;

class InstanceCounter {
    private static int instanceCount = 0;
    private int nonStaticCount = 0;  
    
    public InstanceCounter() {
        instanceCount++;  
        nonStaticCount++;             
    }
    
    public static int getInstanceCount() {
        return instanceCount;              
    }
    
    public int getNonStaticCount() {
        return nonStaticCount;           
    }
}

public class InstanceCounter3568 {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        InstanceCounter obj1 = new InstanceCounter();
        InstanceCounter obj2 = new InstanceCounter();
        InstanceCounter obj3 = new InstanceCounter();
        
        System.out.println("Total instances created: " + InstanceCounter.getInstanceCount());
        System.out.println("Non-static count for obj1: " + obj1.getNonStaticCount());
        System.out.println("Non-static count for obj2: " + obj2.getNonStaticCount());
        System.out.println("Non-static count for obj3: " + obj3.getNonStaticCount());
    }
}
