package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the Enemy Class where Enemy shape, Image and Movement Code are.
 */
public class Enemy extends Walker implements StepListener {


    // the is the vector of the beginning position

    Vec2 begPosition;

    // this is the shape and size of enemy
    private static final Shape enemyShape = new PolygonShape(0.13f,1.73f, 1.21f,0.74f, 1.1f,-0.82f, 0.73f,-1.87f, -0.82f,-1.87f, -0.73f,0.04f, -0.6f,1.04f);

    // this is the image used for the enemy
    private static final BodyImage image = new BodyImage("data/EnemyFacingLeft.gif", 5);

    private static SoundClip enemySound;


    static{
        try{
            enemySound = new SoundClip("data/explostion.wav");
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }



    // this is the constructor for the enemy

    /**
     * this holds the enemy shape, image and the step listener which will allow the enemy to moeve around
     * @param world This will add the enemey to the world
     */
    public Enemy (World world ){
        super(world, enemyShape);
        this.addImage(image);
        this.startWalking(5);
        world.addStepListener(this);

    }


    /**
     * Short description.
     * this is a method for the Enemy sound
     * Detailed description. You might describe the typical use of this method
     * what this method does is it will play the sound at the specific time that I want for the Enemy so it wil hold the Enemy sound and play the sound then the Super gets destroyed this will happen after the player kills the enemy
     */
    @Override
    public void destroy()
    {
        enemySound.play();
        super.destroy();
    }



    // this is the right variable for the enemy
    private float right;

    // this is the left variable for the enemy

    private float left;

    // this is setting the range for the enemy to wonder



    public void setValue(){
        Vec2 begPosition = this.getPosition();
        right = begPosition.x + 0;
        left = begPosition.x - 5;
        System.out.println(begPosition);

    }


    /**
     * this is used to control the direction in which my enemies will move and  will change the Image when they change directions
     * @param stepEvent this will save the direction I want my enemy's to move in
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > right){
            startWalking(-1.5f);
            BodyImage image = new BodyImage("data/EnemyFacingLeft.gif", 4);
            this.removeAllImages();
            this.addImage(image);
        }
        // this is adding the speed of the enemy when it goes right
        // this is also adding a right image when the enemy turns right
        else if (getPosition().x < left){
            startWalking(2);
            BodyImage image = new BodyImage("data/EnemyFacingRight.gif", 4);
            this.removeAllImages();
            this.addImage(image);
        }

    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
