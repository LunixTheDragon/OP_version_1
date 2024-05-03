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
            if (is != null){
                BufferedImage img = ImageIO.read(is);
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
