package examples;

import fr.kurikawa.linkedlist.Link;
import fr.kurikawa.linkedlist.LinkedList;

public class LinkedListExample {
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        System.out.println("Liste : " + list);
        System.out.println("La liste contient " + list.length() + " elements.");

        System.out.println("Remplissage...");
        for (int i = 0; i < 5; i++){
            list.linkAsLast(new Link(i));
        }
        System.out.println("Liste : " + list);
        System.out.println("La liste contient " + list.length() + " elements.");
        System.out.println("Le premier element est " + list.head());
        System.out.println("Le dernier element est " + list.tail());
    }

}
