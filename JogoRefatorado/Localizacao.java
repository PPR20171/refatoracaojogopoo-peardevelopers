/*
 * Estado extrinseco da Urna que representa sua localização no mapa
 */
package flyweight;

/**
 *
 * @author Usuário
 */
public class Localizacao {
 
    private int x;
    private int y;
    
    public Localizacao(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
