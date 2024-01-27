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

    public int length(){
        return this.length;
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

    public void linkAsLast(Link link){
        // Si la liste est vide
        if (this.length == 0){
            this.firstLink = link;
        }
        link.linkToPrevious(this.lastLink);
        this.lastLink = link;
        length++;
    }

    @Override
    public String toString() {
        if (this.length == 0){
            return "Empty list.";
        }
        Link cursor = this.firstLink;
        String res = "[BEGIN] -> ";
        while (cursor != null) {
            res = res + cursor.toString() + " -> ";
            cursor = cursor.getNext();
        }
        return res + "[END]";
    }

}
