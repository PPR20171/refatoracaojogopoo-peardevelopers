import greenfoot.*;  

public class SupremoMisStar extends Poderes {
    
    public int proximaImg = 2;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    
    public SupremoMisStar(){
        
       setImage(new GreenfootImage("poder_12.png"));
    
    }
    
    public void act() {
     
        setImage(new GreenfootImage("poder_1"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            proximaImg++;
        
        }
        
        if(proximaImg > 2){
        
            proximaImg = 0;
        
        }
    }        
    
}