/**
 This is the artist class where we are able to create an artist and
 set their date of births and names. We are also able to compare
 two artists to each other here.
 */
public class Artist implements Comparable<Artist>{
    private String name;
    private Date born;

    /*
    Constructor initializes an Artist object with the artist's name and birthdate
    @param name for name of the artist
    @param born for the birthdate of the artist
     */
    public Artist(String name, Date born) {
        this.name = name;
        this.born = born;
    }

    /*
    Override equals() method
    @param obj used to represent the object that is going to be compared with the original object
    @return false if obj is null, otherwise true
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artist artist = (Artist) obj;
        return name.equalsIgnoreCase(artist.name) && born.equals(artist.born);
    }

    /*
    Override toString() method
    @return name, born which outputs the Artist's name and birthdate
     */
    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", born=" + born +
                '}';
    }

    // Implementing the compareTo method of the Comparable interface
    @Override
    public int compareTo(Artist otherArtist) {
        // Compare the name of the artist first
        int nameComparison = this.name.compareToIgnoreCase(otherArtist.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        // If the names are equal, compare the date of birth
        return this.born.compareTo(otherArtist.born);
    }

    // Getters
    public String getName() {
        return name;
    }

    public Date getBorn() {
        return born;
    }

    public static void main(String args[])
    {
        Date d1 = new Date("12/14/2002");
        Date d2 = new Date("3/4/1999");
        Date d3 = new Date("11/13/2003");
        Date d4 = new Date("5/23/2000");
        Date d5 = new Date("6/5/2005");

        Artist test1 = new Artist("Taylor Swift",d1);
        Artist test2 = new Artist("Weekend", d2);
        Artist test3 = new Artist("Weekend", d2);
        Artist test4 = new Artist("Taylor Swift", d2);
        Artist test5 = new Artist("Taylor Swift", d5);

        test1.compareTo(test2);
        test1.compareTo(test5);
        test2.compareTo(test3);
        test3.compareTo(test4);
        test2.compareTo(test5);

    }
}
