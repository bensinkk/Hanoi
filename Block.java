import java.awt.*;
public class Block
{
    public int x;
    public int y;
    public int h;
    public int w;
    public int num;
    public Color color;
    public Block(int x, int y, int h, int w, int n, Color c){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.num = n;
        this.color = c;
    }
    public Block(int x, int y, int h, int w, Color c){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.num = -1;
        this.color = c;
    }
    public Block(){
        x = 0;
        y = 0;
        h = 0;
        w = 0;
        num = -1;
        color = Color.BLACK;
    }
    public void rightOne(){
        x+=220;
    }
    public void rightTwo(){
        x+=440;
    }
    public void leftOne(){
        x-=220;
    }
    public void leftTwo(){
        x-=440;
    }
    public void down(int num){
        y+=25*num;
    }
    public void up(int num){
        y-=25*num;
    }
    public void horizShift(int i){
        x+=220*i;
    }
}