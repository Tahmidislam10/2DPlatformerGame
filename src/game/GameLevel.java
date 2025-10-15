package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the Game level class
 */
public abstract class GameLevel extends World {

    /**
     * I am calling suviour class to GameLevel
     */
    Survivor survivor;

    /**
     * I am calling Enemy class to GameLevel
     */
    Enemy enemy;


    //here I am adding Food class to the world
    /**
     * I am calling Food class to GameLevel
     */
    Food food;

    /**
     * I am calling Goblin class to GameLevel
     */
    Goblin goblin;

    /**
     * I am calling Portal class to GameLevel
     */
    Portal portal;

    /**
     * I am calling Spike trap class to GameLevel
     */
    SpikeTrap spikeTrap;

    /**
     * I am calling Troll boss class to GameLevel
     */
    Trollboss trollboss;


    /**
     * I am calling Game class to GameLevel
     */
    Game game;

    /**
     * This whole code which we need to for all the different levels such as ground platform and survivor location.
     * @param game This is adding GameLevel into Game
     */
    public GameLevel(Game game){

        this.game = game;

        Shape shape = new BoxShape(30, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -14.5f));
        ground.setFillColor(Color.darkGray);

        survivor = new Survivor(this);

       FoodPickup fp = new FoodPickup(survivor); // this allows me to in
       survivor.addCollisionListener(fp);

       ArmorPickup ap = new ArmorPickup(survivor);
       survivor.addCollisionListener(ap);

       survivor.addCollisionListener(new PortalClash(this, game));


       SurvivorHealth hp = new SurvivorHealth(survivor, game);
       survivor.addCollisionListener(hp);



    }



    public Survivor getSurvivor(){
        return survivor;
    }

    public abstract boolean isComplete();

}
