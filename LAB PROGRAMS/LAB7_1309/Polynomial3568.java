import java.time.LocalDate;
import java.time.LocalTime;

class Node{
    
    int exponent;
    int coefficient;
    Node next;
    Node(){
        exponent=0;
        coefficient=0;
        next=null;
    }
    Node(int exponent,int coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
        next=null;
    }
}

class Polynomial {
    Node head;
    Polynomial(){
        head=null;
        
    }
    
    void insert(int exponent,int coefficient){
        Node temp=new Node(exponent,coefficient);
        if(head==null){
            head=temp;
        }
        else{
            Node ptr=head;
            while(ptr.next!=null){
                ptr=ptr.next;
            }
            ptr.next=temp;
        }
    }

    void display(){
        Node ptr=head;
        while(ptr!=null){
            System.out.print(ptr.coefficient+"x^"+ptr.exponent+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }

    void add(Polynomial p){
        Node ptr1=head;
        Node ptr2=p.head;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.exponent==ptr2.exponent){
                ptr1.coefficient+=ptr2.coefficient;
                ptr1=ptr1.next;
                ptr2=ptr2.next;
            }
            else if(ptr1.exponent>ptr2.exponent){
                ptr1=ptr1.next;
            }
            else{
                Node temp=new Node(ptr2.exponent,ptr2.coefficient);
                temp.next=ptr1.next;
                ptr1.next=temp;
                ptr1=ptr1.next;
                ptr2=ptr2.next;
            }
        }
        while(ptr2!=null){
            Node temp=new Node(ptr2.exponent,ptr2.coefficient);
            temp.next=ptr1.next;
            ptr1.next=temp;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
    }

    void multiply(Polynomial p){
        Node ptr1=head;
        Node ptr2=p.head;
        Polynomial result=new Polynomial();
        while(ptr1!=null){
            while(ptr2!=null){
                result.insert(ptr1.exponent+ptr2.exponent,ptr1.coefficient*ptr2.coefficient);
                ptr2=ptr2.next;
            }
            ptr1=ptr1.next;
            ptr2=p.head;
        }
        result.display();
    }
}

public class Polynomial3568 {
    public static void main(String args[]){
        System.out.println("Current Date: " + LocalDate.now());
        System.out.println("Current Time: " + LocalTime.now());
        System.out.println("Name: Vijai Suria M \nRegister Number: (2021503568)");
        Polynomial p1=new Polynomial();
        Polynomial p2=new Polynomial();
        p1.insert(2, 3);
        p1.insert(0, 1);
        p2.insert(1, 2);
        System.out.println("Polynomial 1:");
        p1.display();
        System.out.println("Polynomial 2:");
        p2.display();
        System.out.println("Polynomial 1 * Polynomial 2:");
        p1.multiply(p2);

    }
}
