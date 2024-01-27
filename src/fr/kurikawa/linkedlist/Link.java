package fr.kurikawa.linkedlist;

public class Link {
    
    private Object value;
    private Link previousLink;
    private Link nextLink;

    public Link(Object value, Link previousLink, Link nextLink){
        this.value = value;
        this.previousLink = previousLink;
        this.nextLink = nextLink;
    }

}
