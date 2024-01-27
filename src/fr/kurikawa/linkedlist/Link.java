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

    public void unlink(){
        this.nextLink = this.previousLink = null;
    }

    @Override 
    public String toString(){
        return "(" + this.value.toString() + ")";
    }

}
