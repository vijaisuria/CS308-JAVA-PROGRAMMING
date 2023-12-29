import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class User {
    private String name;
    private String item;

    public User(String name, String item) {
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

public class ProducerConsumer {
    public static void main(String[] args) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568) \n");

        BlockingQueue<User> shoppingCart = new ArrayBlockingQueue<>(5);

        // Producer thread (customers adding items to the shopping cart)
        Thread producer = new Thread(() -> {
            try {
                shoppingCart.put(new User("User 1", "Shoes"));
                shoppingCart.put(new User("User 2", "T-shirt"));
                shoppingCart.put(new User("User 3", "Jeans"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread (checkout process)
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    User customer = shoppingCart.take();
                    System.out.println("Checkout for " + customer.getName() + ": " + customer.getItem());
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
