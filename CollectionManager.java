/**
 Main driving point of the class where all inputs are taken in.
 The class here is where the inputs are taken in and depending on the input
 various tasks are performed. It is a constant loop that is only broken with one command.
 */
import java.util.Scanner;
public class CollectionManager
{
    /*
    Run method starts the while loop which takes commands until given "Q".
     */
    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running)
        {
            Collection c = new Collection();
            System.out.println("Collection Manager running...");
            System.out.println("Enter: ");
            String a = sc.next();
            Genre genre = null;
            switch(a)
            {
                case "A":
                    Album mainAlbum = new Album();
                    String albumName = sc.next();
                    String artist = sc.next();
                    String date = sc.next();
                    Date dob1 = new Date(date);
                    String next = sc.next();
                    genre = Genre.valueOf(next.toUpperCase());
                    mainAlbum.setTitle(albumName);
                    Artist newArtist = new Artist(artist,dob1);
                    mainAlbum.setArtist(newArtist);
                    mainAlbum.setGenre(genre);
                    String dateReleased = sc.next();
                    Date dRelease = new Date(dateReleased);
                    mainAlbum.setReleased(dRelease);
                    c.add(mainAlbum);
                    break;
                case "D":
                    Album mainAlbum2 = new Album();
                    String albumName2 = sc.next();
                    String artist2 = sc.next();
                    String date2 = sc.next();
                    Date dob12 = new Date(date2);
                    String next2 = sc.next();
                    genre = Genre.valueOf(next2.toUpperCase());
                    mainAlbum2.setTitle(albumName2);
                    Artist newArtist2 = new Artist(artist2,dob12);
                    mainAlbum2.setArtist(newArtist2);
                    mainAlbum2.setGenre(genre);
                    String dateReleased2 = sc.next();
                    Date dRelease2 = new Date(dateReleased2);
                    mainAlbum2.setReleased(dRelease2);
                    c.remove(mainAlbum2);
                    break;
                case "R":
                    Album mainAlbum3 = new Album();
                    String albumName3 = sc.next();
                    String artist3 = sc.next();
                    String date3 = sc.next();
                    String stars = sc.next();
                    int starNum = Integer.parseInt(stars);
                    Date dob13 = new Date(date3);
                    Artist newArtist3 = new Artist(artist3, dob13);
                    Album find = new Album();
                    find.setArtist(newArtist3);
                    find.setTitle(albumName3);

                    if(c.contains(find) == true)
                    {
                        c.rate(find,starNum);
                    }
                    break;
                case "PD":
                    c.printByDate();
                    break;
                case "PG":
                    c.printByGenre();
                    break;
                case "PR":
                    c.printByRating();
                    break;
                case "Q":
                    System.out.println("Collection Manager Terminated");
                    running = false;
                    break;
            }
        }
    }
}
