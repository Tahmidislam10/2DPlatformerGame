package game;

import city.cs.engine.*;

import javax.imageio.IIOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */


/**
 * This is Spike Trap class
 */
public class SpikeTrap extends StaticBody {

    // this is setting the shape of the food collectable
    private static final Shape spikeShape = new BoxShape(0.5f, 1f);


    // this is adding the rice ball image to the collectable
    private static final BodyImage image = new BodyImage("data/spiketrap.png", 2f );





    // this is adding it to the world and adding the shape and image I chose.

    /**
     * Constuctor holding image and shape of spike trap.
     * @param world
     */
    public SpikeTrap(World world){
        super(world,spikeShape);
        addImage(image);
    }







}
