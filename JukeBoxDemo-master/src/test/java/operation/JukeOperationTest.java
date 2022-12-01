package operation;

import data.Songs;
import data_accessing_object.ArtistDAO;
import data_accessing_object.GenreDAO;
import data_accessing_object.PlayListDAO;
import data_accessing_object.SongsDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JukeOperationTest {


    JukeOperation jukeOperation ;
    ArtistDAO artistDAO;
    GenreDAO genreDAO;
    PlayListDAO playListDAO;
    SongsDAO songsDAO;
    @BeforeEach
    void setUp() {
        jukeOperation = new JukeOperation();
        playListDAO = new PlayListDAO();
        artistDAO = new ArtistDAO();
        songsDAO = new SongsDAO();
        genreDAO = new GenreDAO();
    }

    @AfterEach
    void tearDown() {
        jukeOperation = null;
        artistDAO = null;
        genreDAO = null;
    }

    @Test
    void displayAllSongs() throws SQLException, ClassNotFoundException {
       List<Songs> songsList = jukeOperation.displayAllSongs();
       assertEquals(5,songsList.size());
        List<Songs> songsList1 = jukeOperation.displayAllSongs();
        assertNotEquals(9,songsList.size());
    }



    @Test
    void searchSongBySongName() throws SQLException, ClassNotFoundException {
        String songName = "s";
        List<Songs> songsList = jukeOperation.searchSongBySongName(songName);
        assertEquals(1,songsList.size());
        List<Songs> songsList1 = jukeOperation.searchSongBySongName(songName);
        assertNotEquals(5,songsList.size());

    }
    @Test
    void songsOfGenre() throws SQLException, ClassNotFoundException {

        String genreType = "classic";
        List<Songs> songsList = genreDAO.songsOfGenre(genreType);
        assertEquals(1,songsList.size());
        List<Songs> songsList1 = genreDAO.songsOfGenre(genreType);
        assertNotEquals(4,songsList.size());
    }
    @Test
    void songsOfArtist() throws SQLException, ClassNotFoundException {

        String artistName = "sidSriRam";
        List<Songs> songsList = artistDAO.songsOfArtist(artistName);
        assertEquals(1,songsList.size());
        assertNotEquals(5,songsList.size());
    }


    @Test
    void getPathOfSong() throws SQLException, ClassNotFoundException {

        int songID = 4;
        String pathOfTheSong = songsDAO.getPathOfTheSong(songID);
        assertEquals("src/main/resources/wav_21mb.wav",pathOfTheSong);
        int songId = 5;
        String pathOfTheSong1 = songsDAO.getPathOfTheSong(songId);
        assertNotEquals("src/main/resources/wav_21mb.wav",1);
    }

}