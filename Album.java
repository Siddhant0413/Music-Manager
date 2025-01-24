/**
 This class represents an Album in the collection, which includes the information about the album such as the
 title, artist, genre, date released, and ratings.This class then takes the ratings of the album
 and then calculate its average ratings.
 */
import java.util.LinkedList;
public class Album {
    private String title;
    private Artist artist;
    private Genre genre;
    private Date released;
    private LinkedList<Integer> ratings; //a linked list of ratings

    /* This constructor takes 4 parameters and initializes 'Album' object
     @param title, artist, genre, date
     */
    public Album()
    {
        Album a = new Album();
    }
    public Album(String title, Artist artist, Genre genre, Date released) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.released = released;
        this.ratings = new LinkedList<>();
    }

    /* This method is used to add a rating to the linked list
    @param star to add a rating
    */
    public void rate(int star) {
        ratings.add(star);
    }

    /* This method is used to compute the average ratings
    @param avgRatings to compute the average ratings
    @return sum which would be a double value that represents the average rating of the album
     */
    public double avgRatings() {
        if (ratings.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / ratings.size();
    }

    /* The getter methods are returning the title, artist, genre, and the release date of the album
       The setter methods are setting the title, artist, genre, and the release date of the album
       These getter and setter methods give access to the private instance variables of this class
       @param setTitle, setArtist, setGenre, setReleased enables the methods to set values
       @return getTitle, getArtist, getGenre, getReleased returns the names/values of each variable
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }
    @Override
    /* This method is used to compare objects to make sure they are equal 
    @param obj used to represent the object that is going to be compared with the original object
    @return false if obj is null, otherwise true
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Album album = (Album) obj;
        return title.equalsIgnoreCase(album.title) && artist.equals(album.artist);
    }

    /* Override toString() method, This method is used to provide the album name
    @return string that is the name of the album
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(title).append("] ");
        sb.append("Released ").append(released).append(" ");
        sb.append("[").append(artist).append("] ");
        sb.append("[").append(genre).append("] ");
        sb.append("Rating: ");

        if (ratings.isEmpty()) {
            sb.append("none");
        } else {
            for (int i = 1; i <= 5; i++) {
                int count = countRatings(i);
                if (count > 0) {
                    sb.append("*(".repeat(count)).append(i).append(")");
                }
            }
            sb.append("(average rating: ").append(String.format("%.2f", avgRatings())).append(")");
        }
        return sb.toString();
    }

    /* This method is used to count ratings with the specific star value in the album's rating list
    @param star used to represent the specific star value that count as the rating
     */
    private int countRatings(int star) {
        int count = 0;
        for (int rating : ratings) {
            if (rating == star) {
                count++;
            }
        }
        return count;
    }
}
