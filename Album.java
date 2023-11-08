import java.util.ArrayList;

class Album {
    private String title;
    private String artist;
    private String genre;
    private int yearReleased;
    private ArrayList <Song> songs;

    // Constructor for creating an Album
    public Album(String title, String artist, String genre, int yearReleased)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.yearReleased = yearReleased;
        songs = new ArrayList<>();
    }
    // Method to add a song to the album 
    public void addSong(Song song)
    {
        songs.add(song);
    }
    // Method to remove a song from the album
    public void removeSong(Song song)
    {
        songs.remove(song);
    }
    // Method to get an array of songs in the album
     public Song[] getSongs() {
        return songs.toArray(new Song[0]);
    }
    // Getter method to get the title of the album
    public String getTitle() {
        return title;
    }
    // Getter method to get the artist of the album
    public String getArtist() {
        return artist;
    }
    // Getter method to get the genre of the album
    public String getGenre() {
        return genre;
    }
    // Getter method to get the year of release of the album
    public int getYearReleased() {
        return yearReleased;
    }
    // Method to list/view tracks in the album
    public void listSongs()
    {
        System.out.println("====================================================");
        System.out.println("Tracks in " + title + " (" + yearReleased + "):");
        for(Song song : songs)
        {
            System.out.println("|| " + "Track " + song.getTrackNumber() + " ||" + " - " + song.getTitle() + " by " + song.getArtist() + song.getFileFormat() + " " + "|" + song.getDuration() + "|");
        }
    }
}
