package EL;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BBBBounder {
      public static void main(String[] args){
    	  ImageIcon background=new ImageIcon("10.jpg");
    	  JLabel backg=new JLabel(background);
    	  int width=background.getIconWidth();
    	  int height=background.getIconHeight();
    	  JFrame newframe=new JFrame();
    	  newframe.setBounds(0,0,width,height);
    	  backg.setBounds(0,0,width,height);
    	  newframe.getLayeredPane().add(backg,new Integer(Integer.MIN_VALUE));
    	  JPanel toppanel=(JPanel)(newframe.getContentPane());
          toppanel.setLayout(new GridLayout(2,1));  	  
    	  toppanel.setOpaque(false);
    	  JPanel panel1=new JPanel();
    	  panel1.setLayout(new GridLayout(1,3));
    	  Font fon=new Font("ËÎÌו",1,30);
    	  JTextField text1=new JTextField();
    	  text1.setBounds(100,100, 10, 10);
    	  text1.setFont(fon);
    	  text1.setText("text1");
    	  text1.setOpaque(false);
    	  JTextField text2=new JTextField();
    	  text2.setBounds(0, 0, 100, 100);
    	  text2.setFont(fon);
    	  text2.setText("text2");
    	  text2.setOpaque(false);
    	  JTextField text3=new JTextField();
    	  text3.setBounds(0, 0, 100, 100);
    	  text3.setFont(fon);
    	  text3.setText("text3");
    	  text3.setOpaque(false);
    	  panel1.add(text1);
    	  panel1.add(text2);
    	  panel1.add(text3);
    	  panel1.setOpaque(false);
    	  toppanel.add(panel1);
    	  newframe.setVisible(true);
      }
}
