package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;


/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is Survivor class
 */
public class Survivor extends Walker {

    // this is the shape and size of survivor
    private static final Shape survivorShape = new BoxShape(1,2);

    // This is the image for my charactor which is standing idle.
    private static final BodyImage image = new BodyImage("data/girlidle.gif", 4);



    private boolean facingright = false;



    private int foods = 0;

    private int health = 0;

    private int armor = 1;

    private  static SoundClip damageSound;


    static{
        try{
            damageSound = new SoundClip("data/damage.wav");
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }


    /**
     * Damage sound methods held by player.
     */
    public void playSound()
    {
        damageSound.play();
    }


    /**
     * holds the image, shape, food number, health number and armor number.
     * @param world add this to the world
     */
    public Survivor(World world ){
        super(world, survivorShape);
        this.addImage(image);
        SolidFixture P = new SolidFixture(this,survivorShape);
        P.setFriction(30);

        foods = 0;
        health = 5;
        armor = 1;

    }




    // this is the class for the projectile which is the grenades the survivor will shoot.


    /**
     * This is the shoot method used by the player.
     */
    public void shoot(){
        // this is the shape of the projectile.
        DynamicBody projectile = new DynamicBody(this.getWorld(), new CircleShape(0.2f));
        //this is the colour of the projectile
        projectile.setFillColor(Color.blue);

        // this will load the image of the grenade
        projectile.addImage(new BodyImage("data/bullet.png"));

        // this will set the direction of the grenade.
        EnemyCollison impact = new EnemyCollison(this);
        projectile.addCollisionListener(impact);
        if (facingright){projectile.setPosition(new Vec2(this.getPosition().x+2,this.getPosition().y+0));
        projectile.setLinearVelocity(new Vec2(20,0));

        }
        else {projectile.setPosition(new Vec2(this.getPosition().x-2,this.getPosition().y+0));
            projectile.setLinearVelocity(new Vec2(-20,0));

        }
    }

    /**
     * This sets the number of food there is.
     * @param foods This holds the amount of food there is.
     */
    public void setFoods( int foods){ this.foods = foods;}

    /**
     * This gets the Food
     * @return This returns the food
     */
    public int getFoods(){return foods;}


    /**
     * This gets the Health
     * @return This returns the Health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * This sets the Health amount
     * @param health this is the number that the health is on.
     */
    public void setHealth(int health) {
        this.health = health;
    }


    /**
     * this adds the food count by 1.
     */
    public void addFoods(){
        setFoods(getFoods()+1);
    }

    /**
     * This sets the Armor amount.
     * @param armor This sets the number which the armor is on.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * This gets the Armor
     * @return This returns the Armor amount
     */
    public int getArmor() {
        return armor;
    }

    /**
     * This adds the Armor by 1
     */
    public void addArmor(){
        setArmor(getArmor()+1);
    }

    /**
     * This is used for shooting to direct which way the player is facing.
     * @param facingright This is when player faces rigjt
     */
    public void setFacingright(boolean facingright) {
        this.facingright = facingright;
    }

    /**
     * This is boolean for the facing direction of player
     * @return this returns facing right
     */
    public boolean isFacingright() {
        return facingright;
    }
}
