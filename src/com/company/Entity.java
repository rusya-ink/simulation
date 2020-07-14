package com.company;

public abstract class Entity {
    int x, y;
    public Entity(int y, int x){
        this.x=x;
        this.y=y;
    }
    public Entity(){}
    double energy;
    double maxEnergy;
    double recovery;
    double costOfMoving;
    double costOfLife;
    public void live(){}
    boolean used;
    public void eat(int y, int x){
        if(!(World.ar_block[y][x].entity instanceof Sunny)) {
            if(World.ar_block[y][x].entity instanceof Poison){
                this.energy-=((Poison) World.ar_block[y][x].entity).poisonLevel;
            }
            World.ar_block[y][x].setEntity(this);
            World.ar_block[this.y][this.x].setEntity(new Water(this.y, this.x));
            this.x = x;
            this.y = y;

        }
    }

}
