package entity;

import java.util.Random;
public class Products extends Entity {
    private int damageIfBad = 1;
    private boolean productDescription = true;

    public Products(float x, float y, int width, int height, boolean productDescription, int damageIfBad) {
        super(x, y, width, height, null);
        this.damageIfBad = damageIfBad;
    }
    public void update(){
    }
}
