package operation;

import data.Songs;
import data_accessing_object.ArtistDAO;
import data_accessing_object.GenreDAO;
import data_accessing_object.PlayListDAO;
import data_accessing_object.SongsDAO;
import main.Implementation;
import utility.DB_connection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeOperation {

    /** This Method Executes a DQL query and Fetch All the columns and the columns values and
     * placing them in song object and adding all song objects to allSongsList  and returning
     * the list*/
    public List<Songs> displayAllSongs() throws SQLException, ClassNotFoundException {

        List<Songs> allSongsList = new ArrayList<>();
        Connection connection = DB_connection.getConnection();
        String sql = "Select * from songs; ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            allSongsList.add(new Songs(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }

        return allSongsList;
    }

    public List<Songs> searchArtistByArtistName(String searchAlphabet) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DB_connection.getConnection();
        String sql = "Select artistName from songs where artistName like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, searchAlphabet + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the Artist");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        String artistName = scanner.nextLine();
        ArtistDAO artistDAO = new ArtistDAO();
        return artistDAO.songsOfArtist(artistName);

    }

    public List<Songs> searchGenreByGenreType(String searchAlphabet) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DB_connection.getConnection();
        String sql = "Select genreType from songs where genreType like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, searchAlphabet + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the Genre");
        while(resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        String genreType = scanner.nextLine();
        GenreDAO genreDAO = new GenreDAO();
        return genreDAO.songsOfGenre(genreType);
    }

    public List<Songs> searchSongBySongName(String searchAlphabet) throws SQLException, ClassNotFoundException {

        Connection connection = DB_connection.getConnection();
        List<Songs> songsList = new ArrayList<>();
        String sql = "Select * from songs where songName like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, searchAlphabet + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the song");

        while (resultSet.next()) {
            songsList.add(new Songs(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getDouble(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
        }

        return songsList;
    }

    public void playSongs() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scanner = new Scanner(System.in);
        AudioPlayer audioPlayer = new AudioPlayer();
        SongsDAO songsDAO = new SongsDAO();
        PlayListDAO playListDAO = new PlayListDAO();
        System.out.println("PLEASE SELECT THE OPTION \n1: PLAY A SONG \n2: GO TO PLAYLIST\n3: GO BACK TO MAIN MENU");
        int choice = scanner.nextInt();

        switch (choice) {
            case (1):
                System.out.println("PLEASE ENTER THE SONG ID YOU WANT TO PLAY");
                int songID = scanner.nextInt();
                audioPlayer.PlaySong(songsDAO.getPathOfTheSong(songID));
                break;
            case (2):
                System.out.println("1 FOR CREATING A NEW PLAYLIST\n2 FOR EXISTING PLAYLIST");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case (1):
                        playListDAO.creatingAPlaylist();
                    case (2):
                        List<Songs> playList = playListDAO.exsitingPlaylist();
                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        for (Songs songs : playList) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                        }
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("\t\t1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST");
                        System.out.println("\t\t2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST");
                        System.out.println("\t\t3: GO BACK TO MAIN MENU");
                        int select = scanner.nextInt();
                        switch (select) {
                            case (1):
                                audioPlayer.PlaySong(playList);
                                break;
                            case (2):
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("-----------------------------------------------------------------------------------------");
                                for (Songs songs : playList) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                System.out.println("PLEASE ENTER THE SONG_ID YOU WANT TO PLAY");
                                int song_id = scanner.nextInt();
                                audioPlayer.PlaySong(songsDAO.getPathOfTheSong(song_id));

                            case (3):
                                String[] arg = new String[0];
                                Implementation.main(arg);
                                break;
                            default:
                                System.err.println("PLEASE SELECT THE CORRECT OPTION");
                        }

                }
                break;
            case (3):
                break;
            default:
                System.err.println("PLEASE SELECT THE RIGHT OPTION");


        }
    }


}
