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
    private boolean moving = false;

    public void initialize(){
        player = new Player(100, 100, 64, 40, 3); //where is spawn player
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
    private void updatePos() {
        if (this.moving) {
            switch (this.playerDir) {
                case KeyEvent.VK_A:
                    gg.draw.xDelta -= 5;
                    break;
                case KeyEvent.VK_D:
                    gg.draw.xDelta += 5;
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