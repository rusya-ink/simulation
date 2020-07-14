package com.company;

import javafx.geometry.Orientation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Drawer {

    public static JFrame cutter;
    public static JSlider speedCut;
    public static CutterPanel cutPanel;
    public static void makeSlidersBeautiful(){
        speedCut.setBorder(BorderFactory.createTitledBorder("Speed:"));
        speedCut.setMajorTickSpacing(50);
        speedCut.setPaintTicks(true);
        speedCut.setPaintLabels(true);
        speedCut.setVisible(true);

//        speedCut.setAlignmentX(Toolkit.getDefaultToolkit().getScreenSize().width-Cons.optWidth);
//        speedCut.setAlignmentY(0);
//
//        speedCut.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width-Cons.optWidth, 0, Cons.optWidth, Cons.optWidth/2);


//        cutPanel.add(speedCut);

    }
    public static boolean done;
    public static void main (String[] args){
        done = false;
        cutter = new JFrame("Ocean cutter");
        cutter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cutter.setLocationRelativeTo(null);
        cutter.setResizable(true);
        cutter.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cutter.setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        cutter.setSize(screenSize.width, screenSize.height-Cons.optHeight);
        Cons.createAll(cutter.getWidth(), cutter.getHeight());

        cutPanel = new CutterPanel();
        speedCut = new JSlider(0, 1000, 20);
        makeSlidersBeautiful();
        cutPanel.add(speedCut);
        cutter.add(cutPanel);
        cutter.setVisible(true);


//        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
//        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
//                cursorImg, new Point(0, 0), "blank cursor");
//        cutter.getContentPane().setCursor(blankCursor);
        cutter.setBackground(Cons.getColor(0x000000));

        if(!done){
            Listener.create((JSlider) cutPanel.getComponent(0));
            done=true;
        }
        while(true){

            cutPanel.liveAll();
            cutPanel.repaint();
            Cons.timeGoing();
        }

    }

}
