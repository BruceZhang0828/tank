package com.zhy.designPattern.observer.v9;

import java.awt.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame extends Frame {
    public void  launch(){
        Button b = new Button();
        b.addActionListener(new MyActionListern());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLocation(400,400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new TestFrame().launch();
    }
}


class MyActionListern implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        Button source = (Button)e.getSource();
        source.setLabel("press me again");
        System.out.println("press Button");
    }
}


class MyActionListener2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("press Button2");
    }
}
