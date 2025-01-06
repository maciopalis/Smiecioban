import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicManager {
    private Clip clip;

    public MusicManager() {
    }

    public void playMainMenuMusic() {
        playSound("music/menu_music.wav");
    }

    public void playGameMusic() {
        playSound("music/game_music.wav");
    }

    public void playSound(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopSound() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}