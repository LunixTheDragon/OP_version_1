package entity;

import java.awt.image.BufferedImage;

public class Entity {
    protected BufferedImage [][] animations;
    protected int aniTick;
    protected int aniSpeed;
    protected int aniIndex;
    protected float x, y ;
    protected int height,width;
    protected float hitBox;
    protected float gravity;
    protected boolean isCollided;
    protected boolean productsResult;
    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


    }
}
