package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameGraphics extends JFrame {
    public Draw draw;
    GameLogic logic;
    public GameGraphics(GameLogic logic){
        this.draw = new Draw();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Exit on close
        setResizable(false);
        pack();
        setVisible(true);
        setTitle("GameWithoutName");
        setSize(600, 750);
    }
    public void render(GameLogic logic) {
        this.logic = logic;
        this.draw.setAni(logic.getPlayer().animations);
        repaint();
    }

    public static class Draw extends JPanel{
        Player player;
        private int playerAction = 0;
        private boolean moving = false;
        private int aniSpeed = 25;
        private int aniTick;
        private int aniIndex;
        private BufferedImage[][] animations;
        GameLogic logic;
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if (player != null && player.animations != null && player.animations.length > 0 ){
                BufferedImage currentFrame = player.animations[0][0];
                g.drawImage(currentFrame, (int)player.getX(), (int)player.getY(), null);
            }
        }
        public void updateAniTick(){

        }
        public void setAni(BufferedImage[][] animations) {
            this.animations = this.animations;
        }
        public void resetAniTick(){
            aniTick = 0;
            aniIndex = 0;
        }
    }
}
