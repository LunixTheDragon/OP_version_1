package entity;

import main.Directions;
import main.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static main.LoadSave.GetSpriteAtlas;
import static main.LoadSave.PLAYER_ATLAS;

public class Player extends Entity {
    private int speed = 5;
    public BufferedImage[][] animations;
    private Directions dir;

    public Player(float x, float y, int width, int height, int lives) {
        super(x, y, width, height, GetSpriteAtlas("player_sprites.png")[0][0]);
        this.animations = GetSpriteAtlas("player_sprites.png");
        this.dir = Directions.LEFT;
    }
    public void loadAni(){
        BufferedImage[][] img = LoadSave.GetSpriteAtlas("player_sprites.png");
        int spriteWidth = 32; // Width of each sprite
        int spriteHeight = 32; // Height of each sprite

        // Example: Extract a sub-image for the first animation frame
        animations = new BufferedImage[1][5];
        for (int i = 0; i < animations[0].length; i++) {
            animations[0][i] = img[0][i].getSubimage(i * spriteWidth, 0, spriteWidth, spriteHeight);
        }
    }

    public void update() {
    }
    public void render(Graphics g) {
    }

    public void ateProduct(Products products) {
    }
}
