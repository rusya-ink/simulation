package com.company;

public class Sand extends Entity {
    public Sand(int y, int x) {
        this.y = y;
        this.x = x;
        ticsUntil = 100;
    }

    int ticsUntil;

    public Sand() {
    }

    public void live() {
        if (y + 1 < Cons.HEIGHT) {
            if (World.ar_block[y + 1][x].entity instanceof Water || World.ar_block[y + 1][x].entity instanceof Bubble) {
                eat(y+1, x);
            } else {
                if (!(World.ar_block[y + 1][x].entity instanceof Crab) && !(World.ar_block[y + 1][x].entity
                        instanceof UltraBubble) && !(World.ar_block[y + 1][x].entity
                        instanceof Sunny) && !(World.ar_block[y + 1][x].entity
                        instanceof Sand)) {
                    World.ar_block[y + 1][x].setEntity(new Sand(y + 1, x));
                } else {
                    int[][] toGo = new int[2][2];
                    int t = 0;
                    if (x > 0 && (World.ar_block[y + 1][x - 1].entity instanceof Water || World.ar_block[y + 1][x - 1].entity instanceof Bubble)) {
                        toGo[t][0]=y+1;
                        toGo[t][1]=x-1;
                        t++;
                    }
                    if (x + 1 < Cons.WIDTH && (World.ar_block[y + 1][x + 1].entity instanceof Water || World.ar_block[y + 1][x + 1].entity instanceof Bubble)) {
                        toGo[t][0]=y+1;
                        toGo[t][1]=x+1;
                        t++;
                    }
                    if (t>0){
                        int r=(int)(Math.random()*t);
                        eat(toGo[r][0], toGo[r][1]);
                    }
                }
            }


        }
        ticsUntil--;
        if (ticsUntil < 0) {
            World.ar_block[y][x].setEntity(new Crab(y, x));
        }
    }
}
