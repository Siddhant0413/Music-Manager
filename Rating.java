/**
 Rating class to create a rating object that can be set to an album.
 */
public class Rating {
    private int star;
    private Rating next;

    /*
     Constructor used to create a new instance of the Rating object with the star ratings
     @param star to represent the star ratings
     */
    public Rating(int star) {
        this.star = star;
        this.next = null;
    }

    /*
    These getter and setter methods give access to the private instance variables of this class
    @param getStar, getNext, setStar, setNext enables the methods to set or get values
    @return star, next returns the star value and next value
     */
    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Rating getNext() {
        return next;
    }

    public void setNext(Rating next) {
        this.next = next;
    }
}
