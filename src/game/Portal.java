package game;

import city.cs.engine.*;

/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */


/**
 * This is Portal class
 */
public class Portal extends StaticBody {
    // this is setting the shape of the food collectable
    private static final Shape PortalShape = new BoxShape(0.5f, 1f);


    // this is adding the rice ball image to the collectable
    private static final BodyImage image = new BodyImage("data/portal.gif", 3f );

    // this is adding it to the world and adding the shape and image I chose.


    /**
     * Method containing Shape and Image of portal
     * @param world Adds portal to world
     */
    public Portal(World world){
        super(world,PortalShape);
        addImage(image);
    }
}
