package PCVersion;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;

public class BackMusic extends Thread{
    
        	
        		public void run(){
        	
        	try{
        		
        		URL musicURL=this.getClass().getResource("backmusic.wav");
        	
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
