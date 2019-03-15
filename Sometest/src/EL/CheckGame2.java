package EL;

//2017.05.07 BeibeiZhang
//to check Game2 on the basis of NewCheck
//a class to make sure that there are no more than three buttons whose labels are the same
//use this class each time before the deleting
import java.awt.Button;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CheckGame2{
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
	 static void find_Same_Around(int place,JButton[] buttons,ArrayList<Integer> places){
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
		                         Boolean existed1=false;
		                         for(int i=0;i<=(places.size()-1);i++){
		                        	
		        	              if(places.get(i)==(place+1)){
		        	            	  existed1=true;
		        	            	  break;
		        	              }
		           	  }
		                         if(existed1==false){
		                        	 places.add(place+1);
		                        	
			        	             find_Same_Around(place+1,buttons,places);
		                         }
		                         else{
		                        	 
		                         }
		                         }
		              }
		       	   if(isLeftBound(place)==false){
				                if(buttons[place].getIcon().equals(buttons[place-1].getIcon())){
				                	   Boolean existed2=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				                        	
				        	              if(places.get(i)==(place-1)){
				        	            	  existed2=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed2==false){
				                        	 places.add(place-1);
				                       
					        	             find_Same_Around(place-1,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				              }
		           if(isUpBound(place)==false){
				                 if(buttons[place].getIcon().equals(buttons[place-8].getIcon())){
				                	   Boolean existed3=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				                        	
				        	              if(places.get(i)==(place-8)){
				        	            	  existed3=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed3==false){
				                        	 places.add(place-8);
				                        
					        	             find_Same_Around(place-8,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				             }
			       if(isDownBound(place)==false){
				                if(buttons[place].getIcon().equals(buttons[place+8].getIcon())){
				                	   Boolean existed4=false;
				                         for(int i=0;i<=(places.size()-1);i++){
				                        	 
				        	              if(places.get(i)==(place+8)){
				        	            	  existed4=true;
				        	            	  break;
				        	              }
				           	  }
				                         if(existed4==false){
				                        	 places.add(place+8);
				                        	
					        	             find_Same_Around(place+8,buttons,places);
				                         }
				                         else{
				                        	 
				                         }
				                         }
				            }
		            	 
			 }
	//use recursion function to constantly find the next same button
	//GOOD AND SIMPLE
	//it is the best way
    static Boolean Mycheck2(JButton[] buttons){
    	  Boolean candelete=false;
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
      		  find_Same_Around(index,buttons,sameLabelPlace);	
      			}
      		int length=sameLabelPlace.size();
      		if(length>=3){
      			 candelete=true;
      		
      			 return candelete;
      		}
      		else{
            		}
      	  }
      	return candelete;
      	
     }  }
        



