package main;

import entity.Player;
import entity.PlayerValues;
import entity.Products;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class GameLogic {
    Player player;
    ArrayList<Products> products;
    private int playerDir = -1; //IDLE
    private boolean moving = false;

    public void initialize(){
        player = new Player(100, 100, 64, 40, 3); //where is spawn player
    }
    public static int getDirectionAmount(Directions dir){
        switch (dir) {
            case LEFT:
                return 0;
            case RIGHT:
                return 2;
            default:
                return -1;
        }
    }
    public void updatePlayerAction(PlayerValues action){
        player.setAction(action);
    }
    public void setDIrection(int direction){
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
    /*TODO tohle bude trida na kolize moving atd atd
    */

}