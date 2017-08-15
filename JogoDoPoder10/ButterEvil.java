import greenfoot.*;
import java.util.List;

public class ButterEvil extends Jogador{

    BigBicudo cunha = new BigBicudo();
    private static ButterEvil instancia;

    private boolean recupVida = false;//variavel indicativa do poder de recuperaçao de vida
    
    private ButterEvil(){
        
        viradoParaEsquerda = true;
        viradoParaDireita = false;
        
        direita = "right";
        esquerda = "left";
        cima = "up";
        baixo = "down";
        
        ticVarX = 775;
        ticVarYPoder1 = 59;
        ticVarYPoder2 = 73;
        ticVarYPoder3 = 86;
        
        S1 = 923;
        S2 = 137;
                    
    }
    
    public static ButterEvil getInstancia(){
        if(instancia == null){
            instancia = new ButterEvil();
        }
        return instancia;
    }
    
    public void act() {
        
        cicloAtual++;
        
        if(cicloAtual >= 1000){//condiçao para desacumular o contador de tempo/ciclos
        
            cicloAtual = 0;
        
        }
                
        //metodo para paralisar movimento do oponente
        if (this.isTouching(PedaladaMisStar.class) ||this.isTouching(SupremoMisStar.class) || this.isTouching(BancadaMisStar.class)) {
            
        this.vida = false;//seta vairavel "vida" para paralisar movimento
            cicloAtual = 0;
            
            this.pedaladaContra = (this.isTouching(PedaladaMisStar.class));
            this.supremoContra = (this.isTouching(SupremoMisStar.class));
            this.bancadaContra = (this.isTouching(BancadaMisStar.class));            
            
            removeTouching(PedaladaMisStar.class);
            removeTouching(SupremoMisStar.class);
            removeTouching(BancadaMisStar.class);            
            
        }

        
        
        //metodo para liberar movimento... temporizado pelo ciclo (conforme o poder) e pelo booleano "xxxContra"
        if (((this.cicloAtual > 200) && (pedaladaContra)) || ((this.cicloAtual > 400) && (supremoContra)) || ((this.cicloAtual > 600) && (bancadaContra))) {
            
            this.vida = true;
            pedaladaContra = false;
            supremoContra = false;
            bancadaContra = false;
        
        }
        
        mover();
        
        if (Greenfoot.isKeyDown("p")){
        
            acionaRecVida();
        
        }
        
        recolheRecVida();
        //verifiPoderes();
        
        if (Greenfoot.isKeyDown("8")&& (p1)){
        
            usaPoder(carta);
            cicloAtual = 0;
            
        }

        if (Greenfoot.isKeyDown("9") && (p2)){
            
            usaPoder(supremoButter);        
            cicloAtual = 0;
        
        }
        
        if (Greenfoot.isKeyDown("0")&& (p3)){
            
            usaPoder(bancadaButter);
            cicloAtual = 0;
            
        }
        
       switch (cicloAtual){//temporizador de permanencia dos poderes no tabuleiro
           
           case 300:
           mW.removeObject(carta);
            
           case 500:
           mW.removeObject(supremoButter);
           
           case 700:
           mW.removeObject(bancadaButter);
            
       }
               
    }
    
    public void acionaRecVida(){
    
        if (recupVida){//acionar o poder de recuperaçao de vida

            Greenfoot.playSound("coracao.mp3");
            getWorld().removeObject(cunha);
            recupVida = false;
            this.vida = true;
        
        }
    
    }
        
    public void recolheRecVida(){
    
        if(isTouching(BigBicudo.class) && (!recupVida)) {//recolher o poder de recuperaçao de vida
        
            Greenfoot.playSound("coracao.mp3");
            removeTouching(BigBicudo.class);
            mW.addObject(cunha, 833, 61);
            recupVida = true;
        
        }

    }
    
}
