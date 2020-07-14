package com.company;

public class Poison extends Water {
    public Poison(int y, int x){
        this.x=x;
        this.y=y;
        poisonLevel=Math.random()/1000;
    }
    double poisonLevel;

    public void setPoisonLevel(double poisonLevel) {
        this.poisonLevel = poisonLevel;
        if(this.poisonLevel>1000000)
            this.poisonLevel=1000000;
    }
    public void addPoisonLevel(double addPoisonLevel){
        this.poisonLevel+= addPoisonLevel;
        if(poisonLevel>1000000)
            poisonLevel=1000000;
    }

    public void live() {
        System.out.println(poisonLevel);
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                if((i!=0 || j!=0) && y+i>=0 && y+i<Cons.HEIGHT && x+j>=0 && x+j<Cons.WIDTH && World.ar_block[y+i][x+j].entity instanceof Water){
                    if(Math.random()>0.99) {
                        if (World.ar_block[y + i][x + j].entity instanceof Poison) {
                            ((Poison) World.ar_block[y + i][x + j].entity).addPoisonLevel(poisonLevel);
                        } else {
                            World.ar_block[y + i][x + j].setEntity(new Poison(y + i, x + j));
                            ((Poison) World.ar_block[y + i][x + j].entity).setPoisonLevel(poisonLevel);
                        }
                    }
                }
            }
        }
    }
}
