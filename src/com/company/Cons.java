package com.company;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;



public class Cons {
    private static Cons ourInstance = new Cons();

    public static Cons getInstance() {
        return ourInstance;
    }
    public static int WIDTH;
    public static final int speedBlockHeightDivider = 10;
    public static int optHeight = Toolkit.getDefaultToolkit().getScreenSize().height/speedBlockHeightDivider;
    public static int HEIGHT;
    public static int speed;
    public static int sunCoef;
    public static double minusChance;
    public static final int blockWidth = 16;
    public static final int blockHeight = 16;
    public static double first = 0;
    public static double second = 0;
    public static int dx;
    public static int dy;
    public static void timeGoing(){
        for(int i=0; i<1e9; i+=9*speed/speedBlockHeightDivider+1){
            if (speed==0)
                i-=(int)(Math.random())+1;
            Listener.listen();
        }
    }
    public static void createAll(int width, int height){
        WIDTH=width/blockWidth;
        dx=(width%blockWidth)/2;
        HEIGHT=height/blockHeight;
        dy=(height%blockHeight)/2+optHeight;
        minusChance=-0.8*12/HEIGHT;
        sunCoef=5*48/HEIGHT;
    }

    public static int BubbleColor1 = 0xccffff;
    public static int BubbleColor2 = 0x0033cc;
    public static int WaterColor = 0x085176;
    public static int PoisonColor = 0x086076;
    public static int Fish2Color1 = 0x993399;
    public static int Fish2Color2 = 0x660066;
    public static int Fish1Color1 = 0xff6699;
    public static int Fish1Color2 = 0xff0066;
    public static int SandColor1 = 0xffcc66;
    public static int SandColor2 = 0x996633;
    public static int CrabColor = 0xff3300;
    public static int SunnyColor = 0x009933;
    
    public static Color getColor(int color) {
       return new Color(color);
    }
    private Cons() {
    }
    public static void dealWithIt(Graphics g, int y, int x){
//        System.out.println(y+" "+x);
//        System.out.println(World.ar_block[y][x].entity);
        Entity ent = World.ar_block[y][x].entity;
        g.setColor(getColor(0x000000));
        g.fillRect(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
        g.setColor(getColor(WaterColor));
        g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
        if(ent instanceof Fish1){
            g.setColor(getColor(Fish1Color1));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.setColor(getColor(Fish1Color2));
            g.drawOval(x*blockWidth+1+dx, y*blockHeight+1+dy, blockWidth-2, blockHeight-2);
        }
        if(ent instanceof Fish2){
            g.setColor(getColor(Fish2Color1));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.setColor(getColor(Fish2Color2));
            g.drawOval(x*blockWidth+1+dx, y*blockHeight+1+dy, blockWidth-2, blockHeight-2);
        }
        if(ent instanceof Sand){
            g.setColor(getColor(SandColor1));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.setColor(getColor(SandColor2));
            g.drawOval(x*blockWidth+1+dx, y*blockHeight+1+dy, blockWidth-2, blockHeight-2);
        }
        if(ent instanceof Crab && !(ent instanceof UltraBubble)){
            g.setColor(getColor(CrabColor));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.drawLine(x*blockWidth+5+dx, y*blockHeight+5+dy, x*blockHeight+blockHeight-1+dx, y*blockHeight+blockHeight-1+dy);
            g.drawLine(x*blockWidth+blockWidth/2+dx, y*blockHeight+blockHeight/2+dy, x*blockWidth+dx+1,
                    y*blockHeight+blockHeight-1+dy);
        }
        if(ent instanceof UltraBubble){
            g.setColor(getColor(BubbleColor1));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.setColor(getColor(BubbleColor2));
            g.drawOval(x*blockWidth+1+dx, y*blockHeight+1+dy, blockWidth-2, blockHeight-2);
            g.setColor(getColor(CrabColor));
            g.fillOval(x*blockWidth+blockWidth/4+dx, y*blockHeight+blockHeight/4+dy, blockWidth/2, blockHeight/2);
            g.drawLine(x*blockWidth+blockWidth/2+dx, y*blockHeight+blockHeight/2+dy, x*blockWidth+blockWidth/4+dx, y*blockHeight+blockHeight*3/4+dy);
            g.drawLine(x*blockWidth+blockWidth/2+dx, y*blockHeight+blockHeight/2+dy, x*blockWidth+blockWidth*3/4+dx, y*blockHeight+blockHeight*3/4+dy);
            g.setColor(getColor(BubbleColor1));
            g.drawLine(x*blockWidth+blockWidth/4+dx, y*blockHeight+blockHeight/2+dy, x*blockWidth+blockWidth/4+dx, y*blockHeight+blockHeight/2+dy);
        }
        if(ent instanceof Bubble){
            g.setColor(getColor(BubbleColor1));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.setColor(getColor(BubbleColor2));
            g.drawOval(x*blockWidth+1+dx, y*blockHeight+1+dy, blockWidth-2, blockHeight-2);
        }
        if(ent instanceof Poison){
            g.setColor(getColor(PoisonColor));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
        }
        if(ent instanceof Water && !(ent instanceof Poison)){}
        if(ent instanceof Sunny){
            g.setColor(getColor(SunnyColor));
            g.fillOval(x*blockWidth+dx, y*blockHeight+dy, blockWidth, blockHeight);
            g.drawLine(x*blockWidth+dx+1, y*blockHeight+dy+1, x*blockWidth+blockWidth-1+dx, y*blockHeight+blockHeight-1+dy);
            g.drawLine(x*blockWidth+blockWidth+dx-1, y*blockHeight+dy+1, x*blockWidth+1+dx, y*blockHeight+blockHeight-1+dy);
        }
        g.setColor(getColor(0x000000));
        g.drawLine(x*blockWidth+dx, y*blockHeight+dy+blockHeight/2, x*blockWidth+dx, y*blockHeight+dy+blockHeight/2);
    }
}
