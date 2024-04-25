package main;

import entity.Products;

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

    }

