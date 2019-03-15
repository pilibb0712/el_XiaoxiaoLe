package PCVersion;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class BackMusic extends Thread{
    
        	
        		public void run(){
        	
        	try{
        		File backMusic=new File("backmusic.wav");
        		URI musicURI=backMusic.toURI();
        		URL musicURL=musicURI.toURL();
        	
        		AudioClip backMusicPlayer=Applet.newAudioClip(musicURL);

        		try{
        			Thread.sleep(800);
        		}catch(InterruptedException e){
        			e.printStackTrace();
        		}
        		backMusicPlayer.loop();
  
        	
        	}catch(Exception ex){
        		ex.printStackTrace();
        		
        	}
        	
     
        }
}
