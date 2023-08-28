import java.util.*;
class Chat{
    public static void main(String args[]){
        String p1="", p2="";
        Scanner in = new Scanner(System.in);
        ArrayList<String> chats = new ArrayList<>();
        while(!p1.equals("bye") && !p2.equals("bye")){
            System.out.println("Person 1");
            p1=in.nextLine();
            chats.add(p1);
            System.out.println("Person 2");
            p2=in.next();
            p2+=in.nextLine();
            chats.add(p2);
        }
        System.out.println("The conversation is ");
        int i=1;
        for (String chat : chats) {
            System.out.println("Person" + i + ": " + chat);
            i= i==1?2:1;
        }
        in.close();
    }
}
