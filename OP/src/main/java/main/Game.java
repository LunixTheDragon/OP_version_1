package main;

public class Game implements Runnable{
    GameLogic logic = new GameLogic();

    private Thread gameThread;
    private final int FPS = 120;
    private boolean isGameOver = false;
    public Game(){
        final GameGraphics graphic = new GameGraphics(this.logic);

    }
    public void startGameLoop(){

    }


    @Override
    public void run() {

    }

}

