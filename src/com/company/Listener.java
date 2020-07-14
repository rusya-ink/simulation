package com.company;

import javax.swing.*;

public class Listener {
    private static Listener ourInstance = new Listener();

    public static Listener getInstance() {
        return ourInstance;
    }

    private Listener() {
    }
    public static void listen() {
        Cons.speed = speedCut.getValue();
    }
    public static void create(JSlider speedCut_) {
        speedCut=speedCut_;
    }
    public static JSlider speedCut;
}
