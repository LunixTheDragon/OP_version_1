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

    public void initialize(){
        player = new Player(100, 100, 64, 40, 3);
    }

    public void updatePlayerAction(PlayerValues action){
        player.setAction(action);
    }
    /*TODO tohle bude trida na kolize atd atd
    */

}