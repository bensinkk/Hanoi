import java.awt.event.*;
public class Button implements MouseListener
{
    private static int x;
    private static int y;
    public static int stackNum = 0;
    public static int otherStack = 0;
    public static boolean highlight = false;
    public static boolean move = false;
    public static int moveCounter = 0;
    public static boolean override = false;
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        move = false;
        if(this.x>=25&&this.x<=195&&this.y>=125&&this.y<=505){
            highlight=!highlight;
            if(highlight)
                stackNum = 1;
            if(!highlight){
                move = true;
                otherStack = 1;
            }
        }
        else if(this.x>=245&&this.x<=415&&this.y>=125&&this.y<=505){
            highlight=!highlight;
            if(highlight)
                stackNum = 2;
            if(!highlight){
                move = true;
                otherStack = 2;
            }
        }
        else if(this.x>=465&&this.x<=635&&this.y>=125&&this.y<=505){
            highlight=!highlight;
            if(highlight)
                stackNum = 3;
            if(!highlight){
                move = true;
                otherStack = 3;
            }
        }
        else if (this.x>=675 &&this.y<=25){
            for(int i = 4; i>-1;i--)
                Client.woot.totalMove(i);
            override = true;
        }
        Client.woot.repaint();
    }
    public static boolean ifBlock(int q){
        for(boolean i : Display.getPieces()[q-1]){
            if(i)
                return true;
        }
        return false;
    }
    public static void reset(){
        stackNum = 0;
        otherStack = 0;
        highlight = false;
        move = false;
        moveCounter++;
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){
    }
    public void mouseExited(MouseEvent e){
    }
    public void mouseClicked(MouseEvent e){
    }
}