package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // SCREEN setting

    final int originalTileSize = 16; // 16*16 tile
    final int scale = 3;

    final int tilesize = originalTileSize * scale; // 48*48 tile
    final int maxScreencol = 16;
    final int maxScreenrow = 12;
    final int ScreenWidth = tilesize * maxScreencol; // 768 px
    final int ScreenHeight = tilesize * maxScreenrow;// 576 px

    Thread gameThread; // pour gerer l'horloge interne dans le jeu

    public GamePanel() {

        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // ameliore le rendu
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }

}
