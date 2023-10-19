package LAB12_1810;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    int id;
    String name;
    Double price;

    Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}

public class ProductList3568 {
    public static void main(String args[]) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        List<Product> products = new ArrayList<Product>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a product");
            System.out.println("2. List all products");
            System.out.println("3. Search for a product by ID");
            System.out.println("4. Remove a product");
            System.out.println("5. Update the price of a product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a product
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    Product product = new Product(id, name, price);
                    products.add(product);
                    break;

                case 2:
                    // List all products
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    // Search for a product by ID
                    System.out.print("Enter product ID to search: ");
                    int searchId = scanner.nextInt();
                    for (Product p : products) {
                        if (p.id == searchId) {
                            System.out.println("Found: " + p);
                            break;
                        }
                    }
                    break;

                case 4:
                    // Remove a product by ID
                    System.out.print("Enter product ID to remove: ");
                    int removeId = scanner.nextInt();
                    products.removeIf(p -> p.id == removeId);
                    break;

                case 5:
                    // Update the price of a product by ID
                    System.out.print("Enter product ID to update price: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter the new price: ");
                    double newPrice = scanner.nextDouble();
                    for (Product p : products) {
                        if (p.id == updateId) {
                            p.price = newPrice;
                            System.out.println("Price updated.");
                            break;
                        }
                    }
                    break;

                case 6:
                    // Exit the program
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
