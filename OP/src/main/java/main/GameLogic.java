package main;

import entity.Backround;
import entity.Player;
import entity.PlayerValues;
import entity.Products;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameLogic {
    Player player;
    ArrayList<Products> products;
    Backround backround;
    GameGraphics gg;
    private int playerDir = -1; //IDLE
    private boolean movingAni = false, goodProductAni = false;


    public void initialize(){
        player = new Player(230, 375, 64, 40, 3); //where is spawn player
        products = new ArrayList<>();
        backround = new Backround(0, 0, 600, 750);
    }
    public void setGameGraphics(GameGraphics gg){
        this.gg = gg;
    }
    public void updatePlayerAction(PlayerValues action){
        player.setAction(action);
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        movingAni = true;
    }
    public void setGoodProductAni(boolean goodProductAni){
        this.goodProductAni = goodProductAni;
    }
    public void stopMoving(){
        setMovingAni(false);
    }
    public void setMovingAni(boolean movingAni){
        this.movingAni = movingAni;
    }
    private void setAni(){
        if (movingAni){
            updatePlayerAction(PlayerValues.RUNNING);
        }else{
            updatePlayerAction(PlayerValues.IDLE);
        }
    }
<<<<<<< HEAD
=======
    private boolean descriptionOfProduct(){
        Random rnd = new Random();
        return rnd.nextBoolean();
    }
    public void spawnInitialProducts(){
        for (int i = 0; i < 5; i++){
            spawnProduct();
        }
    }
    public void stopMoving(){
        setMoving(false);
    }
>>>>>>> origin/main
    private void updatePos() {
        if (this.movingAni) {
            switch (this.playerDir) {
                case KeyEvent.VK_A ,KeyEvent.VK_LEFT:
                    gg.draw.xDelta -= 3; //Players speed
                    break;
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                    gg.draw.xDelta += 3;
                    break;
            }
        }
    }
    public void update(){
        setAni();
        updatePos();
        updateProducts();
    }
    private void updateProducts(){
        for (Products product: products){
            product.setY(product.getY() + 2); //falling speed
            if (product.getY() > gg.getHeight()){
                product.setY(0); //reset to top if it falls off the screen
                product.setX(new Random().nextInt(gg.getWidth() - product.getWidth())); // new random x position
            }
        }
    }
    private void spawnProduct(){
        Random rnd = new Random();
        float x = rnd.nextInt(gg.getWidth() - 256);//width of product dont forget to change it in GameGraphics
        float y = 0;
        boolean isGood = descriptionOfProduct();
        products.add(new Products(x, y ,256, 160, isGood, isGood ? 0 :1));
    }
    /*TODO tohle bude trida na kolize moving atd atd
    */

}