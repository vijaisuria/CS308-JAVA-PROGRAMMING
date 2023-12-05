import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Collection {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> myList = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        myList.add("Mango");

        l2.add("Banana");
        l2.add("Apple");

        // Printing the ArrayList
        System.out.println("ArrayList: " + myList);

        // Accessing elements by index
        System.out.println("Element at index 2: " + myList.set(2, "Vj"));

        // Checking if an element exists in the ArrayList
        System.out.println("Contains 'Banana': " + myList.contains("Banana"));

        // Finding the index of an element
        System.out.println("Index of 'Orange': " + myList.indexOf("Orange"));

        // Removing an element
        myList.remove("Mango");
        System.out.println("After removing 'Mango': " + myList);

        // Size of the ArrayList
        System.out.println("Size of ArrayList: " + myList.size());

        // Checking if the ArrayList is empty
        System.out.println("Is ArrayList empty? " + myList.isEmpty());


        System.out.println(myList);
        String[] s = myList.toArray(new String[myList.size()]);
        for(String s1:s){
            System.out.print(s1 + " - ");
        }


        // Clearing the ArrayList
        myList.clear();
        System.out.println("\nArrayList after clearing: " + myList);


        LinkedList<String> originalList = new LinkedList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Orange");

        // Creating a shallow copy using clone()
        LinkedList<String> clonedList = (LinkedList<String>) originalList.clone();

        // originalList.set(0,"pee");
        // Modifying the cloned list
        clonedList.add("Mango");

        System.out.println("Original List: " + originalList);
        System.out.println("Cloned List: " + clonedList);


        System.out.println("Original List: [0] " + originalList.get(0).hashCode());
        System.out.println("Cloned List: [0] " + clonedList.get(0).hashCode());
    }
}
