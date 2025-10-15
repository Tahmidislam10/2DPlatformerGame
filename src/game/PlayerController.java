package game;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is Player controller class
 */
public class PlayerController implements KeyListener {

    private Survivor survivor;


    /**
     * Constructor for controller
     * @param survivor This add Controller to Survivor
     */
    public PlayerController(Survivor survivor){
        this.survivor = survivor;

    }






    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * This is the Keypressed method this will perform a action when a key is pressed
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("key pressed " + e.getKeyChar());

//  This is the key pressed this will allow me to move my char when I click on a specific key

        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            survivor.removeAllImages();
            survivor.setFacingright(false);
            survivor.startWalking(-5);
            BodyImage image = new BodyImage("data/girlrunningleft.gif", 4);
            survivor.addImage(image);
        } else if (code == KeyEvent.VK_D) {
            survivor.removeAllImages();
            survivor.setFacingright(true);
            survivor.startWalking(5);
             BodyImage image = new BodyImage("data/girlruning.gif", 4);

            survivor.addImage(image);
        } else if( code == KeyEvent.VK_W){
            survivor.jump(9);
           // BodyImage image = new BodyImage("data/jump.png", 4);
            //survivor.removeAllImages();
            //survivor.addImage(image);

        } else if (code == KeyEvent.VK_SPACE) {
            survivor.shoot();
            if (survivor.isFacingright()){
                survivor.removeAllImages();
                BodyImage image = new BodyImage("data/girlshoot.gif", 4);
                survivor.addImage(image);

            }
            else if (!survivor.isFacingright()){
                survivor.removeAllImages();
                BodyImage image = new BodyImage("data/girlshootingleft.gif", 4);
                survivor.addImage(image);
            }
            }


    }

    /**
     * This is the Keyp Realised  method this will perform a action when a key is pressed
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        //System.out.println("key released " + e.getKeyChar());


        if (code == KeyEvent.VK_A) {
            survivor.removeAllImages();
            survivor.startWalking(0);
            BodyImage image = new BodyImage("data/girlidleleft.gif", 4);
            survivor.addImage(image);
        } else if (code == KeyEvent.VK_D) {
            survivor.removeAllImages();
            survivor.startWalking(0);
            BodyImage image = new BodyImage("data/girlidle.gif", 4);
            survivor.addImage(image);


        }
        else if (code == KeyEvent.VK_W) {
            survivor.stopWalking();


        } else if (code == KeyEvent.VK_SPACE) {
            survivor.startWalking(0);

        }

    }

    /**
     * this will update the controlls in different levels
     * @param survivor This add the update to Survivor
     */
    public void updateSurvivor(Survivor survivor){
        this.survivor = survivor;
    }

}