import java.time.LocalDate;
import java.time.LocalTime;

class User {
    protected String name;
    protected String phoneNumber;
    protected String status;

    // Constructor for User class
    public User(String name, String phoneNumber, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }
}

class Contact extends User {
    protected User[] contacts;
    protected int contactCount;

    // Constructor for Contact class
    public Contact(String name, String phoneNumber, String status, int maxContacts) {
        super(name, phoneNumber, status);
        this.contacts = new User[maxContacts];
        this.contactCount = 0;
    }

    // Method to add a contact
    public void addContact(User user) {
        if (contactCount < contacts.length) {
            contacts[contactCount] = user;
            contactCount++;
            System.out.println(name + " added " + user.name + " to contacts.");
        } else {
            System.out.println("Contact list is full. Cannot add more contacts.");
        }
    }
}

class Message {
    protected User sender;
    protected User receiver;
    protected String messageContent;

    // Constructor for Message class
    public Message(User sender, User receiver, String messageContent) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageContent = messageContent;
    }
}

class Chat {
    private User[] participants;
    private Message[] messages;
    private int messageCount;

    // Constructor for Chat class
    public Chat(User user1, User user2, int maxMessages) {
        this.participants = new User[]{user1, user2};
        this.messages = new Message[maxMessages];
        this.messageCount = 0;
    }

    // Method to add a message to the chat
    public void addMessage(Message message) {
        if (messageCount < messages.length) {
            messages[messageCount] = message;
            messageCount++;
        } else {
            System.out.println("Chat history is full. Cannot add more messages.");
        }
    }

    // Method to display the chat history
    public void displayChatHistory() {
        System.out.println("Chat History between " + participants[0].name + " and " + participants[1].name);
        for (int i = 0; i < messageCount; i++) {
            System.out.println(participants[0].name + ": " + messages[i].messageContent);
            System.out.println(participants[1].name + ": " + messages[i].messageContent);
        }
    }
}

public class WhatsApp3568 {
    public static void main(String[] args) {
        // Displaying current date and time
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        System.out.println("****************************** \n");

        // Creating User, Contact, and Message objects
        User alice = new User("Alice", "+1234567890", "Available");
        User bob = new User("Bob", "+9876543210", "Away");
        Contact aliceContacts = new Contact("Alice", "+1234567890", "Available", 10);
        aliceContacts.addContact(bob);

        Message message1 = new Message(alice, bob, "Hi, Bob!");
        Message message2 = new Message(bob, alice, "Hello, Alice!");

        // Creating a Chat object and adding messages
        Chat chat = new Chat(alice, bob, 100);
        chat.addMessage(message1);
        chat.addMessage(message2);

        // Displaying chat history
        chat.displayChatHistory();
    }
}
