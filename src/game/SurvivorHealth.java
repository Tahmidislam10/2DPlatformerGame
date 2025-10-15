package game;

import city.cs.engine.BodyImage;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is Survivor health class
 */
public class SurvivorHealth implements CollisionListener, ActionListener {
    private Survivor survivor;

    private Game game;

/**
 * This adds Survivor and Game to constructor
 */
    public SurvivorHealth(Survivor s, Game game) {
        survivor = s;
        this.game = game;
    }


    /**
     * This is how the Armor bar and health bar go down first armor bar goes down then health bar goes down and then a death screen will appear.
     * @param collisionEvent Event to happen
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Enemy) {
            if (survivor.getArmor() < 1) {
                survivor.setHealth(survivor.getHealth() - 1);
                if (survivor.getHealth() == 0) {
                    game.gameEnded(true);
                }
            }

        }


        // this is the enemyTwo hit box if player hits Goblin.

        if (collisionEvent.getOtherBody() instanceof Goblin) {
            if (survivor.getArmor() < 1) {
                survivor.setHealth(survivor.getHealth() - 1);
                if (survivor.getHealth() == 0) {
                    game.gameEnded(true);
                }
            }

        }

        if (collisionEvent.getOtherBody() instanceof SpikeTrap) {
            if (survivor.getArmor() < 1) {
                survivor.setHealth(survivor.getHealth() - 1);
                if (survivor.getHealth() == 0) {
                    game.gameEnded(true);
                }
            }

        }


        if (collisionEvent.getOtherBody() instanceof Trollboss) {
            if (survivor.getArmor() < 1) {
                survivor.setHealth(survivor.getHealth() - 1);
                if (survivor.getHealth() == 0) {
                    game.gameEnded(true);
                }
            }

        }




        if (collisionEvent.getReportingBody() instanceof Survivor && collisionEvent.getOtherBody() instanceof Enemy) {
            survivor.playSound();
        }

        if (collisionEvent.getReportingBody() instanceof Survivor && collisionEvent.getOtherBody() instanceof Goblin) {
            survivor.playSound();
        }

        if (collisionEvent.getReportingBody() instanceof Survivor && collisionEvent.getOtherBody() instanceof SpikeTrap) {
            survivor.playSound();
        }

        if (collisionEvent.getReportingBody() instanceof Survivor && collisionEvent.getOtherBody() instanceof Trollboss) {
            survivor.playSound();
        }

        //----------------------------------------- For armor -----------------------------------------//



        // this is the enemyTwo hit box if player hits enemey

        if (collisionEvent.getOtherBody() instanceof Enemy) {
            survivor.setArmor(survivor.getArmor() - 1);

        }

        if (collisionEvent.getOtherBody() instanceof Goblin) {
            survivor.setArmor(survivor.getArmor() - 1);

        }

        if (collisionEvent.getOtherBody() instanceof SpikeTrap) {
            survivor.setArmor(survivor.getArmor() - 1);

        }



        //--------------------------------------------Death screen------------------------------------//

        if (collisionEvent.getOtherBody() instanceof Enemy){
            survivor = (Survivor) collisionEvent.getReportingBody();
            if (survivor.getArmor() < 1 && survivor.getHealth() == 0) {
                game.gameEnded(true);
            }
        }






    }

    /**
     * once Both armor bar and health bar go down the player will be destroyed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        survivor.destroy();
    }
}
