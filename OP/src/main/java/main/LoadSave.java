package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class LoadSave {
    public static final String PLAYER_ATLAS = "player_sprites.png";

    public LoadSave() {
    }

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

        try {
            img = ImageIO.read(is);
        } catch (IOException var12) {
            var12.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException var11) {
                var11.printStackTrace();
            }

        }

        return img;
    }
}
