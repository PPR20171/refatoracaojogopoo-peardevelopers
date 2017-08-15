import greenfoot.*;


public class Urna10 extends UrnaVoto
{

    public Urna10(){
        
        setImage("Urna10.png");
        this.setVotos(10);
        
    }
    
    public void act(){
        
         setImage("Urna0.png");

         MyWorld mW = MyWorld.getInstancia();
        
         if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
             setImage("Urna10.png");
             setImage("Urna10.png");
                
         }
         
    }    
}
