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
 * This is the Goblin class
 */
public class Goblin extends Walker implements StepListener {

    // the is the vector of the beginning position
    Vec2 begPosition;

    // this is the shape and size of enemy
    private static final Shape goblinShape = new PolygonShape(0.42f,0.8f, 1.0f,-0.42f, 0.64f,-1.85f, -0.7f,-1.85f, -1.19f,-0.24f, -0.8f,0.7f);

    // this is the image used for the goblin
    private static final BodyImage image = new BodyImage("data/goblin.gif", 3);

    private static SoundClip enemySound;

    static{
        try{
            enemySound = new SoundClip("data/explostion.wav");
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    // this is the constructor for the goblin.

    public Goblin (World world ){
        super(world, goblinShape);
        this.addImage(image);
        this.startWalking(5);
        world.addStepListener(this);

    }

    @Override
    public void destroy()
    {
        enemySound.play();
        super.destroy();
    }



    // this is the right variable for the goblin
    private float right;

    // this is the right variable for the goblin

    private float left;

    // this is setting the range for the goblin to wonder


    public void setValue() {
        Vec2 begPosition = this.getPosition();
        right = begPosition.x + 0;
        left = begPosition.x - 5;
        System.out.println(begPosition);
    }



    @Override
    public void preStep(StepEvent stepEvent) {
        // this is adding the speed of the goblin when it goes left
        // this is also adding a right image when the goblin turns left
            if (getPosition().x > right){
                startWalking(-1.5f);
                BodyImage image = new BodyImage("data/goblin.gif", 4);
                this.removeAllImages();
                this.addImage(image);
            }
            // this is adding the speed of the goblin when it goes right
            // this is also adding a right image when the goblin turns right

            else if (getPosition().x < left){
                startWalking(2);
                BodyImage image = new BodyImage("data/goblinRight.gif", 4);
                this.removeAllImages();
                this.addImage(image);
            }




    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
