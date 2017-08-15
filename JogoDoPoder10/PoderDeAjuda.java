import greenfoot.*; 

public class PoderDeAjuda extends Actor {
    
    public int proximaImg = 3;
    public static final int TAXA_DE_ATUALIZACAO = 6;
    private String tipo;
    
    public void act() {
     
        setImage(new GreenfootImage(tipo+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            proximaImg++;
        
        }
        
        if(proximaImg > 3){
        
            proximaImg = 1;
        
        }
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }   
}
