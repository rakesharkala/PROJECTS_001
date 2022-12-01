package data;

public class Songs {

    private String songName;
    private int songID;
    private double songDuration;
    private String songPath;
    private String artistName;
    private String genreType;


    public Songs() {
    }

    public Songs(int songID, String songName, double songDuration, String songPath, String genreType, String artistName) {

        this.songID = songID;
        this.songName = songName;
        this.songDuration = songDuration;
        this.songPath = songPath;
        this.artistName = artistName;
        this.genreType = genreType;
    }

    public String getSongName() {
        return songName;
    }

    public double getDuration() {
        return songDuration;
    }

    public String getSongPath() {
        return songPath;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }
}
