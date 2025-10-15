package game;



import city.cs.engine.*;
import org.jbox2d.common.Vec2;

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
 * This is level 3 class
 */
public class Level3 extends GameLevel  {
    public SoundClip levelthree;


    /**
     * this is Constructor for level 3 which will hold all the different Item which are needed for level 1.
     * @param game This is adding level 3 to game.
     */
    public Level3(Game game){
        super(game);
        // these are platforms which the charactor will jump on to get collectables

        EnemyCollison en = new EnemyCollison(survivor);

        ArmorPickup ap = new ArmorPickup(survivor);
        survivor.addCollisionListener(ap);

        // this is first platform

        Shape platformShape1 = new BoxShape(2,0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape1);
        platform1.setPosition(new Vec2(-1.5f, -10.5f));
        platform1.addImage(new BodyImage("data/platform.png",2.2F));



        Shape platformShape2 = new BoxShape(5,0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(-15, -9));
        platform2.addImage(new BodyImage("data/platform.png",5));

        SpikeTrap st1 = new SpikeTrap(this);
        st1.setPosition(new Vec2(-15, -7F));

        Shape platformShape3 = new BoxShape(2,0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(2, -8));
        platform3.addImage(new BodyImage("data/platform.png",2));

        Shape platformShape4 = new BoxShape(2,0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(5, -6));
        platform4.addImage(new BodyImage("data/platform.png",2));

        Shape platformShape5 = new BoxShape(4,0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(13, -6));
        platform5.addImage(new BodyImage("data/platform.png",4));

        Shape platformShape6 = new BoxShape(1.2f,0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(20, -4.5f));
        platform6.addImage(new BodyImage("data/platform.png",1.2f));



        Shape platformShape7 = new BoxShape(1,0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(23, -1));
        platform7.addImage(new BodyImage("data/platform.png",0.9f));

        Shape platformShape8 = new BoxShape(4,0.5f);
        StaticBody platform8 = new StaticBody(this, platformShape8);
        platform8.setPosition(new Vec2(13, 2));
        platform8.addImage(new BodyImage("data/platform.png",3.6f));

        Shape platformShape9 = new BoxShape(3,0.5f);
        StaticBody platform9 = new StaticBody(this, platformShape9);
        platform9.setPosition(new Vec2(6, 5));
        platform9.addImage(new BodyImage("data/platform.png",2));

        Shape platformShape10 = new BoxShape(3,0.5f);
        StaticBody platform10 = new StaticBody(this, platformShape10);
        platform10.setPosition(new Vec2(3, 7));
        platform10.addImage(new BodyImage("data/platform.png",2));

        Shape platformShape11 = new BoxShape(1.9f,0.5f);
        StaticBody platform11 = new StaticBody(this, platformShape11);
        platform11.setPosition(new Vec2(-3, 9));
        platform11.addImage(new BodyImage("data/platform.png",1.9f));

        Shape platformShape12 = new BoxShape(4,0.5f);
        StaticBody platform12 = new StaticBody(this, platformShape12);
        platform12.setPosition(new Vec2(-11, 9));
        platform12.addImage(new BodyImage("data/platform.png",3.4f));


        Shape platformShape13 = new BoxShape(4,0.5f);
        StaticBody platform13 = new StaticBody(this, platformShape13);
        platform13.setPosition(new Vec2(-17, 9));
        platform13.addImage(new BodyImage("data/platform.png",3.4f));


        SpikeTrap st2 = new SpikeTrap(this);
        st2.setPosition(new Vec2(2, 8.2F));

        SpikeTrap st3 = new SpikeTrap(this);
        st3.setPosition(new Vec2(16, -13));

        Armor f16 = new Armor(this);
        f16.setPosition(new Vec2(3, -5));
        f16.addCollisionListener(ap);

        Armor f17 = new Armor(this);
        f17.setPosition(new Vec2(1, -7));
        f17.addCollisionListener(ap);

        FoodPickup fp = new FoodPickup(survivor);

        Food f1 = new Food(this);
        f1.setPosition(new Vec2(-16, -11));
        f1.addCollisionListener(fp);

        Food f2 = new Food(this);
        f2.setPosition(new Vec2(-21, -6));
        f2.addCollisionListener(fp);

        Food f3 = new Food(this);
        f3.setPosition(new Vec2(-10, -11));
        f3.addCollisionListener(fp);


        Food f4 = new Food(this);
        f4.setPosition(new Vec2(-6, -11));
        f4.addCollisionListener(fp);

        Food f5 = new Food(this);
        f5.setPosition(new Vec2(-4, 11));
        f5.addCollisionListener(fp);

        Food f6 = new Food(this);
        f6.setPosition(new Vec2(-1, 11));
        f6.addCollisionListener(fp);




        Trollboss trollboss1 = new Trollboss(this);
        trollboss1.setPosition(new Vec2(15,-4));
        //trollboss1.setValue

        Trollboss trollboss2 = new Trollboss(this);
        trollboss2.setPosition(new Vec2(-16,11));
        //trollboss1.setValue





        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(15, 6));
        enemy2.addCollisionListener(en);
        enemy2.setValue();

        // this is the portal.
        portal = new Portal(this);
        portal.setPosition(new Vec2(-21, 11));
        //portal.setValue();


        // mobs and characters.

        survivor.setPosition(new Vec2(-21.5f,-12));


        try {
            levelthree = new SoundClip("data/levelthreemusic.wav");
            levelthree.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }















    }

    /**
     * Player need to collect more then 3 food to finish game.
     * @return This is making sure Player collects more than 3 foods.
     */
    @Override
    public boolean isComplete() {
        return getSurvivor().getFoods() > 3;
    }

}


