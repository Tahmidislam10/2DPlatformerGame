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
 * This is the Food class where code for Food shape, image and sound is.
 */
public class Food extends Walker {

    // this is setting the shape of the food collectable
    private static final Shape foodShape = new BoxShape(0.5f, 1f);


    // this is adding the rice ball image to the collectable
    private static final BodyImage image = new BodyImage("data/rice.png", 2f );

    private static SoundClip foodsSound;

    static{
        try{
            foodsSound = new SoundClip("data/eating.wav");
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }



    // this is adding it to the world and adding the shape and image I chose.

    /**
     * This is the constructor for food it holds the shape and Image of food.
     * @param world Adds the Food to the world
     */
     public Food(World world){
        super(world,foodShape);
        addImage(image);
     }


    /**
     * Plays an eating sound when food is destroyed.
      */
    @Override
    public void destroy()
     {
         foodsSound.play();
         super.destroy();
     }






}
