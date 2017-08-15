import greenfoot.*;  
public class CartaButterEvil extends Poderes
{
   
    
    public int proximaImg = 1;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    
    public CartaButterEvil(){
        
        setImage(new GreenfootImage("poder_1.png"));
    
    }
    
    public void act() {
     
        setImage(new GreenfootImage("poder_"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            proximaImg++;
        
        }
        
        if(proximaImg > 1){
        
            proximaImg = 0;
        
        }
    }        
    
}
