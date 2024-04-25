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
        double timePerFrame = 8333333.333333333;
        double timePerUpdate = 5000000.0;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();
        double deltaU = 0.0;
        double deltaF = 0.0;

        while(true) {
            long currentTime = System.nanoTime();
            deltaU += (double)(currentTime - previousTime) / timePerUpdate;
            deltaF += (double)(currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;
            if (deltaU >= 1.0) {
                this.update();
                ++updates;
                --deltaU;
            }

            if (deltaF >= 1.0) {
                gg.repaint();
                ++frames;
                --deltaF;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000L) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
            long lastTime = System.nanoTime();
            final double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            while (true){
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1){
                    update();
                    delta--;
                }
                render();
            }
        }


    }
    public void update(){
        logic.update();
    }

    }

