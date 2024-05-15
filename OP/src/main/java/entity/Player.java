package entity;

import main.Directions;
import main.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import static main.LoadSave.GetSpriteAtlas;
import static main.LoadSave.PLAYER_ATLAS;

public class Player extends Entity {
    public BufferedImage[][] animations;
    private Directions dir;
    private int playerWidth;
    private int playerHeight;
    public Player(float x, float y, int width, int height, int lives) {
        super(x, y, width, height, GetSpriteAtlas("player_sprites.png")[0][0]);
        this.animations = GetSpriteAtlas("player_sprites.png");
        this.dir = Directions.LEFT;
        this.width = 64;
        this.playerHeight = 40;
    }
    public void loadAni(){
        BufferedImage[][] img = LoadSave.GetSpriteAtlas("player_sprites.png");

        int spriteWidth = 64; // Width of each sprite
        int spriteHeight = 40; // Height of each sprite

        // Example: Extract a sub-image for the first animation frame
        //animations = new BufferedImage[9][6];
        //for (int i = 0; i < animations.length; i++) {
        //    for (int j = 0; j < animations[i].length; j++) {
        //        animations[i][j] = img[i][j].getSubimage(j * spriteWidth, i * spriteHeight, spriteWidth, spriteHeight); //samotny i nefunguje
        //    }
        //}
        /* TODO: I have no idea what this is and it should be something like this:
            for (int j = 0; j < animations.length; j++)
                for (int i = 0; i < animations[j].length; i++)
                    animations[j][i] = img.getSubimage(i * {playerWidth}, j * {playerHeight}, {playerWidth}, {playerHeight})
                                                            ^^^ 64 ^^^          ^^^ 40 ^^^     ^^^ 64 ^^^      ^^^ 40 ^^^
            this will ensure to load all animations
            ___________________
            Note: you have to handle each animation because they have different sizes
         */
    }

    public void update() {
    }
    public void render(Graphics g) {
    }

    public void ateProduct(Products products) {
    }
}
