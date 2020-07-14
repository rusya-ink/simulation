package com.company;

public class World {
    private static World ourInstance = new World();

    public static World getInstance() {
        return ourInstance;
    }

    private World() {
    }

    public static Block[][] ar_block;

    public static void creator() {
        ar_block = new Block[Cons.HEIGHT][Cons.WIDTH];
        for (int i = 0; i < Cons.HEIGHT; i++) {
            for (int j = 0; j < Cons.WIDTH; j++) {
                ar_block[i][j] = new Block(i, j);
            }
        }
        for (int i = 0; i < Math.min(Cons.HEIGHT, Cons.WIDTH)/2-1; i++) {
            ar_block[i][i].setEntity(new Fish2(i, i));
            ar_block[i][-i+Cons.WIDTH-1].setEntity(new Fish2(i, -i+Cons.WIDTH-1));
            ar_block[i+1][i].setEntity(new Fish1(i+1, i));
            ar_block[i+1][-i+Cons.WIDTH-1].setEntity(new Fish1(i+1, -i+Cons.WIDTH-1));
        }
//        ar_block[0][0].setEntity(new Fish2(0, 0));
//        ar_block[0][Cons.WIDTH-1].setEntity(new Fish1(0, Cons.WIDTH-1));
//        ar_block[40][0].setEntity(new Runner(40, 0));
//        ar_block[40][Cons.WIDTH-1].setEntity(new Runner(40, Cons.WIDTH-1));

        for(int i=0; i<Cons.WIDTH; i++){
            ar_block[Cons.HEIGHT-1][i].setEntity(new Sunny(Cons.HEIGHT-1, i, 0.8));
        }

    }
}
