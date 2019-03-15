//2017.04.08 BeibeiZhang
//realize button and action listener to answer the mouse click
//realize the exchange between two labels(!buttons are not changed just change the labels)
package Sometesting;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;

public class ButtonandMouse {
	
  public static void main(String[] args){
	  JFrame firstframe=new JFrame();
	//In JFrame, we can close the window easily by click the "¡Á"
	//But in Frame, we need to use WindowListener and then clicking the "¡Á" can make difference
	  firstframe.setTitle("my first frame");
	  firstframe.setBackground(Color.blue);
	  firstframe.setBounds(200, 200, 400, 400);
	  JPanel firstJpanel=new JPanel();
	  firstJpanel.setSize(400, 400);
	  firstJpanel.setLayout(new GridLayout(4,4));
	  firstframe.add(firstJpanel);
	  Button[] buttons=new Button[16];
	  ArrayList<String> label=new ArrayList<String>();
	  ArrayList<String> place=new ArrayList<String>();
	  for(int index=0;index<=15;index++){
		  String number=String.valueOf(index);
		  int randomnumber=(int)(Math.random()*10+1);
		  String Label=String.valueOf(randomnumber);
		  buttons[index]=new Button();
		  buttons[index].setBackground(Color.PINK);
		  buttons[index].setName(number);
		  buttons[index].setLabel(Label);
		  buttons[index].setSize(100,100);
		  String labels=buttons[index].getLabel(); //just change the labels of the button which shows outside
		  String places=buttons[index].getName();//never change the name of the button because it represents the button's place
		  firstJpanel.add(buttons[index]);
		  buttons[index].addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				 place.add(places);//places will not changed because when we click, it represents the buttonName which will 
				 //never be changed 
				 //and also because the places has been initialized in line 66 and will not change in the Listener function
				 //I don't know why
				 //but because of this the button Name never changing will have no effects
				 //however, this means we need to change labels to synchronize it with the update one because we 
				 //set new labels in line79 and line80
    			  if(place.size()>1){
    				  label.add(buttons[Integer.parseInt(place.get(1))].getLabel());
    				  buttons[Integer.parseInt(place.get(0))].setLabel(label.get(1));
    				  buttons[Integer.parseInt(place.get(1))].setLabel(label.get(0));
    				  label.clear();
    				  place.clear();
    				 
    			  }
    			  else{ 
    				  label.add(buttons[Integer.parseInt(place.get(0))].getLabel());
    				
    			  }
				
			  }
		  });
		
	  }
	  firstframe.setVisible(true);
	 
	   }
  
}
  