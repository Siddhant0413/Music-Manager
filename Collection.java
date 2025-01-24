/**
 Collection class is meant to create the collection that holds the albums.
 In this class, we can also set its size and manipulate the collection to do various things to it.
 This is where we are able to do all printing and adding to the collection.
 */
public class Collection {
    private static final int INITIAL_CAPACITY = 4;
    private static final int NOT_FOUND = -1;

    private Album[] albums; // list of albums
    private int size; // number of albums in the list

    // This constructor creates a new instance of the class

    public Collection() {
        albums = new Album[INITIAL_CAPACITY];
        size = 0;
    }

    //Helper method to increase the capacity by 4 elements
    private void grow() {
        Album[] newRoster = new Album[size+4];

        for (int i = 0; i < size; i++) {
            newRoster[i] = albums[i];
        }
        albums = newRoster;
    }

    // Helper method to find the index of an album
    private int find(Album album) {
        for (int i = 0; i < size; i++) {
            if (albums[i].equals(album)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    // Method to check if an album exists in the collection
    public boolean contains(Album album) {
        return find(album) != NOT_FOUND;
    }
    // Method to add an album to the collection
    public boolean add(Album album) {
        if (contains(album)) {
            return false;
        }
        if (size == albums.length) {
            grow();
        }
        albums[size++] = album;
        return true;
    }

    // Method to remove an album from the collection
    public boolean remove(Album album) {
        int index = find(album);
        if (index == NOT_FOUND) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            albums[i] = albums[i + 1];
        }
        size--;
        return true;
    }

    // Method to rate an album
    public void rate(Album album, int rating) {
        int index = find(album);
        if (index != NOT_FOUND) {
            album.rate(rating);
        }
    }

    // Method to print albums sorted by release date, then title
    public void printByDate() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Compare release dates
                if (albums[j].getReleased().compareTo(albums[j + 1].getReleased()) > 0
                        || (albums[j].getReleased().compareTo(albums[j + 1].getReleased()) == 0
                        && albums[j].getTitle().compareToIgnoreCase(albums[j + 1].getTitle()) > 0)) {
                    // Swap albums if necessary
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }

    // Method to print albums sorted by genre, then artist
    public void printByGenre() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Compare genres
                if (albums[j].getGenre().compareTo(albums[j + 1].getGenre()) > 0
                        || (albums[j].getGenre().compareTo(albums[j + 1].getGenre()) == 0
                        && albums[j].getArtist().compareTo(albums[j + 1].getArtist()) > 0)) {
                    // Swap albums if necessary
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }

    // Method to print albums sorted by average rating, then title
    public void printByRating() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // Compare average ratings
                if (albums[j].avgRatings() < albums[j + 1].avgRatings() ||
                        (albums[j].avgRatings() == albums[j + 1].avgRatings() &&
                                albums[j].getTitle().compareToIgnoreCase(albums[j + 1].getTitle()) > 0)) {
                    // Swap albums if necessary
                    Album temp = albums[j];
                    albums[j] = albums[j + 1];
                    albums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(albums[i]);
        }
    }
}
