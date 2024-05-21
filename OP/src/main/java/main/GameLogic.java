package main;

import entity.Player;
import entity.PlayerValues;
import entity.Products;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
public class GameLogic {
    Player player;
    ArrayList<Products> products;
    GameGraphics gg;
    private int playerDir = -1; //IDLE
    private boolean movingAni = false, goodProductAni = false;

    public void initialize(){
        player = new Player(230, 270, 64, 40, 3); //where is spawn player
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
    }
    /*TODO tohle bude trida na kolize moving atd atd
    */

}