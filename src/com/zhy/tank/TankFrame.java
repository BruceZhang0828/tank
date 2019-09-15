package com.zhy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {

    //使用model 作为门面
    GameModel gameModel = new GameModel();

    static int GAME_WIDTH = 0,GAME_HEIGHT = 0 ;
    static {
        GAME_WIDTH =   PropertiesMgr.getConfigInt("gameWidth");
        GAME_HEIGHT =  PropertiesMgr.getConfigInt("gameHeight");
    }



   // Bullet b = new Bullet(200, 200, Dir.DOWN);

    //private boolean isExplode  = false;

    //创建一个爆照效果
    //Explode e = null;

   /* public boolean isExplode() {
        return isExplode;
    }*/

    /*public void setExplode(boolean explode) {
        isExplode = explode;
    }*/

    public TankFrame() throws HeadlessException {

        this.setVisible(true);
        this.setResizable(false);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setTitle("Tank War");

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyListener());

    }


    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }



    @Override
    public void paint(Graphics g) {
        gameModel.paint(g);
    }

    class KeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;


        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_LEFT:
                    bL =true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_LEFT:
                    bL =false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModel.getMyTank().fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 设置坦克朝向和移动状态
         */
        private void setMainTankDir() {
            Tank myTank = gameModel.getMyTank();
            if (!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }

}
