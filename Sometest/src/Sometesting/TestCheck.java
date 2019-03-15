//just to check the class "Check"

package Sometesting;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCheck {
            public static void main(String[] args){
          
            	int number=0;
            	Font myfon=new Font("ËÎÌו",1,30);
            	JFrame aFrame=new JFrame("Check check");
            	aFrame.setBounds(100, 400, 800, 800);
            	JPanel aPanel=new JPanel();
            	aPanel.setSize(800,800);
            	aPanel.setLayout(new GridLayout(8,8));
            	Button[] buttons=new Button[64];
            	for(number=0;number<=63;number++){
              		String labels=String.valueOf((int)(Math.random()*6));
            		buttons[number]=new Button();
            		buttons[number].setBackground(Color.pink);
            		buttons[number].setFont(myfon);
            		buttons[number].setLabel(labels);
            		aPanel.add(buttons[number]);
            	           	}
            	aFrame.add(aPanel);
            	aFrame.setVisible(true);
            	try{ 
					Thread.sleep(3000);
				}catch(InterruptedException e){
					  	e.printStackTrace();
					}
              	MyCheck check=new MyCheck();
                check.myCheck(buttons);
                System.out.println("ok");
            }
}
