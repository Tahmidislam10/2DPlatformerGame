package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;



/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the Armor Class where Armor Shape, Image and Sound code are.
 */
public class Armor extends StaticBody {



    private static final Shape armorShape = new BoxShape(0.5f, 1f);


    private static final BodyImage image = new BodyImage("data/armor.png", 2f );

    private static SoundClip armorsound;

    static{
        try{
            armorsound = new SoundClip("data/armorsound.wav");
            System.out.println("loading Armor sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }


    /**
     * this is the contractor for the armor it will hold the Image and Shape of the armor.
     * @param world This is the world that we want to create the Armor in.
     */
    public Armor(World world){
        super(world,armorShape);
        addImage(image);
    }

    /**
     * Short description.
     * this is a method for the Armor sound
     * Detailed description. You might describe the typical use of this method
     * what this method does is it will play the sound at the specific time that I want for  the armor so it wil hold the armor sound and play it and when it plays the armor contractor super will be destroyed from the world which is what I want as I want to play the sound when the armor is destroyed
     */
    public void destroy()
    {
        armorsound.play();
        super.destroy();
    }




}


