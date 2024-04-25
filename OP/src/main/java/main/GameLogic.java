package main;

import entity.Player;
import entity.Products;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameLogic {
    Player player;
    ArrayList<Products> products;
    private int xDelta;
    Directions direct;
    public int score = 0;
    private final int playerSpeed =20;
    private final int fallingSpeed = 15;
    private void  setPaneSize(){
        this.player = null;
        this.products = new ArrayList<>();
    }

    public void initialize(){

        player = new Player(500, 300, 56, 65, 3);




    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }
}