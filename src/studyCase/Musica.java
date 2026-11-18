
package studyCase;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {

    private Clip clip;

    public void reproducir() {
        try {
            File archivo = new File("src/sounds/stereo_madness.wav");

            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir musica");
        }
    }

    public void detener() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
