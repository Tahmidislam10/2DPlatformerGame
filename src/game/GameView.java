package game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is Game view class where Image of Health, Armor, food count and kill count are and how they display on screen.
 */
public class GameView extends UserView {

  // this is adding survivor class to GameView
    private Survivor survivor;

    // this is adding food class and making it an image in GameView.
    private Image food;

    // this is adding Font class to GameView.
    private Font font;

    // this is adding background as a image in Gameview.
    private final Image levelonebackground;

    private  final Image leveltwobackground;

    private final Image levelthreebackground;

    private final Image fullhealth;
    private final Image halfhealth;
    private final Image lowhealth;
    private final Image verylowhealth;
    private final Image deadhealth;

    private final Image armorbar1;

    private final Image armorbar2;

    private final Image armorbar3;

    private final Image armorbar4;

    private final Image armorbar5;

    private Game gameLevel;


    /**
     *
     * @param w
     * @param width This is the width of Image
     * @param height This is the Height of Image
     * @param survivor This is adding the Survivor to Image
     */
    public GameView(GameLevel w, int width, int height, Survivor survivor) {
        super(w,width, height);
        this.levelonebackground = new ImageIcon("data/BackgroundForest.gif").getImage();
        this.leveltwobackground = new ImageIcon("data/leveltwobackground.gif").getImage();
        this.levelthreebackground = new ImageIcon("data/levelthreebackground.gif").getImage();
        this.food = new ImageIcon("data/rice.png").getImage();
        this.fullhealth = new ImageIcon("data/fullhealthbar.png").getImage();
        this.halfhealth = new ImageIcon("data/halfhealthbar.png").getImage();
        this.lowhealth  = new  ImageIcon("data/lowhealthbar.png").getImage();
        this.verylowhealth = new ImageIcon("data/verylowhealthbar.png").getImage();
        this.deadhealth = new ImageIcon("data/deadhealthbar.png").getImage();
        this.armorbar1 = new ImageIcon("data/armorbar1.png").getImage();
        this.armorbar2 = new ImageIcon("data/armorbar2.png").getImage();
        this.armorbar3 = new ImageIcon("data/armorbar3.png").getImage();
        this.armorbar4 = new ImageIcon("data/armorbar4.png").getImage();
        this.armorbar5 = new ImageIcon("data/armorbar5.png").getImage();

        this.survivor = survivor;


    }

    /**
     * This will change the Background for all the different levels
     * @param g This is adding the image to Graphics2D
     */
    @Override
    protected void paintBackground(Graphics2D g){
        if (Game.getCurrentLevel() instanceof Level1) {
            g.drawImage(levelonebackground, 0, 0, 900, 600, this);
        }
        else if (Game.getCurrentLevel() instanceof Level2){
            g.drawImage(leveltwobackground, 0, 0, 900, 600, this);

        }
        else if(Game.getCurrentLevel() instanceof  Level3){
            g.drawImage(levelthreebackground, 0, 0, 900, 600, this);
        }

    }

    /**
     * This will display display the Food, health bar, armor bar and kill count.
     * @param g This is adding the image to Graphics2D
     */
    protected void paintForeground(Graphics2D g){
        font = new Font("Arial", Font.BOLD, 20); // font sent to Arial
        String FoodCollected = "Food: " + survivor.getFoods(); // adding text Food and adding food count so it displays
        g.setFont(font); // adding the font
        g.setColor(Color.WHITE); // adding colour white to the count
        g.drawString(FoodCollected, 9, 45); // setting the position of the food count
        g.drawString(String.valueOf("Kills: " + EnemyCollison.KillCount), 10, 22);
        if (survivor.getHealth() == 5) {
            g.drawImage(fullhealth, 300,-5,200,50,this);
        }
        else if(survivor.getHealth() ==4){
            g.drawImage(halfhealth, 300,-5,200,50,this);
        }
        else if(survivor.getHealth() == 3){
            g.drawImage(lowhealth, 300,-5,200,50,this);
        }
        else if(survivor.getHealth() == 2 ){
            g.drawImage(verylowhealth, 300,-5,200,50,this);
        }
        else if(survivor.getHealth() ==  1){
            g.drawImage(deadhealth, 500,-5,200,50,this);
        }
        if (survivor.getArmor() == 1){
            g.drawImage(armorbar1, 500,-5,200,50,this);
        }
        else if (survivor.getArmor() == 2){
            g.drawImage(armorbar2, 500,-5,200,50,this);
        }
        else if (survivor.getArmor() == 3){
            g.drawImage(armorbar3, 500,-5,200,50,this);
        }
        else if(survivor.getArmor() == 4){
            g.drawImage(armorbar4, 300,-5,200,50,this);
        }
        else if (survivor.getArmor() == 5){
            g.drawImage(armorbar5, 500,-5,200,50,this);
        }


    }

    /**
     * This will update the all the food count, Armor bar and health bar when player goes to next level.
     * @param survivor
     */
    public void updateSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }
}
