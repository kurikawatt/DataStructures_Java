package fr.kurikawa.linkedlist;

public class LinkedList {
    
    private Link firstLink;
    private Link lastLink;
    private int length;

    public LinkedList(){
        this.firstLink = null;
        this.lastLink = null;
        this.length = 0; 
    }

    public void linkAsFirst(Link link){
        // Si la liste est vide
        if (this.length == 0){
            this.lastLink = link;
        }
        link.linkToNext(this.firstLink);
        this.firstLink = link;
        length++;
    }

}
