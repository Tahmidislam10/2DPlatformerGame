package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the Collision class where enemy collision are with player and how player is able to shoot enemy's
 */
public class EnemyCollison implements CollisionListener, ActionListener {


    // here I am adding survior class to enemey collison
    private  Survivor survivor;

    // Here I am adding enemy class as a body to enemy collison
    private  Body enemy;

    // Here I am adding enemyTwo class as a body to enemy collison
    private Body enemyTwo;

    // Here I am adding goblin class as a body to enemy collison

    private Body goblin;

    // Here I am initilizing thisBody as a variable.

    private Body thisBody;

    // Here I am initilizing other body  as a variable.
    private Body otherBody;

    // Here I am initilizing Killcount as a static int.


    /**
     * This is a filed I have made called killcount which will store all the kills player has.
     */
    static int KillCount;

    private Trollboss trollboss;


    /**
     * This is the contructor for Enemy collision
     * @param s this is the Survivour which we are adding to the constructor
     */
    public EnemyCollison(Survivor s){

        survivor = s;

    }


    /**
     * This is how im adding a collision to my bullets so when they hit the enemy,goblin and Troll boss it will kill the enemy they way I did this is by making two different variables a reporting body and another body when they come in contact the otherbody will be destroyed    .
     * @param collisionEvent this will add the collision event to variable collision event
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
         //collisionEvent.getReportingBody().destroy();

        if (collisionEvent.getOtherBody() instanceof   Enemy ){
            thisBody = collisionEvent.getReportingBody();
            otherBody= collisionEvent.getOtherBody();
            enemy = collisionEvent.getOtherBody();
            enemy.removeAllImages();
            enemy.addImage(new BodyImage("data/explosion.gif", 4));


            Timer timer = new Timer(400, this);
            timer.setRepeats(false);
            timer.start();


        }

        if(collisionEvent.getOtherBody()instanceof Goblin){
            thisBody = collisionEvent.getReportingBody();
            otherBody= collisionEvent.getOtherBody();
            goblin= collisionEvent.getOtherBody();
            goblin.removeAllImages();
            goblin.addImage(new BodyImage("data/explosion.gif", 4 ));

            Timer timer = new Timer(400, this);
            timer.setRepeats(false);
            timer.start();

        }
        if (collisionEvent.getOtherBody() instanceof Trollboss){

            ((Trollboss) collisionEvent.getOtherBody()).enemydead();

        }

    }


    /**
     * This is the event which will happen for the collection so when the bullet hits enemy it will destroy the bullet and the enemy and kill count will go up
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        thisBody.destroy();
        otherBody.destroy();
        // this will be used for Kill count
        KillCount++;

    }



}
