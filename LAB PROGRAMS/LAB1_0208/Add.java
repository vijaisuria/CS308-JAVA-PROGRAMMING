import java.util.Scanner;
class Add {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number 1: ");
        int a=in.nextInt();
        System.out.println("Enter Number 2: ");
        int b=in.nextInt();
        System.out.print("The sum of two numbers " + a + " and " + b + " is " + (a+b));
        in.close();
    }
}
