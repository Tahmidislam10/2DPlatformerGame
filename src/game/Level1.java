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
 * This is level 1 class
 */
public class Level1 extends GameLevel{
    public  SoundClip levelone;


    /**
     * this is Constuctor for level 1 which will hold all the different Item which are needed for level 1.
     * @param game This is adding level 1 to game.
     */
    public Level1(Game game){
        super(game);
        // these are platforms which the charactor will jump on to get collectables

        EnemyCollison en = new EnemyCollison(survivor);
        ArmorPickup ap = new ArmorPickup(survivor);

        //this is the first platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(19, -12.5f));
        platform1.addImage(new BodyImage("data/platform.png",2));


        // this second platform

        Shape platformShape2 = new BoxShape(8,0.5f);
        StaticBody platform2 = new StaticBody(this, platformShape2);
        platform2.setPosition(new Vec2(4, -8.5f));
        platform2.addImage(new BodyImage("data/platform.png",5.5f));

        // this is third platform

        Shape platformShape3 = new BoxShape(1.5f,0.5f);
        StaticBody platform3 = new StaticBody(this, platformShape3);
        platform3.setPosition(new Vec2(-7.5f, -6.5f));
        platform3.addImage(new BodyImage("data/platform.png",1.5f));



        // this is fourth platform

        Shape platformShape4 = new BoxShape(1.5f,0.5f);
        StaticBody platform4 = new StaticBody(this, platformShape4);
        platform4.setPosition(new Vec2(-10, -4.5f));
        platform4.addImage(new BodyImage("data/platform.png",1.5f));

        // this is fifth platform

        Shape platformShape5 = new BoxShape(1.5f,0.5f);
        StaticBody platform5 = new StaticBody(this, platformShape5);
        platform5.setPosition(new Vec2(-12, -2.5f));
        platform5.addImage(new BodyImage("data/platform.png",1.5f));

        // this is sixth platform

        Shape platformShape6 = new BoxShape(3,0.5f);
        StaticBody platform6 = new StaticBody(this, platformShape6);
        platform6.setPosition(new Vec2(-18, -1));
        platform6.addImage(new BodyImage("data/platform.png",2));

        // this is seventh platform
        Shape platformShape16 = new BoxShape(2,0.5f);
        StaticBody platform16 = new StaticBody(this, platformShape16);
        platform16.setPosition(new Vec2(-22, 2));
        platform16.addImage(new BodyImage("data/platform.png",1.5f));

        // this is eight platform
        Shape platformShape10 = new BoxShape(2,0.5f);
        StaticBody platform10 = new StaticBody(this, platformShape10);
        platform10.setPosition(new Vec2(-14, 4.5f));
        platform10.addImage(new BodyImage("data/platform.png",2));


        // this is nineth platform.
        Shape platformShape7 = new BoxShape(5,0.5f);
        StaticBody platform7 = new StaticBody(this, platformShape7);
        platform7.setPosition(new Vec2(-6, 4.5f));
        platform7.addImage(new BodyImage("data/platform.png",3.5f));


        // this is the tenth platform

        Shape platformShape9 = new BoxShape(2,0.5f);
        StaticBody platform9 = new StaticBody(this, platformShape9);
        platform9.setPosition(new Vec2(2, 4.5f));
        platform9.addImage(new BodyImage("data/platform.png",2));

        // this is the 11th platform

        Shape platformShape11 = new BoxShape(2,0.5f);
        StaticBody platform11 = new StaticBody(this, platformShape11);
        platform11.setPosition(new Vec2(6, 6.5f));
        platform11.addImage(new BodyImage("data/platform.png",2));

        // this is the 12th platform.
        Shape platformShape12 = new BoxShape(2,0.5f);
        StaticBody platform12 = new StaticBody(this, platformShape12);
        platform12.setPosition(new Vec2(11, 8.5f));
        platform12.addImage(new BodyImage("data/platform.png",2));

        // this is the 13th platform.

        Shape platformShape13 = new BoxShape(4,0.5f);
        StaticBody platform13 = new StaticBody(this, platformShape13);
        platform13.setPosition(new Vec2(17, 10.5f));
        platform13.addImage(new BodyImage("data/platform.png",2.5f));

        //this is the 1st food collectable.



        FoodPickup fp = new FoodPickup(survivor); // this allows me to in



        //this is the 3rd food collectable.

        Food f3 = new Food(this);
        f3.setPosition(new Vec2(-5, -14));
        f3.addCollisionListener(fp);

        //this is the 4th food collectable.

        Food f4 = new Food(this);
        f4.setPosition(new Vec2(0, -14));
        f4.addCollisionListener(fp);

        //this is the 5th food collectable.

        Food f5 = new Food(this);
        f5.setPosition(new Vec2(5, -14));
        f5.addCollisionListener(fp);

        //this is the 6th food collectable.

        Food f6 = new Food(this);
        f6.setPosition(new Vec2(10, -14));
        f6.addCollisionListener(fp);

        //this is the 7th food collectable.


        Food f7 = new Food(this);
        f7.setPosition(new Vec2(15, -14));
        f7.addCollisionListener(fp);

        //this is the 8th food collectable.

        Food f11 = new Food(this);
        f11.setPosition(new Vec2(-6.5f, -5));
        f11.addCollisionListener(fp);

        //this is the 9th food collectable.

        Food f12 = new Food(this);
        f12.setPosition(new Vec2(-9, -3));
        f12.addCollisionListener(fp);

        //this is the 10th food collectable.

        Food f13 = new Food(this);
        f13.setPosition(new Vec2(-11, -1));
        f13.addCollisionListener(fp);

        //this is the 11th food collectable.

        Food f14 = new Food(this);
        f14.setPosition(new Vec2(-21, 4));
        f14.addCollisionListener(fp);

        //this is the 12th food collectable.

        Food f15 = new Food(this);
        f15.setPosition(new Vec2(10, 9));
        f15.addCollisionListener(fp);

        //this is the 13th food collectable.

        Food f16 = new Food(this);
        f16.setPosition(new Vec2(6.5f, 8));
        f16.addCollisionListener(fp);

        // this is the portal.
        portal = new Portal(this);
        portal.setPosition(new Vec2(21, 13));
        //portal.setValue();

        // mobs and characters.

        survivor.setPosition(new Vec2(-21.5f,-12));

        Goblin goblin1 = new Goblin(this);
        goblin1.setPosition(new Vec2(-6,6));
        goblin1.addCollisionListener(en);
        goblin1.setValue();


        Enemy enemy1 = new Enemy(this);
        enemy1.setPosition(new Vec2(21, -10));
        enemy1.addCollisionListener(en);
        enemy1.setValue();

        Enemy enemy2 = new Enemy(this);
        enemy2.setPosition(new Vec2(19, 13));
        enemy2.addCollisionListener(en);
        enemy2.setValue();



        Armor a17 = new Armor(this);
        a17.setPosition(new Vec2(-10, -13));
        a17.addCollisionListener(ap);

        Armor a18 = new Armor(this);
        a18.setPosition(new Vec2(6, -6.5f));
        a18.addCollisionListener(ap);


        try{
            levelone = new SoundClip("data/levelonemusic.wav");
            levelone.loop();
            System.out.println("loading food sounds");
        } catch (UnsupportedAudioFileException | LayerInstantiationException | IOException |
                 LineUnavailableException e){
            System.out.println(e);
        }
    }


    /**
     * This is for Player to collect 3 foods minimum to advance to next level
     * @return This is making sure Player collects more then 3 foods.
     */
    @Override
    public boolean isComplete() {
        return getSurvivor().getFoods() > 3;
    }
}
