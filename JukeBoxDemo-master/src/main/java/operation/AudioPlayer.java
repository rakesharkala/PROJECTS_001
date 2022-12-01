package operation;

import data.Songs;
import main.Implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    List<Songs> songsList;
    int songIndex;

    public void PlaySong(List<Songs> songsList) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.songsList = songsList;
        for (int i = 0; i < songsList.size(); i++) {
            songIndex = i;
            PlaySong(songsList.get(i).getSongPath());
        }

    }

    public void PlaySong(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File(songPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while (!response.equals("Q")) {
                System.out.println("P = play, T= Pause, S=Stop, L=Loop, R = Reset, N = NextSong, O = previousSong, Q = Quit, E = Exit, M = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();
                response = response.toUpperCase();


                switch (response) {
                    case ("P"): {
                        clip.start();
                        break;
                    }
                    case ("T"): {
                        clip.stop();
                        break;
                    }
                    case ("S"): {
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }
                    case ("L"): {
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("Q"):
                        clip.close();
                        break;
                    case ("N"):
                        songIndex += 1;
                        clip.close();
                        PlaySong(songsList.get(songIndex).getSongPath());
                        break;
                    case ("O"):
                        songIndex -= 1;
                        clip.close();
                        PlaySong(songsList.get(songIndex).getSongPath());
                        break;
                    case("M"):
                        String[] arg = new String[0];
                        Implementation.main(arg);
                        break;
                    case("E"):
                        System.exit(0);
                        break;

                    default:
                        System.err.println("PLEASE SELECT THE CORRECT OPTION");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}