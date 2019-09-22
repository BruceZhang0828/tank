package com.zhy.designPattern.observer.v9;

import java.util.ArrayList;
import	java.util.List;

public class Test {
    public static void main(String[] args) {
        Button b = new Button();
        b.addActionListener(new MyAction());
        b.addActionListener(new MyAction2());
        b.buttonPress();
    }

}

class Button{
    private List<ActionListener> actionListeners = new ArrayList<>();

    public void buttonPress(){
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        for (int i = 0; i < actionListeners.size(); i++) {
            ActionListener actionListener = actionListeners.get(i);
            actionListener.actionPerformed(event);
        }
    }

    public void addActionListener(ActionListener a){
        actionListeners.add(a);
    }
}


interface ActionListener{
    void actionPerformed(ActionEvent actionEvent);
}

class MyAction implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("button press");
    }
}

class MyAction2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("button press 2");
    }
}
class ActionEvent{
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }
}


