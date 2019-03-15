package EL;

//2017.04.25 BeibeiZhang
//a class to make sure that there are no more than three buttons whose labels are the same
//use this class each time before the delet
import java.awt.Button;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NewCheck {
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
	 static void findSameAround(int place,JButton[] buttons,ArrayList<Integer> places){
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
			        	             findSameAround(place+1,buttons,places);
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
					        	             findSameAround(place-1,buttons,places);
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
					        	             findSameAround(place-8,buttons,places);
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
					        	             findSameAround(place+8,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				            }
		            	 
			 }
	//use recursion function to constantly find the next same button
	//GOOD AND SIMPLE
	//it is the best way
   public static void myCheck(JButton[] buttons,ImageIcon[] icons){
      	  int index=0;
      	  ArrayList<Integer> sameLabelPlace=new ArrayList<Integer>();
      	  sameLabelPlace.clear();
      	  for(index=0;index<=63;index++){
      		sameLabelPlace.clear();
      		if((buttons[index].getIcon()==null)){
      			//use "==" not ".equals()"
      		continue;	
      		}
      		else{
      		  findSameAround(index,buttons,sameLabelPlace);	
      			}
      		int length=sameLabelPlace.size();
      		length=sameLabelPlace.size();
      		if(length>=3){
      			for(int n=0;n<=length-1;n++){
      				buttons[sameLabelPlace.get(n)].setIcon(null);
      			}
      		}
      		else{
            		}
      	  }
      	  Boolean end=true;
      	for(index=0;index<=63;index++){
      		if(buttons[index].getIcon()==null){
      			end=false;
      			buttons[index].setIcon(icons[((int)(Math.random()*5+1))-1]);
         		    
      		}
      	}
      	if(end){
      		System.out.println("ok");
      	}
      	else{
      	
             	myCheck(buttons,icons);	
      		}
      	}
     }  
        


