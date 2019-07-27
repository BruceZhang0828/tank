package com.zhy.tank;
import	java.awt.event.WindowAdapter;
import	java.awt.Frame;
import java.awt.event.WindowEvent;

public class TankWindow {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(800, 600);
        frame.setTitle("Tank War");

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}
