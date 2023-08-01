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

    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // pour gerer l'horloge interne dans le jeu

    //Set player's defaulft position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // ameliore le rendu
        this.addKeyListener(keyH);
        this.setFocusable(true);   
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
    * @throws This method create a while loop to display the image on a 60 fps
    */
    /* 
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null)
        {
            //1-Update:  update information such as character positions
            update();
           //2 Draw: draw the screen with the updated information
            repaint();

            

            try {
                double remainingTime = nextDrawTime - System.nanoTime() ;
                remainingTime = remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;


        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                //1-Update:  update information such as character positions
                update();
                //2 Draw: draw the screen with the updated information
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if(keyH.downPressed == true){
            playerY += playerSpeed;
        }
        else if(keyH.leftPressed == true){
            playerX -= playerSpeed;
        }
        else if(keyH.rightPressed == true){
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//Selectionner un enfant du parent(Gpanel)
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(playerX,playerY,tilesize,tilesize); // DEssiner un rectangle avec comme param, son xcoordonate, ycoordonate, largeur, hauteur
        g2.dispose();
    }

}
