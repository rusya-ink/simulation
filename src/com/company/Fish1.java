package com.company;

public class Fish1 extends Entity {
    public Fish1(int y, int x) {
        maxEnergy = 1000;
        energy = 10;
        costOfLife = 5;
        costOfMoving = 50;
        recovery = 1.0 / 30;
        st=-1;
        fn=2;
        d=1;
        this.x = x;
        this.y = y;
        turn =0;
    }
    int st, fn, d;
    public int turn;
    public void live() {

        if (turn==0) {
            int nextSun = -1, nextY = -1, nextX = -1;
            st*=-1;
            fn*=-1;
            d*=-1;
            for (int i = st; i !=fn; i+=d) {
                for (int j = st; j < fn; j+=d) {
                    if (y + i >= 0 && y + i < Cons.HEIGHT && x + j >= 0 && x + j < Cons.WIDTH && (i != 0 || j != 0)) {
                        if (World.ar_block[y + i][x + j].sun > nextSun && (World.ar_block[y + i][x + j].entity instanceof Water || World.ar_block[y + i][x + j].entity instanceof Fish2)) {
                            nextSun = World.ar_block[y + i][x + j].sun;
                            nextY = y + i;
                            nextX = x + j;
                        }
                    }
                }
            }

            int[][] next = new int[8][2];
            int n = 0;

            for (int i = st; i !=fn; i+=d) {
                for (int j = st; j < fn; j+=d) {
                    if (y + i >= 0 && y + i < Cons.HEIGHT && x + j >= 0 && x + j < Cons.WIDTH && (i != 0 || j != 0)) {
                        if (World.ar_block[y + i][x + j].sun == nextSun && (World.ar_block[y + i][x + j].entity instanceof Water || World.ar_block[y + i][x + j].entity instanceof Fish2)) {
                            next[n][0]=y+i;
                            next[n][1]=x+j;
                            n++;
                        }
                    }
                }
            }

            if (recovery * World.ar_block[y][x].sun >= costOfLife && energy > 150) {
                if (nextSun != -1 && recovery * nextSun > costOfLife)
                    give_birth(nextY, nextX);
            } else {

                    if (nextSun != -1 && nextSun>= World.ar_block[y][x].sun && energy > costOfMoving && (recovery * nextSun > costOfLife
                            || nextSun > World.ar_block[y][x].sun) && n > 0) {
                        int r = (int) (Math.random() * n);
                        if(r==0&&n>1)
                            Cons.first++;
                        if(r==1&&n>1)
                            Cons.second++;
                        nextY = next[r][0];
                        nextX = next[r][1];
                        eat(nextY, nextX);
                    }
            }
            turn=3;
        }else{turn--;}

        energy += recovery * World.ar_block[y][x].sun - costOfLife;
        if (energy < 0 || energy > maxEnergy) {
            World.ar_block[y][x].setEntity(new Sand(y, x));
        }
    }

    public void give_birth(int y, int x) {
        double minusEnergy=0;
        if(World.ar_block[y][x].entity instanceof Poison){
            minusEnergy=-((Poison) World.ar_block[y][x].entity).poisonLevel;
        }
        World.ar_block[y][x].setEntity(new Fish1(y, x));
        World.ar_block[y][x].entity.energy = energy / 2+minusEnergy;
        energy = 0;
    }
}


