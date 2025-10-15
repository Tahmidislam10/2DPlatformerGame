

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */


/**
 * This is the Armor Pickup class where Player will be able to Pick up the Armor
 */
public class ArmorPickup implements CollisionListener {



    private Survivor survivor;

    /**
     * This constructor will hold the survivor inside as we want to add the armor to the survivor for the survivor to collect
     * @param s This is the Survivor that we want to create the armor pickup in
     */
    public ArmorPickup(Survivor s){
        survivor = s;

    }

    /**
     * This is a collision listener which will add to the armor amount and destroy the armor then player gest in contact.
     * @param collisionEvent this destroys the Armor when the Survivor touches the armor and collects the armor in Survivor for armor bar.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {

        // this is adding the collision so when survivor touches food it will disappear

        if(collisionEvent.getOtherBody() instanceof Armor){
            survivor.addArmor();
            collisionEvent.getOtherBody().destroy();

        }


    }
}

