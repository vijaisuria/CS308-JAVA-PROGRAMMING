import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

class ProductAlreadyExistsException extends Exception {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class InsufficientQuantityException extends Exception {
    public InsufficientQuantityException(String message) {
        super(message);
    }
}

class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class AmazonStore {
    private Map<String, Product> productMap;
    private Set<String> productNames;
    private List<Product> cart;

    public AmazonStore() {
        productMap = new HashMap<>();
        productNames = new HashSet<>();
        cart = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity) throws ProductAlreadyExistsException {
        if (productNames.contains(name)) {
            throw new ProductAlreadyExistsException("Product with the same name already exists.");
        }

        Product product = new Product(name, price, quantity);
        productMap.put(name, product);
        productNames.add(name);
    }

    public void addToCart(String name, int quantity) throws ProductNotFoundException, InsufficientQuantityException {
        if (!productNames.contains(name)) {
            throw new ProductNotFoundException("Product not found.");
        }

        Product product = productMap.get(name);
        if (product.getQuantity() < quantity) {
            throw new InsufficientQuantityException("Insufficient quantity of " + name + " in stock.");
        }

        cart.add(new Product(name, product.getPrice(), quantity));
        product.quantity -= quantity;
    }

    public void listProducts() {
        System.out.println("Available Products:");
        for (Product product : productMap.values()) {
            System.out.println(
                    product.getName() + " - Price: $" + product.getPrice() + " - Quantity: " + product.getQuantity());
        }
    }

    public void viewCart() {
        System.out.println("Shopping Cart:");
        double total = 0;
        for (Product product : cart) {
            System.out.println(
                    product.getName() + " - Price: $" + product.getPrice() + " - Quantity: " + product.getQuantity());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total Price: $" + total);
    }
}

public class Main {
    public static void main(String[] args) {
        AmazonStore store = new AmazonStore();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a product");
            System.out.println("2. List products");
            System.out.println("3. Add products to the cart");
            System.out.println("4. View cart");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a product
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: $");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    try {
                        store.addProduct(name, price, quantity);
                    } catch (ProductAlreadyExistsException e) {
                        System.out.println("Product already exists.");
                        break;
                    }
                    break;

                case 2:
                    // List available products
                    store.listProducts();
                    break;

                case 3:
                    // Add products to the cart
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name to add to cart: ");
                    String cartName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int cartQuantity = scanner.nextInt();
                    try {
                        store.addToCart(cartName, cartQuantity);
                    } catch (ProductNotFoundException e) {
                        System.out.println("Product not found.");
                        break;
                    } catch (InsufficientQuantityException e) {
                        System.out.println("Insufficient quantity of " + cartName + " in stock.");
                        break;
                    }
                    break;

                case 4:
                    // View the shopping cart
                    store.viewCart();
                    break;

                case 5:
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
