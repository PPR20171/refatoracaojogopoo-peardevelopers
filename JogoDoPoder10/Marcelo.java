import greenfoot.*; 

public class Marcelo extends Coadjuvantes {
    
    public int proximaImg = 3;
    public static final int TAXA_DE_ATUALIZACAO = 9;
    
    public void act() {
    
        setImage(new GreenfootImage("marcelo_"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            proximaImg++;
        }
        
        if(proximaImg > 3){
            proximaImg = 1;
        }
        
    }     
}
