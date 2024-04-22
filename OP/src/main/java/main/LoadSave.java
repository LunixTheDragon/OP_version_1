package main;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class LoadSave {
    public static final String PLAYER_ATLAS ="player_sheet_1.png";


    public static BufferedImage GetSpriteAtlas( String fileName){
        BufferedImage img = null;
        InputStream is =LoadSave.class.getResourceAsStream("/" + fileName);
    }
}
