package main;

import entity.Player;
import entity.PlayerValues;

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
        logic.setGameGraphics(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Exit on close
        setResizable(false);
        add(draw);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("PribiňáčekGame");
    }

    public static class Draw extends JPanel{
        private final GameLogic logic;
        private BufferedImage[][] animations;
        private int aniTick, aniIndex, aniSpeed = 20; //120fpsa /4frames in second == 30
        public int xDelta = 100, yDelta = 100;
        private BufferedImage img;
        private int spriteAm = getSpriteAmount(PlayerValues.IDLE);

        public Draw (GameLogic logic){
            this.logic = logic;
            xDelta = (int) logic.player.getX();
            yDelta = (int) logic.player.getY();//for the initial spawn point
            importImg();
            loadAni();
            setPanelSize();
        }

        public static int getSpriteAmount(PlayerValues values){
            /*
            TODO zmenit vsechny integery na pocet kolik je obrazku na jednom radku
             */
            switch (values){
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case HIT:
                    return 4;
                case JUMP:
                case ATTACK_1:
                case ATTACK_JUMP_1:
                case ATTACK_JUMP_2:
                    return 3;
                case GROUND:
                    return 2;
                case FALLING:
                default:
                    return 1; //just workin for sure
            }
        }
        private void loadAni(){
            animations = new BufferedImage[9][6];       //length of animations arrays
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
                }
            }
        }
        private void importImg() {
            InputStream is = getClass().getResourceAsStream("/player_sprites.phootoshop.done.png");
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
                if (aniIndex >= spriteAm){   //resets animation index
                    aniIndex = 0;
                }
            }
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            updateAnimationTick();
            PlayerValues currentAction = logic.player.getAction();
            spriteAm = getSpriteAmount(currentAction);
            g.drawImage(animations[currentAction.ordinal()][aniIndex], xDelta, yDelta, 128, 80, null);// players size || The ordinal() method in Java is used to get the ordinal value (the position) of an enum constant. Each enum constant has an ordinal value that represents its position in the enum declaration, starting from zero.
        }
    }
}
