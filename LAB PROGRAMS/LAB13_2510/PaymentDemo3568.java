import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

interface Payment {

    void makePayment(double amount) throws InvalidPaymentOptionException, InsufficientBalanceException;

    void recievePayment(double amount);

    double getAccountBalance();
}

interface DebitCardPayment extends Payment {
    public default void makePayment(double amount) throws InvalidPaymentOptionException, InsufficientBalanceException {
        System.out.println("making payment through Debit Card");
    }

    void withdrawCash(double amount) throws InsufficientBalanceException;
}

interface GPayPayment extends Payment {
    public default void makePayment(double amount) throws InvalidPaymentOptionException, InsufficientBalanceException {
        System.out.println("making payment through Google Pay");
    }

    void rewardPoints();
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String s) {
        super(s);
    }
}

class InvalidPaymentOptionException extends Exception {
    InvalidPaymentOptionException(String s) {
        super(s);
    }
}

class User implements DebitCardPayment, GPayPayment {
    double accountBalance = 1000;

    User(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void makePayment(double amount) throws InvalidPaymentOptionException, InsufficientBalanceException {
        System.out.println("1) Debit Card payment ");
        System.out.println("2) Google card pay ");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter your choice of Payment: ");
        int choice = in.nextInt();

        switch (choice) {
            case 1 -> {
                if (accountBalance <= amount) {
                    throw new InsufficientBalanceException("Not sufficient balance");
                } else {
                    DebitCardPayment.super.makePayment(amount);
                    accountBalance -= amount;
                    System.out.println("Payment made through debit card: " + amount);
                    System.out.println("Total available balance: " + accountBalance);
                }
            }
            case 2 -> {
                if (accountBalance <= amount) {
                    throw new InsufficientBalanceException("Not sufficient balance");
                } else {
                    GPayPayment.super.makePayment(amount);
                    accountBalance -= amount;
                    System.out.println("Payment made through Google Pay: " + amount);
                    System.out.println("Total available balance: " + accountBalance);
                }
            }
            default -> throw new InvalidPaymentOptionException("Enter the vaild options");
        }
    }

    @Override
    public void rewardPoints() {
        System.out.println("Recieved reward points through Gpay payment");
    }

    @Override
    public void withdrawCash(double amount) throws InsufficientBalanceException {
        if (accountBalance <= amount) {
            throw new InsufficientBalanceException("Not sufficient balance");
        } else {
            accountBalance -= amount;
            System.out.println("Amount withdrawn through debit card: " + amount);
            System.out.println("Total available balance: " + accountBalance);
        }
    }

    public void recievePayment(double amount) {
        accountBalance += amount;
        System.out.println("Amount recieved Rs." + amount);
        System.out.println("Total available balance: " + accountBalance);
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}

public class PaymentDemo3568 {
    public static void main(String args[]) {
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        User user = new User(1000);
        Scanner scanner = new Scanner(System.in);
        double amount;

        while (true) {
            try {
                System.out.println("Menu Card:");
                System.out.println("1. Make Payment");
                System.out.println("2. Reward Points");
                System.out.println("3. Withdraw Cash");
                System.out.println("4. Receive Payment");
                System.out.println("5. Get Account Balance");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter payment amount: ");
                        amount = scanner.nextDouble();
                        user.makePayment(amount);
                        break;

                    case 2:
                        System.out.println("Earned reward points for the GPay transaction.");
                        user.rewardPoints();
                        break;

                    case 3:
                        System.out.print("Enter cash withdrawal amount: ");
                        amount = scanner.nextDouble();
                        user.withdrawCash(amount);
                        break;

                    case 4:
                        System.out.print("Enter received payment amount: ");
                        amount = scanner.nextDouble();
                        user.recievePayment(amount);
                        break;

                    case 5:
                        System.out.println("Available balance: " + user.getAccountBalance());
                        break;

                    case 6:
                        System.out.println("Exiting the menu.");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            } catch (InsufficientBalanceException e) {
                System.out.println("Insufficient Balance: " + e.getMessage());
            } catch (InvalidPaymentOptionException e) {
                System.out.println("Invalid Payment Option: " + e.getMessage());
            }
        }

    }
}