package gameobject;

import view.GameWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by hoanhan on 7/13/16.
 */
public class Player {
    public static final int TYPE_PLAYER_1 = 1;
    public static final int TYPE_PLAYER_2 = 2;

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posX) {
        this.posY = posX;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public static final String PLAYER_GIRL = "Resource/Char/1Girl.png";
    public static final String PLAYER_OLDMAN = "Resource/Char/2OldMan.png";

    private BufferedImage sprite;
    private int posY;
    public ArrayList<Elephant> listElephant = new ArrayList<Elephant>();
    Random random = new Random();

    public Player(int posY, int type){
        this.posY = posY;
        loadSpriteByType(type);
    }

    private void loadSpriteByType(int type) {
        switch (type) {
            case TYPE_PLAYER_1:
                try {
                    sprite = ImageIO.read(new File(PLAYER_GIRL));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case TYPE_PLAYER_2 :
                try {
                    sprite = ImageIO.read(new File(PLAYER_GIRL));
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public void call(){
//        if(number_player == 1){
//            int n = random.nextInt(6);
//            int m = n + 1;
//            if(m%2 == 0) {
//                m -= 1;
//                listElephant.add(new Elephant(x,m));
//            }else listElephant.add(new Elephant(x,m));
//        }
//        if(number_player == 2){
//            int n = random.nextInt(6);
//            int m = n + 1;
//            if(m%2 != 0) {
//                m += 1;
//                listElephant.add(new Elephant(x,m));
//            }else listElephant.add(new Elephant(x,m));
//        }
        int x = random.nextInt(3);
        listElephant.add(new Elephant(0,x+1,5));
    }

    public void draw(Graphics g){
        g.drawImage(sprite,0, posY,null);
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while(cursorElephant.hasNext()){
            cursorElephant.next().draw(g);
        }
    }

    public void update (){
        Iterator<Elephant> cursorElephant = listElephant.iterator();
        while (cursorElephant.hasNext()){
            Elephant elephant = cursorElephant.next();
            elephant.moveByVector();
            int x = elephant.getPosX();
            if(x > 480)
                cursorElephant.remove();

        }
    }
}