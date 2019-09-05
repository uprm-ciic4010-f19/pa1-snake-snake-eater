package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import Game.GameStates.State;

/**
 * Created by AlexVR on 7/2/2018.
 */
public class Player {

    public int lenght;
    
    public boolean justAte;
    public int score;
    
    private Handler handler;

    public int xCoord;
    public int yCoord;

    public int moveCounter;
    public int movePerTick;

    public String direction;//is your first name one?

    public Player(Handler handler){
        this.handler = handler;
        xCoord = 0;
        yCoord = 0;
        moveCounter = 0;
        direction= "Right";
        justAte = false;
        lenght= 1;
        movePerTick = 5;
        score=0;

    }

    public void tick(){
        moveCounter++;
        if(moveCounter>=movePerTick) {
            checkCollisionAndMove();
            moveCounter=0;
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP) && direction != "Down"){
            direction="Up";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN) && direction != "Up"){
            direction="Down";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT) && direction != "Right"){
            direction="Left";
        }if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_RIGHT) && direction != "Left"){
            direction="Right";
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
        	State.setState(handler.getGame().pauseState);
        }
        
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_EQUALS)) {
        	movePerTick--;
        }
        
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_MINUS)) {
        	movePerTick++;
        }
        
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)) {
        	Tail tail = null;
        	 switch (direction){
             case "Left":
                 if( handler.getWorld().body.isEmpty()){
                     if(this.xCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                         tail = new Tail(this.xCoord+1,this.yCoord,handler);
                     }else{
                         if(this.yCoord!=0){
                             tail = new Tail(this.xCoord,this.yCoord-1,handler);
                         }else{
                             tail =new Tail(this.xCoord,this.yCoord+1,handler);
                         }
                     }
                 }else{
                     if(handler.getWorld().body.getLast().x!=handler.getWorld().GridWidthHeightPixelCount-1){
                         tail=new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler);
                     }else{
                         if(handler.getWorld().body.getLast().y!=0){
                             tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler);
                         }else{
                             tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler);

                         }
                     }

                 }
                 break;
             case "Right":
                 if( handler.getWorld().body.isEmpty()){
                     if(this.xCoord!=0){
                         tail=new Tail(this.xCoord-1,this.yCoord,handler);
                     }else{
                         if(this.yCoord!=0){
                             tail=new Tail(this.xCoord,this.yCoord-1,handler);
                         }else{
                             tail=new Tail(this.xCoord,this.yCoord+1,handler);
                         }
                     }
                 }else{
                     if(handler.getWorld().body.getLast().x!=0){
                         tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                     }else{
                         if(handler.getWorld().body.getLast().y!=0){
                             tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                         }else{
                             tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                         }
                     }

                 }
                 break;
             case "Up":
                 if( handler.getWorld().body.isEmpty()){
                     if(this.yCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                         tail=(new Tail(this.xCoord,this.yCoord+1,handler));
                     }else{
                         if(this.xCoord!=0){
                             tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                         }else{
                             tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                         }
                     }
                 }else{
                     if(handler.getWorld().body.getLast().y!=handler.getWorld().GridWidthHeightPixelCount-1){
                         tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                     }else{
                         if(handler.getWorld().body.getLast().x!=0){
                             tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                         }else{
                             tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                         }
                     }

                 }
                 break;
             case "Down":
                 if( handler.getWorld().body.isEmpty()){
                     if(this.yCoord!=0){
                         tail=(new Tail(this.xCoord,this.yCoord-1,handler));
                     }else{
                         if(this.xCoord!=0){
                             tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                         }else{
                             tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                         } System.out.println("Tu biscochito");
                     }
                 }else{
                     if(handler.getWorld().body.getLast().y!=0){
                         tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                     }else{
                         if(handler.getWorld().body.getLast().x!=0){
                             tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                         }else{
                             tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                         }
                     }

                 }
                 break;
         }
         handler.getWorld().body.addLast(tail);
        }
        
//        for(int i = 0 ; i < handler.getWorld().body.size(); i++) {
        	
        	
//        if(		(handler.getWorld().player.xCoord==handler.getWorld().body.get(i).x)
//        		&& (handler.getWorld().player.yCoord==handler.getWorld().body.get(i).y)) {
//        	State.setState(handler.getGame().gameOverState);
//        }
        	
        	
//        	if(handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y]) {
//        		State.setState(handler.getGame().gameOverState);
//        	}
//        	
        	
//        }

    }

    public void checkCollisionAndMove(){
        handler.getWorld().playerLocation[xCoord][yCoord]=false;
        int x = xCoord;
        int y = yCoord;
        switch (direction){
            case "Left":
                if(xCoord==0){
                    teleport();
                }else{
                    xCoord--;
                }
                break;
            case "Right":
                if(xCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    teleport();
                }else{
                    xCoord++;
                }
                break;
            case "Up":
                if(yCoord==0){
                    teleport();
                }else{
                    yCoord--;
                }
                break;
            case "Down":
                if(yCoord==handler.getWorld().GridWidthHeightPixelCount-1){
                    teleport();
                }else{
                    yCoord++;
                }
                break;
        }
        handler.getWorld().playerLocation[xCoord][yCoord]=true;


        if(handler.getWorld().appleLocation[xCoord][yCoord]){
            Eat();
        }

        if(!handler.getWorld().body.isEmpty()) {
            handler.getWorld().playerLocation[handler.getWorld().body.getLast().x][handler.getWorld().body.getLast().y] = false;
            handler.getWorld().body.removeLast();
            handler.getWorld().body.addFirst(new Tail(x, y,handler));
        }

    }

    public void render(Graphics g,Boolean[][] playeLocation){
        Random r = new Random();
        for (int i = 0; i < handler.getWorld().GridWidthHeightPixelCount; i++) {
            for (int j = 0; j < handler.getWorld().GridWidthHeightPixelCount; j++) {
                

                if(playeLocation[i][j]){
                	g.setColor(Color.GREEN);
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                }
                
                if(handler.getWorld().appleLocation[i][j]){
                	g.setColor(handler.getWorld().apple.appleColor);
                    g.fillRect((i*handler.getWorld().GridPixelsize),
                            (j*handler.getWorld().GridPixelsize),
                            handler.getWorld().GridPixelsize,
                            handler.getWorld().GridPixelsize);
                }

            }
        }
        
        //Score UI
        g.setColor(Color.BLACK);
        g.fillRect(0, 780, 1000, 50);
    
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 800);

    }

    public void Eat(){
    	
    	if(handler.getWorld().apple.isGood) {
    		

        	
        	//update Snake speed
        	movePerTick--;
        	
        	//Prevent bugs
        	if(movePerTick<2) {movePerTick=2;}
        	
        	//add score
        	//Student ID = 5. Additive = 6.
        	score = score+6;
        	
        	
            lenght++;
            Tail tail= null;
            handler.getWorld().appleLocation[xCoord][yCoord]=false;
            handler.getWorld().appleOnBoard=false;
            switch (direction){
                case "Left":
                    if( handler.getWorld().body.isEmpty()){
                        if(this.xCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                            tail = new Tail(this.xCoord+1,this.yCoord,handler);
                        }else{
                            if(this.yCoord!=0){
                                tail = new Tail(this.xCoord,this.yCoord-1,handler);
                            }else{
                                tail =new Tail(this.xCoord,this.yCoord+1,handler);
                            }
                        }
                    }else{
                        if(handler.getWorld().body.getLast().x!=handler.getWorld().GridWidthHeightPixelCount-1){
                            tail=new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler);
                        }else{
                            if(handler.getWorld().body.getLast().y!=0){
                                tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler);
                            }else{
                                tail=new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler);

                            }
                        }

                    }
                    break;
                case "Right":
                    if( handler.getWorld().body.isEmpty()){
                        if(this.xCoord!=0){
                            tail=new Tail(this.xCoord-1,this.yCoord,handler);
                        }else{
                            if(this.yCoord!=0){
                                tail=new Tail(this.xCoord,this.yCoord-1,handler);
                            }else{
                                tail=new Tail(this.xCoord,this.yCoord+1,handler);
                            }
                        }
                    }else{
                        if(handler.getWorld().body.getLast().x!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                        }else{
                            if(handler.getWorld().body.getLast().y!=0){
                                tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                            }else{
                                tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                            }
                        }

                    }
                    break;
                case "Up":
                    if( handler.getWorld().body.isEmpty()){
                        if(this.yCoord!=handler.getWorld().GridWidthHeightPixelCount-1){
                            tail=(new Tail(this.xCoord,this.yCoord+1,handler));
                        }else{
                            if(this.xCoord!=0){
                                tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                            }else{
                                tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                            }
                        }
                    }else{
                        if(handler.getWorld().body.getLast().y!=handler.getWorld().GridWidthHeightPixelCount-1){
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord+1,handler));
                        }else{
                            if(handler.getWorld().body.getLast().x!=0){
                                tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                            }else{
                                tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                            }
                        }

                    }
                    break;
                case "Down":
                    if( handler.getWorld().body.isEmpty()){
                        if(this.yCoord!=0){
                            tail=(new Tail(this.xCoord,this.yCoord-1,handler));
                        }else{
                            if(this.xCoord!=0){
                                tail=(new Tail(this.xCoord-1,this.yCoord,handler));
                            }else{
                                tail=(new Tail(this.xCoord+1,this.yCoord,handler));
                            } System.out.println("Tu biscochito");
                        }
                    }else{
                        if(handler.getWorld().body.getLast().y!=0){
                            tail=(new Tail(handler.getWorld().body.getLast().x,this.yCoord-1,handler));
                        }else{
                            if(handler.getWorld().body.getLast().x!=0){
                                tail=(new Tail(handler.getWorld().body.getLast().x-1,this.yCoord,handler));
                            }else{
                                tail=(new Tail(handler.getWorld().body.getLast().x+1,this.yCoord,handler));
                            }
                        }

                    }
                    break;
            }
            handler.getWorld().body.addLast(tail);
            handler.getWorld().playerLocation[tail.x][tail.y] = true;
    		
    	}else {
    		
    		handler.getWorld().appleLocation[xCoord][yCoord]=false;
            handler.getWorld().appleOnBoard=false;
            score=score-6;
    		
        }
    }

    public void teleport(){
    	
    	switch(direction) {
    	
    	case "Up":
    		yCoord=handler.getWorld().GridWidthHeightPixelCount-1;
    		break;
    	case "Down":
    		yCoord=0;
    		break;
    	case "Left":
    		xCoord=handler.getWorld().GridWidthHeightPixelCount-1;
    		break;
    	case "Right":
    		xCoord=0;
    	}
    	
    }

    public boolean isJustAte() {
        return justAte;
    }

    public void setJustAte(boolean justAte) {
        this.justAte = justAte;
    }
}
