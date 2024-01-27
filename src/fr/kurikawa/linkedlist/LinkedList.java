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

    public LinkedList(List<Object> originList){
        this();
        for (Object o : originList){
            this.linkAsLast(new Link(o));
        }
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

    public void makeCircular(){
        this.firstLink.linkToPrevious(this.lastLink);
        this.lastLink.linkToNext(this.firstLink);
    }

    public void makeLinear(){
        this.firstLink.linkToPrevious(null);
        this.lastLink.linkToNext(null);
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

    public void removeValue(Object value){
        Link linkToBeDeleted = search(value);
        if (linkToBeDeleted != null){
            // On recupère les liens précédent et suivant
            Link previousLink = linkToBeDeleted.getPrevious();
            Link nextLink = linkToBeDeleted.getNext();
            // On les connecte entre eux
            previousLink.linkToNext(nextLink);
            nextLink.linkToPrevious(previousLink);
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

    public String reversedToString(){
        if (this.length == 0){
            return "Empty list.";
        }
        Link cursor = this.lastLink;
        String res = "[END] -> ";
        while (cursor != null && cursor != this.firstLink) {
            res = res + cursor.toString() + " -> ";
            cursor = cursor.getNext();
        }
        return res + "[BEGIN]";
    }

}
