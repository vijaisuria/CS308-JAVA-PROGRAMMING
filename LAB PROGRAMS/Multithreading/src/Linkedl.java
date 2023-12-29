import java.util.LinkedList;

class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

public class Linkedl {
    public static void main(String[] args) {
        LinkedList<Fruit> originalList = new LinkedList<>();
        originalList.add(new Fruit("Apple"));
        originalList.add(new Fruit("Banana"));
        originalList.add(new Fruit("Orange"));

        // Creating a shallow copy using clone()
        LinkedList<Fruit> clonedList = (LinkedList<Fruit>) originalList.clone();


        System.out.println("b4 Original List: " + originalList.get(0));

        // Modifying the cloned list
        if (!clonedList.isEmpty()) {
            Fruit fruit = clonedList.get(0);
            fruit.setName("Modified Apple");
        }

        System.out.println("Original List: " + originalList);
        System.out.println("Cloned List: " + clonedList);

        LinkedList<Integer> originalList1 = new LinkedList<>();
        originalList1.add(10);
        originalList1.add(20);
        originalList1.add(30);

        // Creating a shallow copy using clone()
        LinkedList<Integer> clonedList1 = (LinkedList<Integer>) originalList1.clone();

        // Modifying the cloned list
        clonedList1.set(0, 50); // Changing the value at index 0 in the cloned list

        System.out.println("Original List: " + originalList1);
        System.out.println("Cloned List: " + clonedList1);

        // Checking memory locations of elements at index 0 in both lists
        System.out.println("Original List [0]: " + System.identityHashCode(originalList1.get(0)));
        System.out.println("Cloned List [0]: " + System.identityHashCode(clonedList1.get(0)));
    }
}
