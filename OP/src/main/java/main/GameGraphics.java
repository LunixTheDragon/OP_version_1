package main;

import entity.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GameGraphics extends JFrame {
    public Draw draw;
    public GameGraphics(GameLogic logic){
        this.draw = new Draw(logic);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Exit on close
        setResizable(false);
        add(draw);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("PribiňáčekGame");
    }

    public static class Draw extends JPanel{
        private final Player player;
        private final BufferedImage[] idleAni;
        private int aniTick, aniIndex, aniSpeed = 25; //120fpsa /4frames in second == 30
        private int xDelta = 100, yDelta = 100;

        public Draw (GameLogic logic){
            this.player = logic.player;
            BufferedImage img = importImg();
            idleAni = loadAni(img);
            setPanelSize();
        }

        private BufferedImage[] loadAni(BufferedImage img){
            BufferedImage[] frames = new BufferedImage[5];
            for (int i = 0; i < frames.length; i++ ){
                frames[i] = img.getSubimage(i * 64, 0, 64, 40);
            }
            return frames;
        }
        private BufferedImage importImg() {
            InputStream is = getClass().getResourceAsStream("/player_sprites.phootoshop.done.png");
            BufferedImage img = null;
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return img;
        }
        private void setPanelSize() {
            Dimension size = new Dimension(600, 750);
            setPreferredSize(size);   //for JPanel to fit in JFrame
        }

        private void updateAnimationTick() {

            aniTick ++;
            if (aniTick >= aniSpeed){
                aniTick = 0;
                aniIndex++;
                if (aniIndex >= idleAni.length){   //its goin 0 1 2 3 4 but when it gets to 5 it resets bcs we have [5]
                    aniIndex = 0;
                }
            }
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            updateAnimationTick();
            g.drawImage(idleAni[aniIndex], xDelta, yDelta, 128, 80, null);
        }


    }
}
