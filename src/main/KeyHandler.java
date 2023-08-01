package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener { 

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //Ne sera pas utilisé dans ce code
        // src "https://stackoverflow.com/questions/7071757/keylistener-keypressed-versus-keytyped"
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // returns the integer keycode related to te key in this event
        /*
         * 8 -- Backspace
         * 10 -- enter
         * 16 -- shift
         * 18- alt
         * 9 -- Tab
         * 12- Clear
         * 17 -- ctrl
         * 65 -- A
         * 66 -- B
         * 67 -- C
         * 68 -- ET ainsi de suite... 
         * 
         */
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }


    }
    @Override
    public void keyReleased(KeyEvent e) {
       int code = e.getKeyCode(); // returns the integer keycode related to te key in this event

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
    
}
