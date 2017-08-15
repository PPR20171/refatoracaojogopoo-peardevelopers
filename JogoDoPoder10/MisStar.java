import greenfoot.*;
import java.util.List;

public class MisStar extends Jogador{
    
    DNPower tentaculula = new DNPower();
    private static MisStar instancia;

    public boolean recupVida = false;//variavel indicativa do poder de recuperaçao de vida
    
    private boolean pedaladaTic;
    private boolean supremoTic;
    private boolean bancadaTic;
    
    private MisStar(){
        
        viradoParaEsquerda = false;
        viradoParaDireita = true;
        
        direita = "d";
        esquerda = "a";
        cima = "w";
        baixo = "s";
        
        ticVarX = 233;
        ticVarYPoder1 = 52;
        ticVarYPoder2 = 67;
        ticVarYPoder3 = 82;
        
        S1 = 50;
        S2 = 135;
        
    }
    
    public static MisStar getInstancia(){
            if(instancia == null){
                instancia = new MisStar();
            }
            return instancia;
    }
    
    public void act() {
        
       cicloAtual++;
        
        // bloco para paralisar o proprio personagem caso esteja em contato com alguma arma inimiga        
        if (this.isTouching(CartaButterEvil.class) ||this.isTouching(SupremoButterEvil.class) || this.isTouching(BancadaButterEvil.class)) {
           
            this.vida = false;
            cicloAtual = 0;
            
            this.cartaContra = (this.isTouching(CartaButterEvil.class));
            this.supremoContra = (this.isTouching(SupremoButterEvil.class));
            this.bancadaContra = (this.isTouching(BancadaButterEvil.class));            
            
            removeTouching(CartaButterEvil.class);
            removeTouching(SupremoButterEvil.class);
            removeTouching(BancadaButterEvil.class);            
            
        }
        
        //bloco para liberar  o proprio personagem, conforme a passagem do ciclo        
        if (((this.cicloAtual > 200) && (cartaContra)) || ((this.cicloAtual > 400) && (supremoContra)) || ((this.cicloAtual > 800) && (bancadaContra))) {
            
            this.vida = true;
            cartaContra = false;
            supremoContra = false;
            bancadaContra = false;
        
        }      
        
        mover();
        
        if (Greenfoot.isKeyDown("q")){
        
            acionaRecVida();
        
        }
 
        recolheRecVida();
        
        if (Greenfoot.isKeyDown("1")&& (p1)){
            
            usaPoder(pedalada);
            cicloAtual = 0;                            
        
        }
        
        if (Greenfoot.isKeyDown("2")&& (p2)){
            
            usaPoder(supremoMisStar);
            cicloAtual = 0;
            
        }

        if (Greenfoot.isKeyDown("3")&& (p3)){
            
            usaPoder(bancadaMisStar);
            cicloAtual = 0;
            
        }   

        switch (cicloAtual){//temporizador de permanencia dos poderes no tabuleiro
           
            case 300:
            mW.removeObject(pedalada);
            
            case 500:
            mW.removeObject(supremoMisStar);
           
            case 700:
            mW.removeObject(bancadaMisStar);
            
        }        
        
    }    
    
    public void acionaRecVida(){
        
        if (recupVida){//metodo para acionar o poder de recuperacao de vida
    
            Greenfoot.playSound("lulala.mp3");
            mW.removeObject(tentaculula);
            recupVida = false;
            this.vida = true;
            
        }
        
    }
     
    public void recolheRecVida(){
        
        if(isTouching(DNPower.class) && (!recupVida)) {//
            
            Greenfoot.playSound("lulala.mp3");
            removeTouching(DNPower.class);
            mW.addObject(tentaculula, 132, 63);
            recupVida = true;
            
        }
        
    }

}
