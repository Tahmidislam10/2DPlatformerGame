package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * @author      Name: Tahmid Islam Email Tahmidul.islam.3@city.ac.uk
 * @version     1.2
 * @since       2023
 */
/**
 * This is level 2 class
 */
public class Level2 extends GameLevel{
    public  SoundClip leveltwo;


    /**
     * this is Constructor for level 2 which will hold all the different Item which are needed for level 1.
     * @param game This is adding level 2 to game.
     */
    public Level2(Game game){
        super(game);

        EnemyCollison en = new EnemyCollison(survivor);
        ArmorPickup ap = new ArmorPickup(survivor);
        // these are platforms which the charactor will jump on to get collectables

        //this is the first platform
        Shape platformShape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-19, 8));
        platform1.addImage(new BodyImage("data/platformtwo.png",4));


        // this second platform

        Shape platformShape2 = new BoxShape(6,0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(-9, 8));
        platform2.addImage(new BodyImage("data/platformtwo.png",6));

        // this is third platform

        Shape platformShape3 = new BoxShape(4,0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(1, 8));
        platform3.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape4 = new BoxShape(4,0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(10, 9 ));
        platform4.addImage(new BodyImage("data/platformtwo.png",4));


        Shape platformShape6 = new BoxShape(6,0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(18, 2.5f));
        platform6.addImage(new BodyImage("data/platformtwo.png",6));

        Shape platformShape8 = new BoxShape(6,0.5f);
        StaticBody platform8 = new StaticBody(this, platformShape8);
        platform8.setPosition(new Vec2(10, 2.5f));
        platform8.addImage(new BodyImage("data/platformtwo.png",6));

        Shape platformShape9 = new BoxShape(6,0.5f);
        StaticBody platform9 = new StaticBody(this, platformShape9);
        platform9.setPosition(new Vec2(2, 2.5f));
        platform9.addImage(new BodyImage("data/platformtwo.png",6));

        Shape platformShape10 = new BoxShape(3,0.5f);
        StaticBody platform10 = new StaticBody(this, platformShape10);
        platform10.setPosition(new Vec2(-6, 2.5f));
        platform10.addImage(new BodyImage("data/platformtwo.png",3));



        Shape platformShape12 = new BoxShape(4,0.5f);
        StaticBody platform12 = new StaticBody(this, platformShape12);
        platform12.setPosition(new Vec2(-14, 2.5f));
        platform12.addImage(new BodyImage("data/platformtwo.png",4));





        Shape platformShape14 = new BoxShape(4,0.5f);
        StaticBody platform14 = new StaticBody(this, platformShape14);
        platform14.setPosition(new Vec2(-17, -6));
        platform14.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape15 = new BoxShape(4,0.5f);
        StaticBody platform15 = new StaticBody(this, platformShape15);
        platform15.setPosition(new Vec2(-14, -6));
        platform15.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape16 = new BoxShape(4,0.5f);
        StaticBody platform16 = new StaticBody(this, platformShape16);
        platform16.setPosition(new Vec2(-6.5f, -6));
        platform16.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape17 = new BoxShape(4,0.5f);
        StaticBody platform17 = new StaticBody(this, platformShape17);
        platform17.setPosition(new Vec2(-2.5f, -6));
        platform17.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape18 = new BoxShape(4,0.5f);
        StaticBody platform18 = new StaticBody(this, platformShape18);
        platform18.setPosition(new Vec2(4, -6));
        platform18.addImage(new BodyImage("data/platformtwo.png",4));

        Shape platformShape19 = new BoxShape(4,0.5f);
        StaticBody platform19 = new StaticBody(this, platformShape19);
        platform19.setPosition(new Vec2(10, -9));
        platform19.addImage(new BodyImage("data/platformtwo.png",4));

        FoodPickup fp = new FoodPickup(survivor); // this allows me to in

        Food f1 = new Food(this);
        f1.setPosition(new Vec2(-15, -14));
        f1.addCollisionListener(fp);

        Food f2 = new Food(this);
        f2.setPosition(new Vec2(5, 4));
        f2.addCollisionListener(fp);

        Food f3 = new Food(this);
        f3.setPosition(new Vec2(-1, 4));
        f3.addCollisionListener(fp);

        Food f4 = new Food(this);
        f4.setPosition(new Vec2(6, -13));
        f4.addCollisionListener(fp);

        Food f5 = new Food(this);
        f5.setPosition(new Vec2(9, -7));
        f5.addCollisionListener(fp);

        Food f6 = new Food(this);
        f6.setPosition(new Vec2(-19, -4));
        f6.addCollisionListener(fp);

        Armor a17 = new Armor(this);
        a17.setPosition(new Vec2(-12, 9.5f));
        a17.addCollisionListener(ap);

        Armor a18 = new Armor(this);
        a18.setPosition(new Vec2(-6, 9.5f));
        a18.addCollisionListener(ap);

        survivor.setPosition(new Vec2(-19,9));


        SpikeTrap st1 = new SpikeTrap(this);
        st1.setPosition(new Vec2(-9, 9.5f));

        SpikeTrap st2 = new SpikeTrap(this);
        st2.setPosition(new Vec2(18, 4));

        SpikeTrap st4 = new SpikeTrap(this);
        st4.setPosition(new Vec2(4, -4.6f));

        SpikeTrap st6 = new SpikeTrap(this);
        st6.setPosition(new Vec2(20, -13 ));

        Goblin goblin1 = new Goblin(this);
        goblin1.setPosition(new Vec2(4,11f));
        goblin1.addCollisionListener(en);
        goblin1.setValue();

        Goblin goblin2 = new Goblin(this);
        goblin2.setPosition(new Vec2(12,12));
        goblin2.addCollisionListener(en);
        goblin2.setValue();

        Goblin goblin3 = new Goblin(this);
        goblin3.setPosition(new Vec2(-12,5));
        goblin3.addCollisionListener(en);
        goblin3.setValue();



        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(12, 5));
        enemy1.addCollisionListener(en);
        enemy1.setValue();

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(-2, -4));
        enemy2.addCollisionListener(en);
        enemy2.setValue();

        portal = new Portal(this);
        portal.setPosition(new Vec2(-21, -12));


        try {
            leveltwo = new SoundClip("data/leveltwomusic.wav");
            leveltwo.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }



    }

    /**
     * This is for Player to collect 3 foods minimum to advance to next level
     * @return This is making sure Player collects more than 3 foods.
     */
    @Override
    public boolean isComplete() {
        return getSurvivor().getFoods() > 3;
    }
}
