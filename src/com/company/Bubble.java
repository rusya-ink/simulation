package com.company;

public class Bubble extends Entity {
    public Bubble(int y, int x) {
        this.x = x;
        this.y = y;
    }


    public void live() {
       if(y>0){
           if(World.ar_block[y-1][x].entity instanceof Water){
               World.ar_block[y-1][x].setEntity(this);
               World.ar_block[y][x].setEntity(new Water(y, x));
               this.y=y-1;
           }else{
               if(World.ar_block[y-1][x].entity instanceof Crab){
                   World.ar_block[y-1][x].setEntity(new UltraBubble(y-1, x));
                   World.ar_block[y][x].setEntity(new Water(y, x));
               }else{
                   World.ar_block[y][x].setEntity(new Water(y, x));
               }
           }
       }
       else{
           World.ar_block[y][x].setEntity(new Water(y, x));
       }
    }
}
