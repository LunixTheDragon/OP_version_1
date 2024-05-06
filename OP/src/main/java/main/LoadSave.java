package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class LoadSave {
    public static final String PLAYER_ATLAS = "player_sprites.png";

    public LoadSave() {
    }

    public static BufferedImage[][] GetSpriteAtlas(String fileName) {
        BufferedImage[][] sprites = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);


        try {
            BufferedImage img;
            if (is != null) {
                img = ImageIO.read(is);
                int rows = 1; // Number of rows in your sprite sheet
                int cols = 5; // Number of columns in your sprite sheet
                int spriteWidth = img.getWidth() / cols;
                int spriteHeight = img.getHeight() / rows;
                sprites = new BufferedImage[rows][cols];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        sprites[i][j] = img.getSubimage(j * spriteWidth, i * spriteHeight, spriteWidth, spriteHeight);
                    }
            }
            }else{
                System.err.println("Unable to load sprite atlas: " + fileName);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (is != null){
                    is.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return sprites;

    }
}
