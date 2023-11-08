import java.util.*;

public class Main {
    public static void main(String[] args){
        MusicLibrary library = new MusicLibrary();

        // Creating 2 albums and by adding songs to them
        Album album1 = new Album("WasteLand", "Brent Faiyaz","R&B/Soul", 2022);
        album1.addSong(new Song("Rolling Stone", "Brent Faiyaz", "WasteLand", 1, ".mp3", "2:43"));
        album1.addSong(new Song("Wasting Time", "Brent Faiyaz", "WasteLand", 2, ".wav", "5:02"));
        album1.addSong(new Song("Pilot Jones", "Frank Ocean", "Channel Orange", 3, ".mp3", "3:04"));
        album1.addSong(new Song("Jackie Brown", "Brent Faiyaz", "WasteLand", 4, ".mp3", "2:50"));
        album1.addSong(new Song("All Mine", "Brent Faiyaz", "WasteLand", 5, ".mp3", "3:37"));
        album1.addSong(new Song("Crack Rock", "Frank Ocean", "Channel Orange", 6, ".wav", "3:44"));
        album1.addSong(new Song("Dead Man Walking", "Brent Faiyaz", "WasteLand", 7, ".wav", "4:08"));

        // Album 2 
        Album album2 = new Album("Channel Orange", "Frank Ocean","R&B/Soul, Pop, HIPHOP/RAP", 2012);
        album2.addSong(new Song("Thinking Bout You", "Frank Ocean", "Channel Orange", 1, ".mp3", "3:21"));
        album2.addSong(new Song("Lost", "Frank Ocean", "Channel Orange", 2, ".wav", "3:54"));
        album2.addSong(new Song("Pyramids", "Frank Ocean", "Channel Orange", 3, ".wav", "9:53"));
        album2.addSong(new Song("Villain's Theme", "Brent Faiyaz", "WasteLand", 4, ".mp3", "2:22"));
        album2.addSong(new Song("White", "Frank Ocean", "Channel Orange", 5, ".mp3", "3:54"));
        album2.addSong(new Song("Bad Luck", "Brent Faiyaz", "WasteLand", 6, ".mp3", "2:43"));
        album2.addSong(new Song("Gravity", "Brent Faiyaz", "WasteLand", 7, ".wav", "3:35"));


        // Adding the created 2 albums to the music library
        library.addAlbum(album1);
        library.addAlbum(album2);

        // Creating a scanner for user input
        Scanner sc = new Scanner(System.in);
        int choice;

        do{

            System.out.println("\nMusic Library Menu:");
            System.out.println("1. Play a Song");
            System.out.println("2. Play an Album");
            System.out.println("3. Add a Song to an Album");
            System.out.println("4. Remove a Song from an Album");
            System.out.println("5. List Albums");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try
            {
                // Getting the user's choice, and handling the potential errors
                choice = sc.nextInt();
                sc.nextLine(); 
            } catch(InputMismatchException e)
            {
                System.out.println("Invalid input. PLease enter a numerical choice");
                sc.nextLine();
                choice = - 1;
            }
            

            
            switch(choice)
            {
                case 1:
                    // Playing a song/tracks
                    System.out.print("Enter the song title to play: ");
                    String songTitle = sc.nextLine();
                    playSong(library, songTitle);
                    break;

                case 2:
                    // Playing an album
                    System.out.println("====================================================");
                    System.out.print("Enter the album title to play: ");
                    String albumTitle = sc.nextLine();
                    playAlbum(library, albumTitle);
                    break;

                case 3:
                    // Adding a song/track to an album
                    System.out.print("Enter the album title to add a song to: ");
                    albumTitle = sc.nextLine();
                    Album album = findAlbum(library, albumTitle);

                    if(album != null)
                    {
                        addSongToAlbum(sc, album);
                    } else{
                        System.out.println("Album not found");
                    }
                    break;
                    
                case 4:
                    // Removing a song/track from an album 
                    System.out.print("Enter the album title to remove a song from: ");
                    albumTitle = sc.nextLine();
                    album = findAlbum(library, albumTitle);

                    if(album != null)
                    {
                        removeSongFromAlbum(sc, album);
                    } else{
                        System.out.println("Album not found");
                    }
                    break;
                    
                case 5:
                    // Viewing/Listing the albums in the library
                    listAlbums(library);
                    break;
                    
                case 0:

                    System.out.println("GoodBye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while(choice != 0);
    }
    // Function to play a song by title
    public static void playSong(MusicLibrary library, String songTitle)
    {   // Looping through albums and songs to find and play the specified song/track
        for(Album album : library.getAlbums())
        {
            for(Song song : album.getSongs())
            {
                if(song.getTitle().equalsIgnoreCase(songTitle))
                {
                    song.play();
                    return;
                }
            }
        }
        System.out.println("Song not found");
    }
    // Function to play an album by title 
    public static void playAlbum(MusicLibrary library, String albumTitle)
    {
        Album album = findAlbum(library, albumTitle);
            if(album != null)
            {
                System.out.println("====================================================");
                System.out.println("Playing songs from the album: " + album.getTitle());
                album.listSongs();
            } else{
                System.out.println("Album not found.");
            }
    }
    // Function to find an album by its title
    public static Album findAlbum(MusicLibrary library, String albumTitle)
    {
        for(Album album : library.getAlbums())
        {
            if(album.getTitle().equalsIgnoreCase(albumTitle))
            {
                return album;
            }
        }
        return null;
    }
    // Function to add a song/track to an album
    private static void addSongToAlbum(Scanner sc, Album album)
    {
        System.out.print("Enter the song title: ");
        String title = sc.nextLine();

        System.out.print("Enter the artist: ");
        String artist = sc.nextLine();


        int trackNumber = 0; // Initializing the track number to a default value
    try
    {
        System.out.print("Enter the track number: ");
        trackNumber = sc.nextInt();
        sc.nextLine();
    } catch(InputMismatchException e)
    {
        System.out.println("Invalid track number. Please enter a valid track number");
        sc.nextLine();
        return; // Exit the method to prevent creating a song with an invalid track number
    }

        System.out.print("Enter the file format: ");
        String fileFormat = sc.nextLine();

        System.out.print("Enter the duration: ");
        String duration = sc.nextLine();

        Song newSong = new Song(title, artist, album.getTitle(), trackNumber, fileFormat, duration);
        album.addSong(newSong);
        System.out.println("Song added to album: " + album.getTitle());
    }
    // Function to remove a song from an album
    private static void removeSongFromAlbum(Scanner sc, Album album)
    {
        album.listSongs();

        System.out.println("====================================================");
        System.out.print("Enter the title of the song to remove: ");
        String songTitle = sc.nextLine();

        Song songToRemove = null;


        for(Song song : album.getSongs())
        {
            if(song.getTitle().equalsIgnoreCase(songTitle))
            {
                songToRemove = song;
                break;
            }
        }

        if(songToRemove != null)
        {
            album.removeSong(songToRemove);
            System.out.println("Song removed from the album: " + songToRemove.getTitle());
        } else{
            System.out.println("Song not found in the album.");
        }
    }
    //  Function to list/view albums in the library
    private static void listAlbums(MusicLibrary library)
    {
        ArrayList <Album> albums = library.getAlbums();

        if(albums.isEmpty())
        {
            System.out.println("No albums found in the library.");
        } else{
            System.out.println("====================================================");
            System.out.println("List of Albums in the Music Library: ");
            System.out.println();

            for(Album album : albums)
            {
                System.out.println("Title: " + album.getTitle());
                System.out.println("Artist: " + album.getArtist());
                System.out.println("Genre: " + album.getGenre());
                System.out.println("Year Released: " + album.getYearReleased());
                System.out.println("====================================================");
                System.out.println();
            }
        }
    }
}
