import greenfoot.*;

public class BancadaButterEvil extends Poderes {
    public int proximaImg = 3;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    
    
    public BancadaButterEvil(){

        setImage(new GreenfootImage("poder_3.png"));

    }
    
    
    public void act() {
     
        setImage(new GreenfootImage("poder_"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            proximaImg++;
        
        }
        
        if(proximaImg > 3){
        
            proximaImg = 0;
        
        }
    }
    
    
    
}
