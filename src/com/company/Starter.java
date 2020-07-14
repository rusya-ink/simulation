package com.company;

import javax.swing.*;

public class Starter implements Runnable {
    public void run() {}
    public Starter(JSlider speedCut){
        Listener.create(speedCut);
    }

}
