import greenfoot.*;


public class Urna5 extends UrnaVoto
{
    
    public Urna5(){
        
        setImage("Urna5.png");
        this.setVotos(5);
    }
        
    public void act() {
       
           setImage("Urna0.png");

           MyWorld mW = MyWorld.getInstancia();
        
           if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
                setImage("Urna5.png");
                setImage("Urna5.png");
                
           }
                   
    }       
}
