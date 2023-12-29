import java.time.LocalDate;
import java.time.LocalTime;

class Car {
    public String myCar;
    Car(){
        this.myCar="null";
        System.out.println("car object initialized with default constructor ");
    }
    Car(String myCar){
        this.myCar=myCar;
        System.out.println("car object initialized with parameterised constructor ");
    }
    public String getMyCar(){
        return myCar;
    }
    public String getMyCar(String name){
        return "Your name: "+ name + "\n Your car name:" + myCar;
    }
    public String getMyCar(String name,int id){
        return "Your name and ID: "+ name + "\t" + id + "\n Your car name:" + myCar;
    }
    public String getMyCar(int id){
        return "Your Id: "+ id + "\n Your car name:" + myCar;
    }
}
public class Overloading3568 {
    public static Car mergeObject(Car obj1, Car obj2){
        Car result = new Car();
        result.myCar = obj1.myCar + " " + obj2.myCar;
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Car obj1 = new Car("Audi");
        Car obj2 = new Car("BMW");
        Car result = mergeObject(obj1,obj2);   
        System.out.println(result.getMyCar("Vijai"));
        System.out.println(result.getMyCar("Vijai",2021503568));
        System.out.println(result.getMyCar(2021503568));
        System.out.println(result.getMyCar());
    }
}
