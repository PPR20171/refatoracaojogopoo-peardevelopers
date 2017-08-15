import greenfoot.*;
import java.util.List;

public abstract class UrnaVoto extends Actor {
    
    private MyWorld mundo = MyWorld.getInstancia();
    public Integer votos;
    protected static final int TAXA_DE_ATUALIZACAO = 2;
    

    public void act() {
        
    } 
    
    public void desaparecer(){
    
        mundo.removeObject(this);
    
    }
    
    public Integer getVotos(){
        
        return this.votos;
    
    }
    
    
    public void setVotos(Integer votos){
        
        this.votos = votos;
    
    }
    
    public boolean podeAdicionar(int x, int y){
        
        List mapa = getObjectsAtOffset(x, y, Mapa.class);
        
        if(mapa.isEmpty()){
            return false;
        }else{
            return true;
        }
        
    }    
}
