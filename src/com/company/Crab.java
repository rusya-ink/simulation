package com.company;

public class Crab extends Sand {
    public Crab(int y, int x) {
        this.x = x;
        this.y = y;
        ticsUntil=4;

    }
    public Crab(){}
    public void live() {
        int [][] toEat = new int [8][2];
        int [][] toGo = new int [8][2];
        int k=0, g=0;
        if((int)(Math.random()*3)==0) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (y + i >= 0 && y + i < Cons.HEIGHT && x + j >= 0 && x + j < Cons.WIDTH && (i != 0 || j != 0) &&
                            !(World.ar_block[y + i][x + j].entity instanceof Sunny) && !(World.ar_block[y + i][x + j].entity instanceof UltraBubble)) {
                        if (!(World.ar_block[y + i][x + j].entity instanceof Water)) {
                            toEat[k][0] = y + i;
                            toEat[k][1] = x + j;
                            k++;
                        } else {
                            toGo[g][0] = y + i;
                            toGo[g][1] = x + j;
                            g++;
                        }
                    }

                }
            }


            if (k == 0) {
                ticsUntil--;
                if(g>0) {
                    int r = (int) (Math.random() * g);
                    eat(toGo[r][0], toGo[r][1]);
                }
                if (ticsUntil < 0)
                    World.ar_block[y][x].setEntity(new Sand(y, x));
            } else {
                ticsUntil=4;
                int r = (int) (Math.random() * k);
                eat(toEat[r][0], toEat[r][1]);
            }
        }
    }
    public void eat(int y, int x){
        if(World.ar_block[y][x].entity instanceof Bubble){
            World.ar_block[y][x].setEntity(new UltraBubble(y, x));
            World.ar_block[this.y][this.x].setEntity(new Water(this.y, this.x));
        }else {
            super.eat(y, x);
        }
    }
}