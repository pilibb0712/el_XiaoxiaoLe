package Sometesting;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Beginning {
        static ImageIcon mainbackground=new ImageIcon("main.jpg");
        static JLabel mainlabel=new JLabel(mainbackground);
        static JFrame firstframe=new JFrame();
        static ImageIcon newgameIcon=new ImageIcon("newgame.png");
        static ImageIcon continuegameIcon=new ImageIcon("continuegame.png");
        static ImageIcon exitgameIcon=new ImageIcon("exit.png");
        public static void main(String[] args){
           int height=mainbackground.getIconHeight();
           int width=mainbackground.getIconWidth();
           firstframe.setBounds(40, 40, width, height);
           mainlabel.setBounds(40,40,width,height);
           JPanel panel0=(JPanel)firstframe.getContentPane();
           panel0.setOpaque(false);
      	 //if you want to put something on the content pane(the top panel/surface)
      	 firstframe.getLayeredPane().add(mainlabel,new Integer(Integer.MIN_VALUE));
      	 firstframe.setVisible(true);
      	 JButton newgameBU=new JButton();
      	 newgameBU.setBackground(Color.ORANGE);
      	 newgameBU.setIcon(newgameIcon);
      	JButton continuegameBU=new JButton();
      	continuegameBU.setBackground(Color.ORANGE);
     	 continuegameBU.setIcon(continuegameIcon);
     	JButton exitgameBU=new JButton();
     	exitgameBU.setBackground(Color.ORANGE);
     	 exitgameBU.setIcon(exitgameIcon);
     	 panel0.setLayout(null);
     	 panel0.add(newgameBU);
     	panel0.add(continuegameBU);
     	panel0.add(exitgameBU);
     	int width2=(newgameIcon.getIconWidth()*3)/2;
     	int height2=(newgameIcon.getIconHeight())*2;
     	newgameBU.setBounds(170, 80+height2*2, width2, height2);
     	continuegameBU.setBounds(170, 100+height2*3, width2, height2);
     	exitgameBU.setBounds(170,120+height2*4,width2, height2);
    
        firstframe.setVisible(true);
      	 
        }
        
}
