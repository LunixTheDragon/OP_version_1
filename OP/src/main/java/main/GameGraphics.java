package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameGraphics extends JFrame {
    public Draw draw;
    GameLogic logic;
    private int playerAction = 0;
    public GameGraphics(GameLogic logic){
        this.draw = new Draw();
        logic = new GameLogic();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3); //Exit on close
        setResizable(false);
        pack();
        setVisible(true);
        setTitle("GameWithoutName");
        setSize(600, 750);
    }
    public void render(GameLogic logic) {
        this.logic = logic;
        repaint();
    }

    public static class Draw extends JPanel{
        Player player;
        private int playerAction = 0;
        private boolean moving = false;
        private int aniSpeed = 25;
        private int aniTick;
        private int aniIndex;
        GameLogic logic;
        public BufferedImage[][] animations;
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if (animations != null && animations.length > 0){
                BufferedImage currentFrame = animations[playerAction][aniIndex];
                g.drawImage(currentFrame, (int)player.getX(), (int)player.getY(), null);
            }
        }

        public void loadAni(){
            BufferedImage img = LoadSave.GetSpriteAtlas("player_sprites.png");
            animations = new BufferedImage[9][6];

            for(int j = 0; j < animations.length; ++j) {
                for(int i = 0; i < animations[j].length; ++i) {
                    animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
                }
            }
        }

        public void updateAniTick(){

        }

        public void setAni(){
            int startAni = this.playerAction;
            if (this.moving) {
                this.playerAction = 1;
            } else {
                this.playerAction = 0;
            }
            if (startAni != this.playerAction) {
                this.resetAniTick();
            }


        }


        public void resetAniTick(){
            aniTick = 0;
            aniIndex = 0;
        }

        public void updatePos(){

        }

        public void importImg(){

        }


    }
}
