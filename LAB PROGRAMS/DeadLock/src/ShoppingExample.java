import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Customer {
    private String name;
    private String item;

    public Customer(String name, String item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }
}

public class ShoppingExample {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");
        BlockingQueue<Customer> shoppingCart = new ArrayBlockingQueue<>(5);

        // Producer thread (customers adding items to the shopping cart)
        Thread producer = new Thread(() -> {
            try {
                shoppingCart.put(new Customer("Alice", "Shoes"));
                shoppingCart.put(new Customer("Bob", "T-shirt"));
                shoppingCart.put(new Customer("Charlie", "Jeans"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread (checkout process)
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Customer customer = shoppingCart.take();
                    System.out.println("Checkout for " + customer.getName() + ": " + customer.getItem());
                    // Simulate the checkout process (payment and order processing)
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
