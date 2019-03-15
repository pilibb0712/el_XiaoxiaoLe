package Sometesting;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test3 {
	
	public static void main(String[] args){
		JButton button1=new JButton("1");
		JButton button2=new JButton("2");
		JFrame aframe=new JFrame();
		JPanel apanel=new JPanel();
		aframe.setBounds(100,100,300,300);
		aframe.setLayout(null);
		aframe.add(apanel);
		apanel.setBounds(0, 0, 200, 100);
		apanel.setLayout(new GridLayout(2,1));
		apanel.add(button1);
		apanel.add(button2);
		

	}
}
