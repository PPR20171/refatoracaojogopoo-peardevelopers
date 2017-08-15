import greenfoot.*;  

public class SupremoButterEvil extends Poderes {
    
    public int proximaImg = 2;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    
    public SupremoButterEvil(){
    
        setImage (new GreenfootImage("poder_2.png"));
        
    }
    
    public void act() {
     
        setImage(new GreenfootImage("poder_"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            proximaImg++;
        
        }
        
        if(proximaImg > 2){
        
            proximaImg = 0;
        
        }
    }    
}
