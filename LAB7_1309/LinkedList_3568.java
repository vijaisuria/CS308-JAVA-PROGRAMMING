class Node{
    int data;
    Node next;
    Node(){
        data=0;
        next=null;
    }
    Node(int data){
        this.data=data;
    }
}

class LinkedList {
    Node head;
    LinkedList(){
        head=null;
    }
    public void insertHead(int data){
        Node newNode = new Node(data);
        if(this.head==null)
            this.head=newNode;
        else{
            newNode.next=this.head;
            this.head=newNode;
        }
    }
    public void display(LinkedList l){
        Node current = l.head;
        while(current.next!=null){
            System.out.print(current.data + " -> ");
            current=current.next; 
        }
        if(current!=null)
            System.out.print(current.data);
    }
}

public class LinkedList_3568{
    public static void main(String args[]){
        System.out.println("Linked List");
        LinkedList list = new LinkedList();
        for(int i=0;i<5;i++){
            list.insertHead(i);
        }
        list.display(list);
    }
}