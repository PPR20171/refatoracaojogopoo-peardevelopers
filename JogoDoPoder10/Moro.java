import greenfoot.*;
import java.util.List;    

public class Moro extends Coadjuvantes {
    
    public int proximaImg = 3;
    public static final int TAXA_DE_ATUALIZACAO = 10;
    private int direcao = 0; // Inicializa o personagem movendo - se para direita.
    private boolean viradoParaEsquerda = false;
    private boolean viradoParaDireita = true;
    
    
    
    public Moro(){
        //Greenfoot.playSound("sirene.mp3");       
    }
    
    public void act() {
    
        setImage(new GreenfootImage("moro_"+proximaImg+".png"));
        MyWorld mW = MyWorld.getInstancia();
            
        if (mW.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            proximaImg++;
        }
        
        if(proximaImg > 3){
            proximaImg = 1;
        }
        
        //if (mW.cicloAtual() % 30 == 0){
           // descontaJogador();
        //}
        
        if(this.isTouching(Jogador.class)){
            descontaJogador();
        }
        
        
        if(Greenfoot.getRandomNumber(100) < 5){
            direcao = Greenfoot.getRandomNumber(4); // Gera a direcao a ser seguida
        }
        
        mover(direcao);
        
    }
    
    public void mover(int direcao){
        int distancia = Greenfoot.getRandomNumber(10); // define a distancia a ser percorrida.
        
        
        if(direcao == 0){ // move para direita.
            List<Mapa> mapa = getWorld().getObjectsAt(getX()+ distancia, getY(), Mapa.class);
            
            if (viradoParaEsquerda == true) {
                
                getImage().mirrorHorizontally();     
                viradoParaEsquerda = false;
            
            }
            
            if(!mapa.isEmpty()){ // testa se esta dentro do mapa.
            setLocation(getX()+ distancia, getY());
            viradoParaDireita = true;
           }
        }
        
        if(direcao == 1){ //move para esquerda.
            List<Mapa> mapa = getWorld().getObjectsAt(getX()- distancia, getY(), Mapa.class);
            
            if(viradoParaDireita == true){
                
                getImage().mirrorHorizontally();      
                viradoParaDireita = false;
            
            }
            
            if(!mapa.isEmpty()){
                setLocation(getX() - distancia, getY());
                viradoParaEsquerda = true;
            }
        }
        
        if(direcao == 2){ //move para cima.
            List<Mapa> mapa = getWorld().getObjectsAt(getX(),getY() - distancia, Mapa.class);
            if(!mapa.isEmpty()){
                setLocation(getX(), getY()-distancia);
            }
        }
        
        if(direcao == 3){ //move para baixo.
            List<Mapa> mapa = getWorld().getObjectsAt(getX(),getY()+ distancia, Mapa.class);
            if(!mapa.isEmpty()){
                setLocation(getX(), getY()+ distancia);
            }
        }
        
        limpar();
     }
    
    
    public void descontaJogador(){ // Ao encostar em qualquer jogador desconta -se votos.
        Jogador jogador = (Jogador)getOneIntersectingObject(Jogador.class);
        
        if((jogador != null) && (jogador.getVotos() >=1)){
            jogador.setVotos(jogador.getVotos()-1);
            Greenfoot.playSound("sirene.mp3");        
        }
    }
    
    public void limpar(){ // Remove do jogo urnas e poderes de ajuda
        UrnaVoto urna = (UrnaVoto)getOneIntersectingObject(UrnaVoto.class);
        PoderDeAjuda poder = (PoderDeAjuda)getOneIntersectingObject(PoderDeAjuda.class);
        
        if(urna != null){removeTouching(UrnaVoto.class);}
        if(poder != null){removeTouching(PoderDeAjuda.class);}
    }
    /*
        private void lavaJato(){
     
        Actor obj = getOneIntersectingObject(Jogador.class);
        
            if (obj != null){
            
        
            
            }
        
    }*/
}
