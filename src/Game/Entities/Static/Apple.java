package Game.Entities.Static;

import java.awt.Color;

import Main.Handler;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Apple {

    private Handler handler;
    
    public boolean isGood;
    public int goodCounter;
    
    public Color appleColor;

    public int xCoord;
    public int yCoord;

    public Apple(Handler handler,int x, int y){
        this.handler=handler;
        this.xCoord=x;
        this.yCoord=y;
        goodCounter=0;
        isGood=true;
        appleColor=Color.RED;
    }
    
    public void tick() {
    	
    	goodCounter++;
    	if(goodCounter>=500) {
    		isGood=false;
    	}
    	
    	if(!isGood)
    		appleColor=Color.GRAY;
    	
    }


}
