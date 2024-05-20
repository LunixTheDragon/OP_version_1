package main;

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
    GameGraphics gg;
    private int playerDir = -1; //IDLE
    private boolean moving = false;


    public void initialize(){
        player = new Player(230, 375, 64, 40, 3); //where is spawn player
        products = new ArrayList<>();
    }
    public void setGameGraphics(GameGraphics gg){
        this.gg = gg;
    }
    public void updatePlayerAction(PlayerValues action){
        player.setAction(action);
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    private void setAni(){
        if (moving){
            updatePlayerAction(PlayerValues.RUNNING);
        }else{
            updatePlayerAction(PlayerValues.IDLE);
        }
    }
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
    private void updatePos() {
        if (this.moving) {
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