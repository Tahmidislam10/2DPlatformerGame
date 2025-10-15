package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;


/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the food Pickup class where player can pick up food.
 */
public class FoodPickup implements CollisionListener {


    // this is adding the Survivor class to FoodPickUp
    private Survivor survivor;

    /**
     * This constructor will hold the survivor inside as we want to add the food to the survivor for the survivor to collect.
     * @param s This is the Survivor that we want to create the food pickup in.
     */
    public FoodPickup(Survivor s){
        survivor = s;

    }
    /**
     * This is a collision listener which will add to the Food amount and destroy the food then player gets in contact.
     * @param collisionEvent this destroys the Food when the Survivor touches the food and collects the food in Survivor for food count.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {

        // this is adding the collision so when survivor touches food it will disappear

        if(collisionEvent.getOtherBody() instanceof Food){
            survivor.addFoods();
            collisionEvent.getOtherBody().destroy();

        }


    }
}
