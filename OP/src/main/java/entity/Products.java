package entity;

import java.util.Random;

public class Products extends Entity{
    private int damageIfBad = 1;
    private boolean productDescription = true; //true == good, false == bad
    private int productsFallingSpeed;
    public Products(float x, float y, int width, int height, boolean productDescription) {
        super(x, y, width, height);
        this.productDescription = productDescription;
    }

    //public static void goodFruitBadFruit(boolean productDescription){


    //}

}
