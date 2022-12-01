package main;

import data.Songs;
import data_accessing_object.PlayListDAO;
import data_accessing_object.SongsDAO;
import operation.AudioPlayer;
import operation.JukeOperation;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Implementation {

   public static void main(String args[])
   {
        Scanner scanner = new Scanner(System.in);
        PlayListDAO playListDAO = new PlayListDAO();
        AudioPlayer audioPlayer = new AudioPlayer();
        SongsDAO songsDAO = new SongsDAO();

        int optionOfMainMenu = 0;
        while (optionOfMainMenu != 5) {
            System.out.println("============================================================================");
            System.out.println("\t\tWELCOME TO YOUR  MUSIC SYSTEM");
            System.out.println("\t\tPLEASE SELECT THE OPTION FROM THE MENU");
            System.out.println("\t\t1 : Search A Song");
            System.out.println("\t\t2 : Creating A New PlayList");
            System.out.println("\t\t3 : Go To Existing PlayList");
            System.out.println("\t\t4 : Add Songs To The Existing playList ");
            System.out.println("\t\t5 : Exit");
            System.out.println("============================================================================");
            optionOfMainMenu = scanner.nextInt();
            try {
                switch (optionOfMainMenu) {

                    case (1):
                        JukeOperation jukeOperation = new JukeOperation();
                        System.out.println("============================================================================");
                        System.out.println("\t\tSearch song based on following option");
                        System.out.println("\t\t1 : Display all Songs");
                        System.out.println("\t\t2 : Artist Name");
                        System.out.println("\t\t3 : Genre");
                        System.out.println("\t\t4 : Song Name");
                        System.out.println("\t\t5 : GO BACK TO PREVIOUS MENU");
                        System.out.println("============================================================================");


                        int option = scanner.nextInt();
                        switch (option) {

                            case (1):
                                List<Songs> allSongs = jukeOperation.displayAllSongs();
                                System.out.println("==================================================================================================");
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("==================================================================================================");
                                for (Songs songs : allSongs) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                System.out.println("============================================================================");
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
                                                System.out.println("==================================================================================================");
                                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                                System.out.println("==================================================================================================");
                                                for (Songs songs : playList) {
                                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                                }
                                                System.out.println("==================================================================================================");
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
                                                        System.out.println("==================================================================================================");
                                                        for (Songs songs : playList) {
                                                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                                        }
                                                        System.out.println("PLEASE ENTER THE SONGID YOU WANT TO PLAY");
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
                                        String[] arg = new String[0];
                                        Implementation.main(arg);
                                        break;
                                    default:
                                        System.err.println("PLEASE SELECT THE RIGHT OPTION");


                                }
                                break;

                            case (2):
                                System.out.println("PLEASE ENTER THE ARTIST NAME YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String artistName = scanner.nextLine();
                                List<Songs> songsListOfArtist = jukeOperation.searchArtistByArtistName(artistName);
                                System.out.println("==================================================================================================");
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("==================================================================================================");
                                for (Songs songs : songsListOfArtist) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                jukeOperation.playSongs();
                                break;
                            case (3):
                                System.out.println("PLEASE ENTER THE GENRE TYPE YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String genreType = scanner.nextLine();
                                List<Songs> songsList = jukeOperation.searchGenreByGenreType(genreType);
                                System.out.println("==================================================================================================");
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("==================================================================================================");
                                for (Songs songs : songsList) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                jukeOperation.playSongs();
                                break;
                            case (4):
                                System.out.println("PLEASE ENTER THE SONG NAME YOU WANT TO SEARCH");
                                scanner.nextLine();
                                String songName = scanner.nextLine();
                                List<Songs> songsListBasedOnName = jukeOperation.searchSongBySongName(songName);
                                System.out.println("==================================================================================================");
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("==================================================================================================");
                                for (Songs songs : songsListBasedOnName) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                jukeOperation.playSongs();
                                break;
                            case (5):
                                String[] arg = new String[0];
                                Implementation.main(arg);
                                break;

                            default:
                                System.err.println("PLEASE SELECT THE RIGHT OPTION");
                        }


                        break;
                    case (2):
                        playListDAO.creatingAPlaylist();
                        break;

                    case (3):
                        List<Songs> playListEx = playListDAO.exsitingPlaylist();
                        System.out.println("==================================================================================================");
                        System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                        System.out.println("==================================================================================================");
                        for (Songs songs : playListEx) {
                            System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                        }
                        System.out.println("==================================================================================================");
                        System.out.println("\t\t1: DO YOU WANT TO PLAY THE ENTIRE PLAYLIST");
                        System.out.println("\t\t2: DO YOU WANT TO PLAY A SONG FROM PLAYLIST");
                        System.out.println("\t\t3: GO BACK TO MAIN MENU");
                        int select = scanner.nextInt();
                        switch (select) {
                            case (1):
                                audioPlayer.PlaySong(playListEx);
                                break;
                            case (2):
                                System.out.println("==================================================================================================");
                                System.out.format("%-10s %-30s %-30s %-30s %-30s \n", "SongID", "SongName", "Duration", "GenreType", "Artist");
                                System.out.println("==================================================================================================");
                                for (Songs songs : playListEx) {
                                    System.out.format("%-10s %-30s %-30s %-30s %-30s \n", songs.getSongID(), songs.getSongName(), songs.getDuration(), songs.getGenreType(), songs.getArtistName());
                                }
                                System.out.println("PLEASE ENTER THE SONG_ID YOU WANT TO PLAY");
                                int song_id = scanner.nextInt();
                                audioPlayer.PlaySong(songsDAO.getPathOfTheSong(song_id));
                        }
                        break;
                    case (4):
                        playListDAO.addingSongsToPlayList();
                    case (5):
                        System.exit(0);
                }
            } catch (UnsupportedAudioFileException e) {
                System.out.println("e = " + e);
            } catch (SQLException e) {
                System.out.println("e = " + e);
            } catch (LineUnavailableException e) {
                System.out.println("e = " + e);
            } catch (IOException e) {
                System.out.println("e = " + e);
            } catch (ClassNotFoundException e) {
                System.out.println("e = " + e);
            }
        }
    }
}

