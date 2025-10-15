package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is Portal clash class
 */
public class PortalClash implements CollisionListener {
    GameLevel level;
    Game g;

    /**
     * This is the Constructor for portal.
     * @param level Adds portal to Level
     * @param game Adds portal to Game
     */
    public PortalClash(GameLevel level, Game game){
        this.level = level;
        g = game;
    }

    /**
     * This is the collision Method event for portal When player is in contact with portal it will take them to next level.
     * @param e This is the Event to Happen.
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof Portal){
            e.getOtherBody().destroy();
            if(level.isComplete()){
                g.goToNextlevel();
            }
        }
    }
}
