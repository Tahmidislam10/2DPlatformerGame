package game;

import javax.swing.*;
import java.awt.*;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is SMenuBackground  class
 */
public class SMenuBackground extends JPanel {



    private Image backgroundWon;
    private Image backgroundLost;
    private boolean won;

    /**
     * This Constructor holds the Images for splash menu
     * @param won this is a Boolean which need to meet a critera
     */
    public SMenuBackground(boolean won){
            backgroundWon = new ImageIcon("data/done.png").getImage();
            backgroundLost = new ImageIcon("data/Gameover.png").getImage();

    }

    public void setWon(boolean won) {
        this.won = won;
    }

    /**
     * this is the methods used the boolean Won
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(won)
        g.drawImage(backgroundWon,0 , 0 , 500,500, null);
        else
            g.drawImage(backgroundLost,0 , 0 , 500,500, null);


    }
}
