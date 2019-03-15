package Sometesting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TxtField {
   public static void main(String[] args){
	   JFrame newframe=new JFrame();
	   JPanel panel1=new JPanel();
	   JPanel panel2=new JPanel();
	   JPanel panel3=new JPanel();
	   TextField txt1=new TextField();
	   TextField txt2=new TextField();
	   txt1.setText("firfst");
	   txt2.setText("text field");
	   txt1.setSize(100, 50); 
	   panel1.add(txt1);
	   panel2.add(txt2);
	   newframe.setBounds(400, 200, 400, 400);	
	   newframe.setLayout(new GridLayout());
	   panel1.setBounds(400, 200, 100, 50);
	   panel2.setBounds(400, 200, 100, 50);
	   panel3.setBounds(400, 200, 300, 300);
	   panel1.setBackground(Color.BLUE);
	   panel2.setBackground(Color.gray);
	   panel3.setBackground(Color.cyan);
	   newframe.add(panel1);
	   newframe.add(panel2);
	   newframe.add(panel3);
	   newframe.setVisible(true);
	   
   }
}
