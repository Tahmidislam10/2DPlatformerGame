package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is SMenu class where the quit game and restart buttons are.
 */
public class SMenu {
    private JButton quitButton;
    private JButton restartButton;
    private JPanel mainPanel;

    /**
     * This is the Action performed for the restart button & Quit button , when button is clicked it will go the restart method which makes it go back to level 1 and when quit button is clicked it will exit the user out the game.
     * @param game
     */
    public SMenu(Game game) {
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart");
                game.restartGame();

            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public SMenuBackground getMainPanel(){
        return (SMenuBackground) mainPanel;
    }

    private void createUIComponents() {
        mainPanel = new SMenuBackground(false);
    }
}
