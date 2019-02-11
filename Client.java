import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Client
{
    private static class SwitchDisplay implements ActionListener{
    public void actionPerformed(ActionEvent e){

        test.remove(first);
        //Cleint.test.getContentPane().removeAll();
        test.add(woot);
        watch.start();
        actual = true;
        test.setVisible(true);
        woot.repaint();
        //System.out.println("hallo");
    }
    }
    private static class Stopwatch implements ActionListener
    {
    public void actionPerformed(ActionEvent e){
        time++;
        woot.repaint();
    }
    }
    public static JFrame test;
    public static Display woot;
    private static Display first;

    public static int time = 0;
    public static boolean actual = false;
    public static Timer watch;
    public static void main(String[] args){
       test = new JFrame("Neat Game");
       first = new Display(4);
       test.add(first);
       woot = new Display("asdf");
       //test.add(woot);
       test.setSize(700,400);
       test.setLocation(200,200);
       test.setDefaultCloseOperation(3);

       Button asdf = new Button();
       woot.addMouseListener(asdf);
       Stopwatch a = new Stopwatch();
       watch = new Timer(1000,a);

       JButton hype = new JButton("START");
       //        hype.setVerticalTextPosition(AbstractButton.CENTER);
       //        hype.setHorizontalTextPosition(AbstractButton.CENTER);
       SwitchDisplay bleh = new SwitchDisplay();
       hype.addActionListener(bleh);
       first.setLayout(null);
       hype.setSize(80,40);
       hype.setLocation(250,300);
       first.add(hype);
       test.setVisible(true);
    }
}
