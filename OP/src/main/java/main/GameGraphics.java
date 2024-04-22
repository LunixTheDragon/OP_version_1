package main;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame {
    Draw draw;
    GameLogic logic;
    public GameGraphics(GameLogic logic){
        this.draw = new Draw();
        this.logic = new GameLogic();
        setDefaultCloseOperation(3); //Exit on close
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
        setTitle("GameWithoutName");
    }

    public static class Draw extends JPanel{



        protected void paintComponent(Graphics g){

        }

        public void loadAni(){

        }

        public void updateAniTick(){

        }

        public void setAni(){

        }

        public void updatePos(){

        }

        public void importImg(){

        }


    }
}
