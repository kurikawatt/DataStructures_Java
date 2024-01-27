package fr.kurikawa.linkedlist;

/**
 * Maillon (Link)
 * 
 * Représente un maillon dans une liste doublement chaînée
 * 
 * @author François "Kurikawa"
 */
public class Link {
    
    private Object value;
    private Link previousLink;
    private Link nextLink;

    /**
     * Instancie un nouveau Maillon
     * 
     * @param value la valeur du maillon
     * @param previousLink le maillon précédent
     * @param nextLink le maillon suivant
     */
    public Link(Object value, Link previousLink, Link nextLink){
        this.value = value;
        this.previousLink = previousLink;
        this.nextLink = nextLink;
    }

    /**
     * Instancie un nuveau Maillon
     * 
     * @param value la valeur du maillon
     */
    public Link(Object value){
        this(value, null, null);
    }

    public Object getValue(){
        return this.value;
    }

    public Link getNext(){
        return this.nextLink;
    }

    public Link getPrevious(){
        return this.previousLink;
    }

    public void setValue(Object newValue){
        this.value = newValue;
    }

    public void linkToNext(Link newNext){
        this.nextLink = newNext;
    }

    public void linkToPrevious(Link newPrevious){
        this.previousLink = newPrevious;
    }

    /**
     * Délie le maillon de son prédécesseur et de son suivant
     */
    public void unlink(){
        this.nextLink = this.previousLink = null;
    }

    @Override 
    public String toString(){
        return "(" + this.value.toString() + ")";
    }

}
