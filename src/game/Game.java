package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.sound.midi.Track;
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.plaf.PanelUI;

/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */

/**
 * This is the game class
 */
public class Game {

    static GameLevel currentLevel;

    /**
     * this is adding the Game class  to Game class
     */
    GameView view;

    /**
     * this is adding the controller class to game
     */
    PlayerController controller;

    private JFrame frame;

    private SMenu menu;

    private boolean menuOn = false;


    /**
     * this is the game method which holds the information such as the current level, key listener, mouse listener and  frame information
     */
    public Game() {

        // this is initialize the world
        currentLevel = new Level1(this);
        // this is adding the size of the view to the world so world  will be 900 wide and 600 tall.
        view = new GameView(currentLevel, 900, 600, currentLevel.getSurvivor());
        // this is adding the controller to the world which will allow player to move.
        controller = new PlayerController(currentLevel.getSurvivor());
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));
        controller.updateSurvivor(currentLevel.getSurvivor());
        // this is the name of the game in the world


        frame = new JFrame("Tahmid's Game");
        frame.add(view);
        // this will enable the frame to quit the application when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);





        // this will not let the frame be realised
        frame.setResizable(false);

        // this will size the frame to fit world view
        frame.pack();

        // this will make the frame visable
        frame.setVisible(true);

        // this is the debuger which allows me to see all the bodies of the code.
        JFrame debugView = new DebugViewer(currentLevel, 500, 500);
        // start our game world simulation!
        currentLevel.start();


    }


    /**
     * this is the end Game method which show a screen when player has died or finished the game
     * @param won this is a boolean when won is true player has Won game and when Won is false player has Lost game.
     */
    public void gameEnded(boolean won){
        currentLevel.stop();
        frame.remove(view);
        menu = new SMenu(this);
        menu.getMainPanel().setPreferredSize(new Dimension(500,500));


        frame.add(menu.getMainPanel());
        frame.repaint();
        frame.pack();
    }

    /**
     * this is a method for the restart button
     */
    public void restartGame(){
        currentLevel = new Level1(this);
        view.setWorld(currentLevel);
      // ((Level1) currentLevel).levelone.stop();
        currentLevel.start();
        view.updateSurvivor(currentLevel.getSurvivor());

        controller = new PlayerController(currentLevel.getSurvivor());
        view.addKeyListener(controller);

        frame.remove(menu.getMainPanel());
        frame.add(view);
        frame.repaint();
        frame.pack();

        view.requestFocus();
    }

    /**
     * Runs the game.
     */
    public static void main(String[] args) {


        new Game();
    }

    public static GameLevel getCurrentLevel() {
        return currentLevel;
    }


    /**
     * this is a method used to go to the next level
     */
    public void goToNextlevel() {
        System.out.println("yes lets go to next level "); //ngl i cant find why its not


        if (currentLevel instanceof Level1) {
            currentLevel.stop();
           ((Level1) currentLevel).levelone.stop();
            currentLevel = new Level2(this);

            view.setWorld(currentLevel);
            view.updateSurvivor(currentLevel.getSurvivor());
            controller.updateSurvivor(currentLevel.getSurvivor());
            currentLevel.start();

        } else if (currentLevel instanceof Level2) {
            currentLevel.stop();
            ((Level2) currentLevel).leveltwo.stop();
            currentLevel = new Level3(this);
            Tracker tracker = new Tracker(view, currentLevel.getSurvivor());
            currentLevel.addStepListener(tracker);
            view.setWorld(currentLevel);
            view.updateSurvivor(currentLevel.getSurvivor());
            controller.updateSurvivor(currentLevel.getSurvivor());
            currentLevel.start();


        } else if( currentLevel instanceof Level3){
            currentLevel.stop();
            ((Level3) currentLevel).levelthree.stop();
           // currentLevel = new Level3(this);
            view.setWorld(currentLevel);
            view.updateSurvivor(currentLevel.getSurvivor());
            controller.updateSurvivor(currentLevel.getSurvivor());
            currentLevel.start();
            gameEnded(false);
        }
    }



}

