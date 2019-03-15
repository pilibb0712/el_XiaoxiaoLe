//demo of 4*4 and delete three labels
	package Sometesting;

	import java.awt.Button;
	import java.awt.Color;

	import java.awt.GridLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

import java.util.ArrayList;

	import javax.swing.*;

	public class KeyCalculation {
		public static Boolean twiceclickdelete(Button[] buttons,int place1,int place2){
			Boolean deleted=false;
			int[] places={place1,place2};
			for(int i:places){
			if((i==5)||(i==6)||(i==9)||(i==10)||(i==1)||(i==2)||(i==13)||(i==14)){
			   if(((buttons[i].getLabel()).equals((buttons[i-1].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i+1].getLabel())))){
				//in a line buttons[place1] and its left and its right are the same
				buttons[i].setLabel(" ");
				buttons[i-1].setLabel(" ");
				buttons[i+1].setLabel(" ");
				deleted=true;
				continue;
				//when we delete the three labels, there is no need doing the next judge about button[place1] 
			}//buttons[place1] is not in the special places of four edges of the panel then it can be the middle place in a line
			}//if((place1==5)||(place1==6)||(place1==9)||(place1==10)||(place1==1)||(place1==2)||(place1==13)||(place1==14)){
			if((i==1)||(i==5)||(i==9)||(i==13)||(i==0)||(i==4)||(i==8)||(i==12)){
				//in these places buttons[place1] can be the left one and the its right one and its right right one are the same with it in a line
				if(((buttons[i].getLabel()).equals((buttons[i+1].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i+2].getLabel())))){
					buttons[i].setLabel(" ");
					buttons[i+1].setLabel(" ");
					buttons[i+2].setLabel(" ");
					//remember not set label by null or the buttons[i].getLabel() will be nothing and be a mistake
					deleted=true;
					continue;
				}
			}//if((place1==1)||(place1==5)||(place1==9)||(place1==13)){
			if((i==2)||(i==6)||(i==10)||(i==14)||(i==3)||(i==7)||(i==11)||(i==15)){
				//in these places buttons[place1] can be the right one and its left one and its left left one can be the same  with it ina line
				if(((buttons[i].getLabel()).equals((buttons[i-1].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i-2].getLabel())))){
					buttons[i].setLabel(" ");
					buttons[i-1].setLabel(" ");
					buttons[i-2].setLabel(" ");
					deleted=true;
					continue;
				}
				}
			//the same in the line ends
		   if((i==4)||(i==5)||(i==6)||(i==7)||(i==8)||(i==9)||(i==10)||(i==11)){
			   //in these places buttons[place1] can be the middle one and the same with the one above it and the one below it
			   if(((buttons[i].getLabel()).equals((buttons[i-4].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i+4].getLabel())))){
					buttons[i].setLabel(" ");
					buttons[i-4].setLabel(" ");
					buttons[i+4].setLabel(" ");
					deleted=true;
					continue;
				}
		   }
		   if((i==0)||(i==1)||(i==2)||(i==3)||(i==4)||(i==5)||(i==6)||(i==7)){
			   //in these places, buttons[place1] can be the uppest one and the the same with the two buttons below it 
			   if(((buttons[i].getLabel()).equals((buttons[i+4].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i+8].getLabel())))){
					buttons[i].setLabel(" ");
					buttons[i+4].setLabel(" ");
					buttons[i+8].setLabel(" ");
					deleted=true;
					continue;
				}
		   }
		  if((i==8)||(i==9)||(i==10)||(i==11)||(i==12)||(i==13)||(i==14)||(i==15)){
			 //in these places, button[place1] can be the botton one and the same with the two buttons above it
			  if(((buttons[i].getLabel()).equals((buttons[i-4].getLabel())))&&((buttons[i].getLabel()).equals((buttons[i-8].getLabel())))){
					buttons[i].setLabel(" ");
					buttons[i-4].setLabel(" ");
					buttons[i-8].setLabel(" ");
					deleted=true;
					continue;
				} 
		  }
		  //the same in a row ends	
		  }
		return deleted;
			}
	  static Boolean onceclickdelete(Button[] buttons,int place0){
		  Boolean deleted0=false;
		  if((place0==5)||(place0==6)||(place0==9)||(place0==10)||(place0==1)||(place0==2)||(place0==13)||(place0==14)){
			   if(((buttons[place0].getLabel()).equals((buttons[place0-1].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0+1].getLabel())))){
				//in a line buttons[place1] and its left and its right are the same
				buttons[place0].setLabel(" ");
				buttons[place0-1].setLabel(" ");
				buttons[place0+1].setLabel(" ");
				deleted0=true;
				return deleted0;//return can end the method
				//when we delete the three labels, there is no need doing the next judge about button[place1] 
			}//buttons[place1] is not in the special places of four edges of the panel then it can be the middle place in a line
			}//if((place1==5)||(place1==6)||(place1==9)||(place1==10)||(place1==1)||(place1==2)||(place1==13)||(place1==14)){
			if((place0==1)||(place0==5)||(place0==9)||(place0==13)||(place0==0)||(place0==4)||(place0==8)||(place0==12)){
				//in these places buttons[place1] can be the left one and the its right one and its right right one are the same with it in a line
				if(((buttons[place0].getLabel()).equals((buttons[place0+1].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0+2].getLabel())))){
					buttons[place0].setLabel(" ");
					buttons[place0+1].setLabel(" ");
					buttons[place0+2].setLabel(" ");
					//remember not set label by null or the buttons[i].getLabel() will be nothing and be a mistake
					deleted0=true;
					return deleted0;
				}
			}//if((place1==1)||(place1==5)||(place1==9)||(place1==13)){
			if((place0==2)||(place0==6)||(place0==10)||(place0==14)||(place0==3)||(place0==7)||(place0==11)||(place0==15)){
				//in these places buttons[place1] can be the right one and its left one and its left left one can be the same  with it in a line
				if(((buttons[place0].getLabel()).equals((buttons[place0-1].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0-2].getLabel())))){
					buttons[place0].setLabel(" ");
					buttons[place0-1].setLabel(" ");
					buttons[place0-2].setLabel(" ");
					deleted0=true;
					return deleted0;
				}
				}
			//the same in the line ends
		   if((place0==4)||(place0==5)||(place0==6)||(place0==7)||(place0==8)||(place0==9)||(place0==10)||(place0==11)){
			   //in these places buttons[place1] can be the middle one and the same with the one above it and the one below it
			   if(((buttons[place0].getLabel()).equals((buttons[place0-4].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0+4].getLabel())))){
					buttons[place0].setLabel(" ");
					buttons[place0-4].setLabel(" ");
					buttons[place0+4].setLabel(" ");
					deleted0=true;
					return deleted0;
				}
		   }
		   if((place0==0)||(place0==1)||(place0==2)||(place0==3)||(place0==4)||(place0==5)||(place0==6)||(place0==7)){
			   //in these places, buttons[place1] can be the uppest one and the the same with the two buttons below it 
			   if(((buttons[place0].getLabel()).equals((buttons[place0+4].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0+8].getLabel())))){
					buttons[place0].setLabel(" ");
					buttons[place0+4].setLabel(" ");
					buttons[place0+8].setLabel(" ");
					deleted0=true;
					return deleted0;
				}
		   }
		  if((place0==8)||(place0==9)||(place0==10)||(place0==11)||(place0==12)||(place0==13)||(place0==14)||(place0==15)){
			 //in these places, button[place1] can be the botton one and the same with the two buttons above it
			  if(((buttons[place0].getLabel()).equals((buttons[place0-4].getLabel())))&&((buttons[place0].getLabel()).equals((buttons[place0-8].getLabel())))){
					buttons[place0].setLabel(" ");
					buttons[place0-4].setLabel(" ");
					buttons[place0-8].setLabel(" ");
					deleted0=true;
					return deleted0;
				} 
		  }
		  //the same in a row ends	
		  return deleted0;
	  }
		
		
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
			  int randomnumber=(int)(Math.random()*4+1);
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
				  public void actionPerformed(ActionEvent ex){
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
	    				  try{ Thread.sleep(1000);
	    				  }catch(InterruptedException e){
	    					  e.printStackTrace();
	    				  }//in this place, we need to stop for 0.8s, or the code runs too fast, you will not see
	    				  //the exchange of the two buttons
	    				  Boolean deleted=twiceclickdelete(buttons,Integer.parseInt(place.get(0)),Integer.parseInt(place.get(1)));
	    				  if(deleted==false){
	    					  buttons[Integer.parseInt(place.get(0))].setLabel(label.get(0));
		    				  buttons[Integer.parseInt(place.get(1))].setLabel(label.get(1));  
	    				  }
	    			
	    				  label.clear();
	    				  place.clear();
	    				 	    			  }
	    			  else{ 
	    				  label.add(buttons[Integer.parseInt(place.get(0))].getLabel());
	    				  Boolean oncedeleted=onceclickdelete(buttons,Integer.parseInt(place.get(0)));
	    				  if(oncedeleted==true){
	    					  place.clear();
	    					  label.clear();
	    				  }
	    			  }
					
				  }
			  });
		  }
		  firstframe.setVisible(true);
		 
		   }
	  
	}
	  

