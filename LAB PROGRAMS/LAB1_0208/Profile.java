import java.util.Scanner;
class Profile{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = in.nextLine();
        System.out.println("Enter your register number: ");
        int reg = in.nextInt();
        System.out.println("Enter your phone  number: ");
        String phone = in.next();
        System.out.println("Enter your Address: ");
        String address = in.next();
        address += in.nextLine();

        System.out.println("Hello " + name + " Your register number is " + reg );
        System.out.println("Your Phone number is " + phone);
        System.out.println("Your are residing in the following address: "+address);
        in.close();
    }
}