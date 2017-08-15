import greenfoot.*;  
import java.util.List;

public abstract class Jogador extends Actor {
    
    public Integer votos = 0;
    
    public int x;//variaveis utilizadas para guardar posiçao de coordenada X
    public int y;//variaveis utilizadas para guardar posiçao de coordenada Y
    
    protected final Integer distancia = 2;//
    int cicloAtual = 0;//vriaveo usada para armazenamento e utilizaçao em temporizaçao
    
    protected boolean viradoParaEsquerda;
    protected boolean viradoParaDireita;
    protected String direita;
    protected String esquerda;
    protected String cima;
    protected String baixo;
    
    protected int ticVarX;
    protected int ticVarYPoder1;
    protected int ticVarYPoder2;
    protected int ticVarYPoder3;    
    
    protected boolean vida = true;    
    
    MyWorld mW = MyWorld.getInstancia();
    
    CartaButterEvil carta = new CartaButterEvil();;
    SupremoButterEvil supremoButter = new SupremoButterEvil();
    BancadaButterEvil bancadaButter = new BancadaButterEvil();
    
    PedaladaMisStar pedalada = new PedaladaMisStar();
    SupremoMisStar supremoMisStar = new SupremoMisStar();
    BancadaMisStar bancadaMisStar = new BancadaMisStar();
    
    public boolean p1;
    public boolean p2;
    public boolean p3;
    
    public boolean pedaladaContra;
    public boolean cartaContra;
    public boolean supremoContra;
    public boolean bancadaContra;
    
    Tick t1 = new Tick();
    Tick t2 = new Tick();
    Tick t3 = new Tick();    
    
    public boolean fim = false;
    private int militAleat = 0;

    protected int S1;
    protected int S2;
    
    public void mover(){
        //armagedom();
        verifiPoderes();
        
        if(this.vida == true){
        
            if(Greenfoot.isKeyDown(direita)) {
            
                List mapa1 = mW.getObjectsAt(getX()+distancia, getY(), Mapa.class);
        
                if (viradoParaEsquerda == true) {
            
                    getImage().mirrorHorizontally();     
                    viradoParaEsquerda = false;
        
                }
        
                if(!mapa1.isEmpty()&& !outroJogador(getX()+distancia, getY())){
            
                    viradoParaDireita = true;        
                    setLocation(getX()+distancia, getY());
                    pegaVotos();
        
                }
            }
           
            if (Greenfoot.isKeyDown(esquerda)){
            
                List mapa1 = mW.getObjectsAt(getX()-distancia, getY(), Mapa.class);
            
                if(viradoParaDireita == true){
                
                    getImage().mirrorHorizontally();      
                    viradoParaDireita = false;
            
                }
        
                if(!mapa1.isEmpty() && !outroJogador(getX()-distancia, getY())){
            
                    viradoParaEsquerda = true;
                    setLocation(getX()-distancia, getY());
                    pegaVotos();
        
                }
        
            }    
    
            if (Greenfoot.isKeyDown(cima)){
        
                List mapa1 = mW.getObjectsAt(getX(), getY()-distancia, Mapa.class);
        
                if(!mapa1.isEmpty()&& !outroJogador(getX()-distancia, getY())){
            
                    setLocation(getX(), getY()-distancia);
                    pegaVotos();
            
                }
        
            }
    
            if (Greenfoot.isKeyDown(baixo) && !outroJogador(getX()+distancia, getY())){
            
                List mapa1 = mW.getObjectsAt(getX(), getY()+distancia, Mapa.class);
             
                if(!mapa1.isEmpty()){
                
                    setLocation(getX(), getY()+distancia);
                    pegaVotos();
            
                }
            
            }
       
        }
    
    }
    
    public void pegaVotos(){
        
        UrnaVoto urna = (UrnaVoto)getOneObjectAtOffset(0,0,UrnaVoto.class);
        
        if(urna != null){
            
            this.votos += urna.getVotos();
            Greenfoot.playSound("somUrna.mp3");
            removeTouching(UrnaVoto.class);
            fim();
            
        }
            
    }
    
    public void verifiPoderes(){

        if((this.getVotos() >= 10) && (!p1)){
            mW.addObject(t1, ticVarX, ticVarYPoder1);           
            p1 = true;
            
        }
        
        if((this.getVotos() < 10) && (p1)){
            
            mW.removeObject(t1); 
            p1 = false;
        
        }
        
        if((this.getVotos() >= 30) && (!p2)){
            
            mW.addObject(t2, ticVarX, ticVarYPoder2);           
            p2 = true;
            
        }
        
        if((this.getVotos() < 30) && (p2)){
        
            mW.removeObject(t2);
            p2 = false;

        }
        
        if((this.getVotos() >= 50) && (!p3)){
            
            mW.addObject(t3, ticVarX, ticVarYPoder3);           
            p3 = true;
            
        }
           
        if((this.getVotos() < 50) && (p3)){
            
            mW.removeObject(t3);
            p3 = false;
        
        }        
    
    }
    
    public Integer getVotos(){
        
        return this.votos;
    
    }

    public void setVotos(int votos){
        
        this.votos = votos;
    
    }
    
    public void usaPoder(Poderes p){
        
        x = this.getX();
        y = this.getY();
                    
        mW.removeObject(p);
        mW.addObject(p, x,y);
           
    }
    
     public boolean outroJogador(int x, int y){
        
         List<Jogador> personagem = mW.getObjectsAt(x, y, Jogador.class);
        
        
        for (int index = 0; index < personagem.size(); index++){
            
            if(!this.equals(personagem.get(index))){
            
                return true;
            
            }
        
        }
        
        return false;
    }
       
        public boolean fim(){ //add a tela final da vitoria
                
         if (getVotos() >= 342){
                
            if (this.getClass() == MisStar.class){

                mW.addObject(new VenceMisStar(),486,310);

            } else {
                
                mW.addObject(new VenceButterEvil(),486,310);
                
           }

           this.fim = true;
            
        }
        
        return this.fim;
    
    }
     
   
    
    
}
