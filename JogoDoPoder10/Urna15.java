import greenfoot.*;


public class Urna15 extends UrnaVoto
{
    
    public Urna15(){
        
        setImage("Urna15.png");
        this.setVotos(15);
    }
    
    public void act() {
        
        setImage("Urna0.png");

        MyWorld mW = MyWorld.getInstancia();
        
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            
            setImage("Urna15.png");
            setImage("Urna15.png");
                
        }
                       
    }    
}
