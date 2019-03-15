package Sometesting;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Place {
	public static void main(String[] args){
	 JFrame firstframe=new JFrame();
		//In JFrame, we can close the window easily by click the "¡Á"
		//But in Frame, we need to use WindowListener and then clicking the "¡Á" can make difference
		  firstframe.setTitle("my first frame");
		  firstframe.setBackground(Color.blue);
		  firstframe.setBounds(200, 200, 400, 400);
		  JPanel firstJpanel=new JPanel();
		  firstJpanel.setSize(400, 400);
		  firstJpanel.setLayout(new GridLayout(8,8));
		  firstframe.add(firstJpanel);
		  Button[] buttons=new Button[64];
		  for(int index=0;index<=63;index++){
			  String number=String.valueOf(index);
			
			  String Label=String.valueOf(number);
			  buttons[index]=new Button();
			  buttons[index].setBackground(Color.PINK);
			  buttons[index].setName(Label);
			  buttons[index].setLabel(Label);
			  buttons[index].setSize(100,100);
			  firstJpanel.add(buttons[index]);
}
		   firstframe.setVisible(true);
	}
	}
