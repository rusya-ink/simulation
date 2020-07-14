package com.company;

import javax.swing.*;
import java.awt.*;

public class CutterPanel extends JPanel {

    public CutterPanel() {
        super(new GridLayout(Cons.speedBlockHeightDivider + 1, 0));
        World.creator();


    }

    public void paintComponent(Graphics g) {



        g.setColor(Cons.getColor(0x000000));
        g.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        int dJ, dMin, dMax;
        if ((int) (Math.random() * 2) > 0) {

            dJ = 1;
            dMin = 0;
            dMax = Cons.WIDTH;
        } else {

            dJ = -1;
            dMin = Cons.WIDTH - 1;
            dMax = -1;
        }
        for (int i = 0; i < Cons.HEIGHT; i++) {
            for (int j = dMin; j != dMax; j += dJ) {
                Cons.dealWithIt(g, i, j);
            }
        }

    }

    public void liveAll() {
        for (int i = 0; i < Cons.HEIGHT; i++) {
            for (int j = 0; j < Cons.WIDTH; j++) {
                World.ar_block[i][j].entity.used = false;
            }
        }
        int dJ, dMin, dMax;
        if((int)(Math.random()*2)>0){

            dJ=1;
            dMin=0;
            dMax=Cons.WIDTH;
        }else{

            dJ=-1;
            dMin=Cons.WIDTH-1;
            dMax=-1;
        }
        for (int i = 0; i < Cons.HEIGHT; i++) {
            for (int j = dMin; j !=dMax; j+=dJ) {
//            for(int j=0; j<Cons.WIDTH; j++){
//            for (int j = Cons.WIDTH-1; j >=0;j--) {
                if (!World.ar_block[i][j].entity.used) {
                    World.ar_block[i][j].entity.used = true;
                    World.ar_block[i][j].entity.live();
                }
            }
        }
    }
}
