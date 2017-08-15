import greenfoot.*;  

public class Mapa extends Actor {

    public void act() {
        
    }    
 
    public Mapa (){
        
        GreenfootImage img = new GreenfootImage("mapa.png");
        img.setTransparency(0);
        setImage(img);
    
    }
    
     public Mapa (String imagem){
    
         GreenfootImage img = new GreenfootImage(imagem);
        img.setTransparency(0);
        setImage(img);
    
    }

}
