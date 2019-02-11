import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.File;
import java.io.*;
import java.awt.event.*;
public class Display extends JPanel{
    private Block one, two, three, four, five,standOne,standTwo,standThree;
    private Block[] blocks;
    private String message;
    private static Font cool = new Font("SansSerif",Font.PLAIN,30);
    private static Font cooler = new Font("SansSerif",Font.PLAIN,20);
    private BufferedImage picture;
    private static boolean[][] pieces = {{true,true,true,true,true},
        new boolean[5],
        new boolean[5]};
    private String output2;
    private String output3;
    private String output4;
    private String output5;
    public Display(String a){
        one = new Block(90,125,25,40,1,Color.RED);
        two = new Block(80,150,25,60,2,Color.BLUE);
        three = new Block(70,175,25,80,3,Color.PINK);
        four = new Block(60,200,25,100,4,Color.ORANGE);
        five = new Block(50,225,25,120,5,Color.GREEN);
        standOne = new Block(25,250,40,170,Color.BLACK);
        standTwo = new Block(245,250,40,170,Color.BLACK);
        standThree = new Block(465,250,40,170,Color.BLACK);
        blocks = new Block[5];
        blocks[0] = one;
        blocks[1] = two;
        blocks[2] = three;
        blocks[3] = four;
        blocks[4] = five;
        try{
            picture = ImageIO.read(new File("cloud.jpg"));
        }catch(IOException e){}
        
    }
    public Display(int a){
        one = new Block();
        two = new Block();
        three = new Block();
        four = new Block();
        five = new Block();
        standOne = new Block();
        standTwo = new Block();
        standThree = new Block();
        blocks = new Block[5];
        blocks[0] = one;
        blocks[1] = two;
        blocks[2] = three;
        blocks[3] = four;
        blocks[4] = five;
        output2 = "Move all the blocks to the right stand, except...";
        output3 = "You can't put a larger block on a smaller one!";
        output4 = "Click a piece to select it, click again to move it";
        output5 = "Minimum number of moves: 31";
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(picture,0,0,null);
        g.setFont(cool);
        if(!Button.override){
            if(Button.highlight&&Button.ifBlock(Button.stackNum))
                highlight(g,findPiece());
            else if(Button.move&&check(findPiece()))
                moveStuff();
            else
                Button.highlight = false;
        }
        if(Client.actual)
            message = String.format("MOVES: %d   TIME: %d",Button.moveCounter,Client.time);
        else
            message = "Welcome to Tower of Hanoi!";
        for(int i = 0; i<5;i++){
            g.setColor(blocks[i].color);
            g.fillRect(blocks[i].x,blocks[i].y,blocks[i].w,blocks[i].h);
        }
        g.setColor(Color.BLACK);
        g.fillRect(standOne.x,standOne.y,standOne.w,standOne.h);
        g.fillRect(standTwo.x,standTwo.y,standTwo.w,standTwo.h);
        g.fillRect(standThree.x,standThree.y,standThree.w,standThree.h);
        if(Button.highlight&&Button.ifBlock(Button.stackNum)&&!Button.override)
            highlight(g,findPiece());
        g.drawRect(one.x,one.y,one.w,one.h);
        g.drawRect(two.x,two.y,two.w,two.h);
        g.drawRect(three.x,three.y,three.w,three.h);
        g.drawRect(four.x,four.y,four.w,four.h);
        g.drawRect(five.x,five.y,five.w,five.h);
        g.drawRect(standOne.x,standOne.y,standOne.w,standOne.h);
        g.drawRect(standTwo.x,standTwo.y,standTwo.w,standTwo.h);
        g.drawRect(standThree.x,standThree.y,standThree.w,standThree.h);
        if(checkWin()){
            Client.watch.stop();
            message = String.format("YOU WIN!   Moves: %d   Time: %d",Button.moveCounter,Client.time);
            Button.override = true;
        }
        g.drawString(message,100,100);
        if(!Client.actual){
            g.setFont(cooler);
            g.drawString(output2,100,140);
            g.drawString(output3,100,180);
            g.drawString(output4,100,220);
            g.drawString(output5,100,260);
        }
    }
    public void highlight(Graphics g,int index){
        g.setColor(Color.WHITE);
        if(index>-1)
            g.fillRect(blocks[index].x,blocks[index].y,blocks[index].w,blocks[index].h);
        g.setColor(Color.BLACK);
    }
    public void moveHoriz(int index){
        blocks[index].horizShift(Button.otherStack-Button.stackNum);
    }
    public void moveVert(int index){
        int count = -25*(numBlocks(Button.stackNum)+1);
        count+=25*numBlocks(Button.otherStack);
        blocks[index].y+=count;
    }
    public void setNewLayout(int index){
        pieces[Button.otherStack-1][index] = true;
        pieces[Button.stackNum-1][index] = false;
    }
    public static int findPiece(){
        int index = -1;
        for(int i = 0;i<5;i++){
            if(pieces[Button.stackNum-1][i]){
                index = i;
                break;
            }
        }
        return index;
    }
    public static int numBlocks(int a){
        int count = 0;
        for(boolean i:pieces[a-1])
            if(!i)
                count++;
        return count;
    }
    public static boolean check(int index){
        for(int i = 0; i<index;i++){
           if(pieces[Button.otherStack-1][i])
                return false;
            }
        if(Button.otherStack == Button.stackNum)
            return false;
        return true;
    }
    public static boolean checkWin(){
        for(boolean i: pieces[2]){
            if(!i)
                return false;
        }
        return true;
    }
    public void moveStuff(){
        moveHoriz(findPiece());
        moveVert(findPiece());
        setNewLayout(findPiece());
        Button.reset();
    }
    public void totalMove(int k){
        blocks[k].x = 490+10*(4-k);
        blocks[k].y = 125+25*k;
        pieces[0][k] = false;
        pieces[1][k] = false;
        pieces[2][k] = true;
    }
    public static boolean[][] getPieces(){
        return pieces;
    }
}