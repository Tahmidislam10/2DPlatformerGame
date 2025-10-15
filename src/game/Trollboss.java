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
 * This is Troll Boss class
 */
public class Trollboss extends Walker implements StepListener {




    private static final Shape trollshape = new BoxShape(1,2);

    private static final BodyImage trollImage = new BodyImage("data/trollidle.gif", 8);

    private static SoundClip trollsound;


    static{
        try{
            trollsound = new SoundClip("data/Monsterroar.wav");
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }


    private enum State {
        ROLL_LEFT, ROLL_RIGHT, STAND_STILL
    }
    public static final float RANGE = 15;

    private State state;

    public int getTrollhealth() {
        return trollhealth;
    }

    public void setTrollhealth(int trollhealth) {
        this.trollhealth = trollhealth;
    }

    public int trollhealth = 5;
    private boolean facingright = false;

    public void setFacingright(boolean facingright) {
        this.facingright = facingright;
    }

   private GameLevel game;

    /**
     * Constructor for the Troll boss holds the Image,Shape and state Troll boss is in.
     * @param game This adds Game to Troll Boss
     */
    public Trollboss(GameLevel game) {


        super(game, trollshape);
        this.game = game;
        addImage(trollImage);

        state = State.STAND_STILL;
        getWorld().addStepListener(this);
    }

    @Override
    public void destroy()
    {
        trollsound.play();
        super.destroy();
    }

    /**
     * This is the range between the player and Trollboss for it start attacking player.
     * @return The range between Troll Boss and Player
     */
    public boolean inRangeLeft() {


        Body a = game.getSurvivor();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;    //gap in (0,RANGE)
    }

    public boolean inRangeRight() {
        Body a = game.getSurvivor();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;  //gap in (-RANGE, 0)


    }


    /**
     * This is the updates section for actions which I want the Boss to do such as Attack the player.
     * @param e Event to happen
     */
    public void preStep(StepEvent e) {
        if (inRangeRight()) {
            if (state != State.ROLL_RIGHT) {
                state = State.ROLL_RIGHT;
                //setAngularVelocity(-2);
               // setLinearVelocity(new Vec2(3,0));
                startWalking(2);
                BodyImage image = new BodyImage("data/trollattack.gif", 8);
                this.removeAllImages();
                this.addImage(image);
            }
        } else if (inRangeLeft()) {
            //System.out.println("left");
            if (state != State.ROLL_LEFT) {
                state = State.ROLL_LEFT;
                //setAngularVelocity(2);
                //setLinearVelocity(new Vec2(-5,0));
                startWalking(-2);

                BodyImage image = new BodyImage("data/trollattackleft.gif", 8);
                this.removeAllImages();
                this.addImage(image);
            }
        } else {
            if (state != State.STAND_STILL) {
                state = State.STAND_STILL;
                //setAngularVelocity(0);
                //setLinearVelocity(new Vec2(0, 0));
                startWalking(0);
                if (facingright == true){;
                    startWalking(0);
                    BodyImage image = new BodyImage("data/trollidle.gif", 8);
                    this.removeAllImages();
                    this.addImage(image);

                }
                if (facingright == false){;
                    startWalking(0);
                    BodyImage image = new BodyImage("data/trollidleleft.gif", 8);
                    this.removeAllImages();
                    this.addImage(image);
                }



            }
        }

    }


    /**
     * this is the death method for the Boss the health will go down by 1 and once it hits 0 Boss will die.
     */
    public void enemydead(){
        this.trollhealth--;
        if (trollhealth <= 0){
            destroy();

        }
        System.out.println(trollhealth);

    }


    public void postStep(StepEvent e) {

    }
}









