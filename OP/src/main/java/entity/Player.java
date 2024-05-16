package entity;

import main.Directions;


import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Player extends Entity {
    private Directions dir;
    private int lives;

    public Player(float x, float y, int width, int height, int lives) {
        super(x, y, width, height);
        this.lives = lives;
    }

}
