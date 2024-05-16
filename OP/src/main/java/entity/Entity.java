package entity;

public class Entity {
    protected float x;
    protected float y;
    protected int height;
    protected int width;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
