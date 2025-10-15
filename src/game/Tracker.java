package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameLevel;
import game.GameView;
import game.Survivor;
/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is Tracker class
 */
public class Tracker implements StepListener {
    private GameView view;
    private Survivor survivor;


    /**
     * This is the Constructor for the Tracker
     * @param view Add view to tracker
     * @param survivor Add survivor to tracker
     */
    public Tracker(GameView view, Survivor survivor) {
        this.view = view;
        this.survivor = survivor;
    }

    public void preStep(StepEvent e) {}
    /**
     * this places the view to center at the survivor.
     */
    public void postStep(StepEvent e) {
        view.setCentre(survivor.getPosition());
    }
}

