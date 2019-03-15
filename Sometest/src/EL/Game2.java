//2017.05.07 BeibeiZhang 
//the other way of the game base on the NewCheck.java
package EL;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game2 {
	static Boolean isRightBound(int place){
		//use this func to judge the button is not at the four edges of the panel
		//or there will be no buttons[place+1] and the system will show the mistake 
		Boolean isright=false;
		int[] right={7,15,23,31,39,47,55,63};
		for(int Right:right){
			if(place==Right){
				isright=true;
			}
		}
		return isright;
	}
	
	
	 static Boolean isLeftBound(int place){
		Boolean isleft=false;
		int[] left={0,8,16,24,32,40,48,56};
		for(int Left:left){
			if(place==Left){
				isleft=true;
			}
		}
		return isleft;
	}
	
	
	 static Boolean isUpBound(int place){
		Boolean isup=false;
		int[] up={0,1,2,3,4,5,6,7};
		for(int Up:up){
			if(place==Up){
				isup=true;
			}
		}
		return isup;
	}
	
	
	static Boolean isDownBound(int place){
		Boolean isdown=false;
		int[] down={56,57,58,59,60,61,62,63};
		for(int Down:down){
			if(place==Down){
				isdown=true;
			}
		}
		return isdown;
	}
	 static void Findsamearound(int place,JButton[] buttons,ArrayList<Integer> places){
		 if(places.isEmpty()){
			 places.add(place);
			
		 }
		 else{
			 Boolean existed0=false;
             for(int i=0;i<=(places.size()-1);i++){
           
              if(places.get(i)==(place)){
            	  existed0=true;
            	  
            	  break;
              }
	  }
             if(existed0==false){
            	 places.add(place);  
            
             }
             else{
            	 
             } 
		 }
			        if(isRightBound(place)==false){
		                        if(buttons[place].getIcon().equals(buttons[place+1].getIcon())){
		                         Boolean existed=false;
		                         for(int i=0;i<=(places.size()-1);i++){
		        	              if(places.get(i).equals(place+1)){
		        	            	  existed=true;
		        	            	  break;
		        	              }
		           	  }
		                         if(existed==false){
		                        	 places.add(place+1);
			        	             Findsamearound(place+1,buttons,places);
		                         }
		                         else{
		                        	 
		                         }
		                         }
		              }
		       	   if(isLeftBound(place)==false){
				                if(buttons[place].getIcon().equals(buttons[place-1].getIcon())){
				                	   Boolean existed=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				        	              if(places.get(i).equals(place-1)){
				        	            	  existed=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed==false){
				                        	 places.add(place-1);
					        	             Findsamearound(place-1,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				              }
		           if(isUpBound(place)==false){
				                 if(buttons[place].getIcon().equals(buttons[place-8].getIcon())){
				                	   Boolean existed=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				        	              if(places.get(i).equals(place-8)){
				        	            	  existed=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed==false){
				                        	 places.add(place-8);
					        	             Findsamearound(place-8,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				             }
			       if(isDownBound(place)==false){
				                if(buttons[place].getIcon().equals(buttons[place+8].getIcon())){
				                	   Boolean existed=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				        	              if(places.get(i).equals(place+8)){
				        	            	  existed=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed==false){
				                        	 places.add(place+8);
					        	             Findsamearound(place+8,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				            }
		            	 
			 }
	//use recursion function to constantly find the next same button
	//GOOD AND SIMPLE
	//it is the best way
	static ImageIcon[] images=new ImageIcon[5];
	static ImageIcon image1=new ImageIcon("1.jpg");
	static ImageIcon image2=new ImageIcon("2.jpg");
	static ImageIcon image3=new ImageIcon("3.jpg");
	static ImageIcon image4=new ImageIcon("4.jpg");
	static ImageIcon image5=new ImageIcon("5.jpg");
	 
     public static void main(String[] args){
    	 images[0]=image1;
    	 images[1]=image2;
    	 images[2]=image3;
    	 images[3]=image4;
    	 images[4]=image5;
    	 JFrame newFrame=new JFrame();
    	 newFrame.setBounds(0,0,800,800);
    	 JPanel newPanel=new JPanel();
    	 newFrame.add(newPanel);
    	 newPanel.setBackground(Color.pink);
    	 newPanel.setLayout(new GridLayout(8,8));
    	 JButton[] buttons=new JButton[64];
    	 for(int i=0;i<=63;i++){
    		 int randomnumber=(int)(Math.random()*5+1);
    		  buttons[i]=new JButton();
    		  buttons[i].setActionCommand(String.valueOf(i));
    		  buttons[i].setIcon(images[randomnumber-1]);
    		  buttons[i].setBackground(Color.ORANGE);
    		  buttons[i].setBorderPainted(false);
    		  buttons[i].setBorder(null);
    		  buttons[i].setFocusPainted(false);
    		  newPanel.add(buttons[i]);
    		  buttons[i].addActionListener(
    				  new ActionListener(){
    					  public void actionPerformed(ActionEvent ex){
    						 int place=Integer.parseInt(ex.getActionCommand());
    						 Icon icon=buttons[place].getIcon();
    						 ArrayList<Integer> sameLabelPlace=new ArrayList<Integer>();
    						 sameLabelPlace.clear();
    						 if(buttons[place].getIcon()==null){
    							 
    						 }
    				      		else{
    				      		  Findsamearound(place,buttons,sameLabelPlace);	
    				      			}
    				      		int length=sameLabelPlace.size();
    				      		
    				      		if(length>=3){
    				      			for(int n=0;n<=length-1;n++){
    				      				buttons[sameLabelPlace.get(n)].setIcon(null);
    				      			
    				      			}
    				      		}
    				      		else{
    				            		}
    				      		CheckGame2 check3=new CheckGame2();
    				      		if(check3.Mycheck2(buttons)){
			      		    		 System.out.println("Ok, let's go!");
			      		    	 }
			      		    	 else{
			      		    		 System.out.println("Sorry, it is dead");
			      		    	 }  
    					  }
    				  }
    				  );
    	 }
    	 CheckGame2 check2=new CheckGame2();
    	 if(check2.Mycheck2(buttons)){
    		 System.out.println("Ok, let's go!");
    	 }
    	 else{
    		 System.out.println("Sorry, it is dead");
    	 }
    	 newFrame.setVisible(true);
     }
}
