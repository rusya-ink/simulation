package com.company;

public class Block {
    Entity entity;

    int sun;
    public Block(int y, int x){
        sun=(Cons.HEIGHT-y)*Cons.sunCoef;
        entity = new Water(y, x);
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
