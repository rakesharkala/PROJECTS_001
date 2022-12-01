package data_accessing_object;

import data.Songs;
import main.Implementation;
import operation.AudioPlayer;
import operation.JukeOperation;
import utility.DB_connection;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListDAO {


    public void creatingAPlaylist() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DB_connection.getConnection();
        PlayListDAO playListDAO = new PlayListDAO();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLEASE ENTER THE NAME OF THE PLAYLIST<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        // scanner.nextLine();
        String playlistname = scanner.nextLine();
        String sql = "Insert into playlistdetails(playListName) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, playlistname);
        int row = preparedStatement.executeUpdate();
        int generatedId = 0;
        if (row != 0) {
            System.out.println("New PlayList Created");
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }
        }
        System.out.println("1: DO YOU WANT TO ADD SONGS TO PLAY LIST");
        System.out.println("2: GO BACK TO MAIN MENU");
        int choice = scanner.nextInt();
        do {
            switch (choice) {
                case (1):
                    addingSongsToPlayList();
                    break;
                case (2):
                    String[] arg = new String[0];
                    Implementation.main(arg);
            }
        } while (choice < 3);
    }

    public void addingSongsToPlayList() throws SQLException, ClassNotFoundException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        Connection connection = DB_connection.getConnection();
        Scanner scanner = new Scanner(System.in);
        JukeOperation jukeOperation = new JukeOperation();
        AudioPlayer audioPlayer = new AudioPlayer();
        SongsDAO songsDAO = new SongsDAO();
        String sql = "SELECT playListID,playListName from playlistdetails;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.format("%-15s %-20s", "PlayListID", "PlayListName");
        System.out.println();
        while (resultSet.next()) {
            System.out.format("%-15s %-20s", resultSet.getInt(1), resultSet.getString(2));
            System.out.println();
        }

        System.out.println("Please enter the playListID to add songs");
        int playListID = scanner.nextInt();

        System.out.println("Search song based on following option");
        System.out.println("1 : Display all Songs");
        System.out.println("2 : Artist Name");
        System.out.println("3 : Genre");
        System.out.println("4 : Song Name");
        int option = scanner.nextInt();
        switch (option) {

            case (1):
                List<Songs> allSongs = jukeOperation.displayAllSongs();
                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "id", "SongName", "Duration", "genreType", "artist");
                for (Songs songs : allSongs) {
                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                }

                break;
            case (2):
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>PLEASE ENTER THE ARTIST NAME YOU WANT TO SEARCH<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                scanner.nextLine();
                String artistName = scanner.nextLine();
                List<Songs> songsListOfArtist = jukeOperation.searchArtistByArtistName(artistName);
                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "id", "SongName", "Duration", "genreType", "artist");
                for (Songs songs : songsListOfArtist) {
                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                }
                break;
            case (3):
                System.out.println(">>>>>>>>>>>>>>>>>>>>PLEASE ENTER THE GENRE TYPE YOU WANT TO SEARCH<<<<<<<<<<<<<<<<<<<<<<<<");
                String genreType = scanner.nextLine();
                List<Songs> songsList = jukeOperation.searchGenreByGenreType(genreType);
                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "id", "SongName", "Duration", "genreType", "artist");
                for (Songs songs : songsList) {
                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                }
                break;
            case (4):
                System.out.println(">>>>>>>>>>>>>>>>>>>PLEASE ENTER THE SONG NAME YOU WANT TO SEARCH<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                scanner.nextLine();
                String songName = scanner.nextLine();
                List<Songs> songsListBasedOnName = jukeOperation.searchSongBySongName(songName);
                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "id", "SongName", "Duration", "genreType", "artist");
                for (Songs songs : songsListBasedOnName) {
                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                }
                break;
            case (5):
                String[] arg = new String[0];
                Implementation.main(arg);
                break;

            default:
                System.err.println("PLEASE SELECT THE RIGHT OPTION");
        }

        System.out.println("Please enter the songID you want to add to the playlist");
        int songID = scanner.nextInt();

        String sqlUpdate = "INSERT INTO playlist(playListID,songId) values(?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        preparedStatement.setInt(1, playListID);
        preparedStatement.setInt(2, songID);
        int row = preparedStatement.executeUpdate();
        if (row != 0) {
            System.out.println(" Song Added to the playlist ");
        }
        System.out.println("\t\t1 Do you Want To Add Some more songs");
        System.out.println("\t\t2 Do you Want To play the songs in playlist");
        System.out.println("\t\t3 Go back to main menu");
        int choice = scanner.nextInt();
        do {
            switch (choice) {
                case (1):
                    addingSongsToPlayList();
                    break;
                case (2):
                    List<Songs> playList = exsitingPlaylist();
                    System.out.println("============================================================================");
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
                            System.out.println("PLEASE ENTER THE SONG_ID");
                            int songId = scanner.nextInt();
                            audioPlayer.PlaySong(songsDAO.getPathOfTheSong(songId));
                        case (3):
                            String[] arg = new String[0];
                            Implementation.main(arg);
                            break;
                        default:
                            System.err.println("PLEASE SELECT THE CORRECT OPTION");
                    }
                    break;
                case (3):
                    String[] arg = new String[0];
                    Implementation.main(arg);
                    break;
                default:
                    System.err.println("PLEASE SELECT THE RIGHT OPTION");
                    choice = scanner.nextInt();
                    break;
            }
        } while (choice < 4);

    }

    public List<Songs> exsitingPlaylist() throws SQLException, ClassNotFoundException {

        Connection connection = DB_connection.getConnection();
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        List<Songs> playListSongs = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT playListID,playListName from playlistdetails;");
        System.out.format("%-10s %-20s", "PlayListID", "PlayListName");
        System.out.println();
        while (resultSet.next()) {
            System.out.format("%-10s %-20s", resultSet.getInt(1), resultSet.getString(2));
            System.out.println();
        }
        System.out.println("\t Please enter the playListID you want to open");
        int playListID = scanner.nextInt();
        String sql = "Select songId from playlist where playListID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, playListID);

        ResultSet resultSet1 = preparedStatement.executeQuery();
        String sql3 = "Select * from songs where songId = ?";
        while (resultSet1.next()) {
            int songId = resultSet1.getInt(1);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql3);
            preparedStatement1.setInt(1, songId);
            ResultSet resultSet2 = preparedStatement1.executeQuery();
            while (resultSet2.next()) {

                playListSongs.add(new Songs(resultSet2.getInt(1), resultSet2.getString(2), resultSet2.getDouble(3), resultSet2.getString(4), resultSet2.getString(5), resultSet2.getString(6)));
            }
        }
        return playListSongs;
    }

}


