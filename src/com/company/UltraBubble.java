package com.company;

public class UltraBubble extends Crab {

    public UltraBubble(int y, int x) {
        this.x = x;
        this.y = y;
        ticsUntil=10;
    }

    public void live() {
        int[][] toEat = new int[8][2];
        int k = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (y + i >= 0 && y + i < Cons.HEIGHT && x + j >= 0 && x + j < Cons.WIDTH &&
                        !(World.ar_block[y + i][x + j].entity instanceof Water) && (i != 0 || j != 0) &&
                        !(World.ar_block[y + i][x + j].entity instanceof Sunny)&&
                        !(World.ar_block[y + i][x + j].entity instanceof Bubble)) {
                    toEat[k][0] = y + i;
                    toEat[k][1] = x + j;
                    k++;
                }

            }
        }
        if(y==0 && k==0){
            ticsUntil--;
            if(ticsUntil<0) {
                if((int)(Math.random()*2)>0)
                    World.ar_block[y][x].setEntity(new Fish2(y, x));
                else
                    World.ar_block[y][x].setEntity(new Fish1(y, x));
            }
        }else {
            ticsUntil = 10;
            if (k == 0 && y > 0) {
                eat(y - 1, x);
            } else {
                int r = (int) (Math.random() * k);
                eat(toEat[r][0], toEat[r][1]);
            }
        }
    }
}


