package entity;

import main.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    private int lives = 3;
    private int speed = 5;
    private BufferedImage[][] animations;

    public Player(float x, float y, int width, int height, int lives) {
        super(x, y, width, height);
        this.loadAni();
        this.lives = lives;
    }

    public void update() {
    }

    public void loadAni() {
        BufferedImage img = LoadSave.GetSpriteAtlas("player_sprites.png");
        this.animations = new BufferedImage[9][6];

        for(int j = 0; j < this.animations.length; ++j) {
            for(int i = 0; i < this.animations[j].length; ++i) {
                this.animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }

    }

    public void render(Graphics g) {
    }

    public void ateProduct(Products products) {
    }
}
