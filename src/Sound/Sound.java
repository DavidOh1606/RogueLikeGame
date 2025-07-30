package Sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.InputStream;

import java.net.URL;
import java.util.*;

public class Sound {

    private static final float VOLUME_OFFSET = -3.0f;
    
    private Clip clip;  
    private static final Map<String, URL> SOUNDS = Map.of(
        "battle", Sound.class.getClassLoader().getResource("Sound/battle song.wav"),
        //"button", Sound.class.getClassLoader().getResource("Sound/buttonsound.wav"),
        "canon", Sound.class.getClassLoader().getResource("Sound/canon.wav"),
        "damage", Sound.class.getClassLoader().getResource("Sound/damage.wav"),
        "lullaby", Sound.class.getClassLoader().getResource("Sound/lullaby.wav")
    );

    //private int volume = 100;


    public Sound(String name) {    
        if (!setClip(name)) {
            setClip("button");
        }
    }

    public void playSound(boolean loop) {
        clip.start();

        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void playSound() {
        playSound(false);
    }

    public void stopSound() {

        clip.stop();
    }

    private boolean setClip(String name) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(SOUNDS.get(name));
            clip = AudioSystem.getClip();
            clip.open(ais);
        }

        catch(Exception e) {    
            return false;
        }


        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(VOLUME_OFFSET);

        return true;
    }

}
