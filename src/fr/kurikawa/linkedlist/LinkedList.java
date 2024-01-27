package fr.kurikawa.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    
    private Link firstLink;
    private Link lastLink;
    private int length;

    public LinkedList(){
        this.firstLink = null;
        this.lastLink = null;
        this.length = 0; 
    }

    public Link head(){
        return this.firstLink;
    }

    public Link tail(){
        return this.lastLink;
    }

    public int length(){
        return this.length;
    }

    public boolean isCircular(){
        return this.firstLink.getNext() == this.lastLink || this.lastLink.getPrevious() == firstLink;
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

    public void linkAfterValue(Link link, Object value){
        Link previousLink = this.search(value);
        if (previousLink != null){
            // On garde le prochain maillon en mémoire
            Link nextLink = previousLink.getNext();
            // On lie notre maillon
            link.linkToPrevious(previousLink);
            link.linkToNext(nextLink);
            // On lie le précédent pour qu'il pointe sur le lien inséré
            previousLink.linkToNext(link);
            // On lie l'ancien lien suivant, afin qu'il pointe sur le lien
            // inseré en tant que prédecesseur
            nextLink.linkToPrevious(link);
        }
    }

    public Link search(Object value){
        Link cursor = this.firstLink;
        while (cursor != null) {
            if (cursor.getValue().equals(value)){
                return cursor;
            }
            cursor = cursor.getNext();
        }
        return null;
    }

    public boolean contains(Object value){
        return this.search(value) != null;
    }

    public List<Object> getAllValues(){
        List<Object> allValues = new ArrayList<Object>();
        Link cursor = this.firstLink;
        while (cursor != null && cursor != this.lastLink) {
            allValues.add(cursor.getValue());
            cursor = cursor.getNext();
        }
        return allValues;
    }

    @Override
    public String toString() {
        if (this.length == 0){
            return "Empty list.";
        }
        Link cursor = this.firstLink;
        String res = "[BEGIN] -> ";
        while (cursor != null && cursor != this.lastLink) {
            res = res + cursor.toString() + " -> ";
            cursor = cursor.getNext();
        }
        return res + "[END]";
    }

}
