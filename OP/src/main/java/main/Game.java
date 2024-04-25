package main;

import entity.Products;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements Runnable{
    GameLogic logic = new GameLogic();
    GameGraphics gg;

    private Thread gameThread;
    private final int FPS = 120;
    private boolean isGameOver = false;
    public Game(){
        logic = new GameLogic();
        gg = new GameGraphics(logic);
        logic.initialize();
        gg.draw.loadAni();


        gg.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT -> controlled
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });



    }
    public void startGame(){
        Thread gameThread = new Thread(this);
        gameThread.start();
    }
    public void render(){

    }
    @Override
    public void run() {
    }
    public void update(){
        logic.update();
    }

    private void controlledMove(Directions direction) {
        if (!logic.predictCollision(direction)){
            logic.movePlayer(direction);
        }
    }

    }

