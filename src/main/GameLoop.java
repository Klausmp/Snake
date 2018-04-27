package main;

        /** @author Klausmp
         **/


import input.Keyboard;
import output.GameFrame;
import output.Renderer;
import world.World;
import world.WorldOne;

public class GameLoop {

    public static Renderer renderer = new Renderer();


    private static boolean gameRunning = true;

    private static double fpsTimer;
    private static double nsPerTick;
    private static double nsPerRenderTick;
    private static double then;
    private static double now;
    private static double unprocessed;
    private static double unprocessedRender;

    private static int fps = 0;
    private static int tps = 0;
    private static int currentTick = 0;

    private static final int TPS = 60;
    private static final int FPS = 144;

    void run() {
        gameLoop();
    }

    static void init() {
        Keyboard keyboard = new Keyboard();
        GameFrame frame = new GameFrame();
        World.getWorldList().add(new WorldOne(32, 32, 5));
    }

    private void gameLoop() {
        fps = 0;
        tps = 0;
        fpsTimer = System.currentTimeMillis();
        nsPerTick = 1D / TPS * 1000000000D;
        nsPerRenderTick = 1D / FPS * 1000000000D;
        then = System.nanoTime();
        while (true) {
            now = System.nanoTime();
            unprocessed += (now - then) / nsPerTick;
            unprocessedRender += (now - then) / nsPerRenderTick;
            then = now;

            while (unprocessed >= 1) {
                if (gameRunning) {
                    gameTick();
                    gameTicks();
                }
                guiTick();
                tps++;
                unprocessed--;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameRender();
            while (unprocessedRender >= 1) {
                gameRender();
                fps++;
                unprocessedRender--;
            }


            if (System.currentTimeMillis() - fpsTimer >= 1000) {
                System.out.println("FPS: " + fps);
                fps = 0;
                tps = 0;
                fpsTimer += 1000;
            }
        }
    }

    private void gameRender() {
        GameFrame.repaintScreen();
    }

    private void guiTick() {
    }

    private void gameTick() {
        for (World world: World.getWorldList()) {
            world.update();
        }
    }

    public void gameTicks(){
        currentTick++;
        if (currentTick >= TPS + 1){
            currentTick = 1;
        }
    }


    public static int getCurrentTick() {
        return currentTick;
    }

    public static void setCurrentTick(int currentTick) {
        GameLoop.currentTick = currentTick;
    }

    public static boolean isGameRunning() {
        return gameRunning;
    }

    public static void setGameRunning(boolean gameRunning) {
        GameLoop.gameRunning = gameRunning;
    }

    public static double getFpsTimer() {
        return fpsTimer;
    }

    public static void setFpsTimer(double fpsTimer) {
        GameLoop.fpsTimer = fpsTimer;
    }

    public static double getNsPerTick() {
        return nsPerTick;
    }

    public static void setNsPerTick(double nsPerTick) {
        GameLoop.nsPerTick = nsPerTick;
    }

    public static double getNsPerRenderTick() {
        return nsPerRenderTick;
    }

    public static void setNsPerRenderTick(double nsPerRenderTick) {
        GameLoop.nsPerRenderTick = nsPerRenderTick;
    }

    public static double getThen() {
        return then;
    }

    public static void setThen(double then) {
        GameLoop.then = then;
    }

    public static double getNow() {
        return now;
    }

    public static void setNow(double now) {
        GameLoop.now = now;
    }

    public static double getUnprocessed() {
        return unprocessed;
    }

    public static void setUnprocessed(double unprocessed) {
        GameLoop.unprocessed = unprocessed;
    }

    public static double getUnprocessedRender() {
        return unprocessedRender;
    }

    public static void setUnprocessedRender(double unprocessedRender) {
        GameLoop.unprocessedRender = unprocessedRender;
    }

    public static int getFps() {
        return fps;
    }

    public static void setFps(int fps) {
        GameLoop.fps = fps;
    }

    public static int getTps() {
        return tps;
    }

    public static void setTps(int tps) {
        GameLoop.tps = tps;
    }

    public static int getTPS() {
        return TPS;
    }

    public static int getFPS() {
        return FPS;
    }
}