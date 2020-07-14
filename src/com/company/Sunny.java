package com.company;

public class Sunny extends Entity {
    public Sunny(){}
    public Sunny(int y, int x, double chance){
        this.chance=chance;
        this.x=x;
        this.y=y;
    }
    double chance;
    public void live() {
        if (chance > 0) {
            double r = Math.random();
            if (r <= chance && y > 0) {
                World.ar_block[y][x].setEntity(new Sunny(y - 1, x, chance+Cons.minusChance));

            }
            chance=0;
        }else{
            if(y>0 && World.ar_block[y-1][x].entity instanceof Water) {
                double r = Math.random();
                if(r>0.997)
                    World.ar_block[y-1][x].setEntity(new Bubble(y-1, x));

            }

        }
    }
}
