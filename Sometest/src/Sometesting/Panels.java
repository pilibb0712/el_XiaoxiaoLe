package Sometesting;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panels {
      public static void main(String[] args){
    	  JFrame secondframe=new JFrame("second frame");
    	  secondframe.setSize(200, 200);
    	  
    	  JPanel firstpanel=new JPanel();
    	  firstpanel.setBackground(Color.PINK);
    	  firstpanel.setSize(400, 400);
    	  firstpanel.setLayout(new GridLayout(1,2));
    	  firstpanel.setName("firstpanel");
    	  JPanel secondpanel=new JPanel();
    	  secondpanel.setBackground(Color.GREEN);
    	  secondpanel.setSize(100,100);
          secondframe.add(firstpanel);
          secondframe.add(secondpanel);
          Button[] button=new Button[2];
          ArrayList<String> mark=new ArrayList<String>();
       for(int index=0;index<=1;index++){
    	   button[index]=new Button(String.valueOf(index));
    	   firstpanel.add(button[index]);
    	   String number=String.valueOf(index);
    	   button[index].addActionListener(new ActionListener(){
    		   public void actionPerformed(ActionEvent e){
    			  mark.add(number);
    			  if(mark.size()>1){
    				  firstpanel.remove(button[Integer.parseInt(mark.get(0))]);
    				  firstpanel.add(new Button(mark.get(1)));
    				  secondframe.setVisible(true);
    				  firstpanel.remove(button[Integer.parseInt(mark.get(1))]);
    				  firstpanel.add(new Button(mark.get(0)));
    				  secondframe.setVisible(true);
    				  mark.clear();
    			  }
    			  else{ 
    				 
    				  System.out.println("click one button");
    			  }
    		   }
    	   }
    			   );
    	     }
         secondframe.setVisible(true);
}
      }
