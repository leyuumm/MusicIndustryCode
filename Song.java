class Song{
    private String title;
    private String artist;
    private String album;
    private int trackNumber;
    private String fileFormat;
    private String duration;

    // Constructor for creating a song object 
    public Song(String title, String artist, String album, int trackNumber, String fileFormat, String duration)
    {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.trackNumber = trackNumber;
        this.fileFormat = fileFormat;
        this.duration = duration;
    }
    // Method to play the song and display its information
    public void play()
    {
        System.out.println("Playing: " + "|| Album: " + getAlbum() + " ||" + " " + "Track " + trackNumber + " ||" + " - " + title + " by " + artist + getFileFormat() + " " + "|" +getDuration() + "|");
    }

    //getter methods for title, artist, album, track number etc.
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public int getTrackNumber()
    {
        return trackNumber;
    }

    public String getFileFormat()
    {
        return fileFormat;
    }

    public String getDuration()
    {   
        return duration;
    }
}