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

        player = new Player(400, 300, 56, 65, 3);
        player.loadAni();

    }

    public boolean predictCollision(Directions direction) {
        Rectangle moveRectangle = new Rectangle();
        switch (direction) {
            case RIGHT -> {
                moveRectangle = new Rectangle((int)player.getX() + playerSpeed,(int) player.getY(), player.getWidth(), player.getHeight());
            }
            case LEFT -> {
                moveRectangle = new Rectangle((int)player.getX() - playerSpeed, (int)player.getY(), player.getWidth(), player.getHeight());
            }
        } return false;
    }
    
    public void update(){
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