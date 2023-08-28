import java.util.Scanner;
class Welcome{
	public static void main(String args[]){
		String name;
		long reg;

		Scanner input = new Scanner(System.in);

		System.out.println("Enter your Name: ");
		name = input.nextLine();
		System.out.println("Enter your Register Number: ");
		reg = input.nextLong();

		System.out.println("Welcome " + name +"\n Your register is " + reg);
		input.close();
	}
}

	