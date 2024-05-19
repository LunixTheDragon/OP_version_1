package entity;

import java.util.Random;
public class Products extends Entity {
    private int damageIfBad = 1;
    private boolean productDescription = true;
    private float speed = 2.0f; // Speed at which the product falls

    public Products(float x, float y, int width, int height, boolean productDescription, int damageIfBad) {
        super(x, y, width, height);
        this.productDescription = productDescription;
        this.damageIfBad = damageIfBad;
    }

    public int getDamageIfBad() {
        return damageIfBad;
    }

    public void setDamageIfBad(int damageIfBad) {
        this.damageIfBad = damageIfBad;
    }

    public boolean isProductDescription() {
        return productDescription;
    }

    public void setProductDescription(boolean productDescription) {
        this.productDescription = productDescription;
    }
}
