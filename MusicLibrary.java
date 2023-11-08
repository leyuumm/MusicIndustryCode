import java.util.ArrayList;

class MusicLibrary {
    public ArrayList <Album> albums;
    
    // Constructor for creating a MusicLibrary object 
    public MusicLibrary()
    {
        albums = new ArrayList<>();
    }

    // Method to add an album to the music library
    public void addAlbum(Album album)
    {
        albums.add(album);
    }

    // Method to get the list of albums in the music library
    public ArrayList<Album> getAlbums() {
        return albums;
    }
}
