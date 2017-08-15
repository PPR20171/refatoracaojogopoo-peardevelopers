import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author (Carlos, Reynaldo e Wellington) 
 * @version (maio_2017)
 */

public class MyWorld extends World {
   
    GreenfootSound introSom = new GreenfootSound("Intro2.mp3"); 
    
    public GreenfootSound jogoSom = new GreenfootSound("temaJogo2.mp3"); 
    
    TelaInicial telaInicial;                                   

    Jogar jogar;
    MenuInstrucoes instrucoesMenu;
    Voltar btnVoltar;
    Sobre btnSobre;
    MenuSobre sobreMenu;
    
    Instrucoes instrucoes;
          
    LabelOfMisStar labelMisStar= new LabelOfMisStar();//declarando e instanciando variavel para compor o cenário a partir da classe misStar
   
    Jogador P1 = MisStar.getInstancia();//declarando e instanciando personagem a partir da classe Misstar
    
    LabelOfButterEvil labelButterEvil= new LabelOfButterEvil();//declarando variavel para compor o cenário a partir da classe ButterEvil
   
    Jogador P2 = ButterEvil.getInstancia();// = new ButterEvil();//declarando e instanciando personagem a partir da classe Butterevil
    
    Tuca coadj_1 = new Tuca();//instanciando objeto para compor o cenário
    Juiz coadj_2 = new Juiz();//instanciando objeto para compor o cenário
    Bolsomito coadj_3 = new Bolsomito();//instanciando objeto para compor o cenário       
    Japa coadj_4 = new Japa();//instanciando objeto para compor o cenário       
    Renan coadj_5 = new Renan();//instanciando objeto para compor o cenário       
    Mari coadj_6 = new Mari();//instanciando objeto para compor o cenário    
    Cervero coadj_7 = new Cervero();//instanciando objeto para compor o cenário   
    
    NomeJogo nomeDoJogo = new NomeJogo();//instanciando variavel para compor o cenário
    NomeMisStar nome1 = new NomeMisStar();
    NomeButterEvil nome2 = new NomeButterEvil();
   
    Moro moro = new Moro();
    
    ContornoPoder contornoPoder = new ContornoPoder();
    ContornoPoder contornoPoder2 = new ContornoPoder();
    
    PainelPoderesMisStar painelPoderMisStar = new PainelPoderesMisStar();//instanciando objeto para compor o cenário   
    PainelPoderesButterEvil painelPoderButterEvil = new PainelPoderesButterEvil();//instanciando objeto para compor o cenário   

    List<Actor> urnas = new ArrayList<>(); // Lista de urnas.
   
    UrnaVoto urna1 = new Urna5();
    UrnaVoto urna2 = new Urna5();
    UrnaVoto urna3 = new Urna5();    // Instanciando os três tipos de urna.
    UrnaVoto urna4 = new Urna10();
    UrnaVoto urna5= new Urna10();
    UrnaVoto urna6 = new Urna15();   

    List<Actor> poderAjuda = new ArrayList<>();
                                       
    PoderDeAjuda poder1 = new DNPower();
    PoderDeAjuda poder2 = new BigBicudo();
   
    public boolean fimJogo1 = false;
    public boolean fimJogo2 = false;
   
    public int cicloAtual = 0;
   
    private int score = 0;
    
    private static MyWorld instancia;
    
   private MyWorld(){    
        
        super(970, 620, 1);//definindo o tamanho do tabuleiro
        
        GreenfootImage cenario = new GreenfootImage("mundoBrisal.png");//instanciando o objeto-cenário e passando a imagem "MundoBrisal" como argumento
        setBackground(cenario);//passando o objeto "cenário" como argumento para setar o fundo-tabuleiro

        poderAjuda.add(poder1);
        poderAjuda.add(poder2);        
        
        iniciar();
        
        urnas.add(urna1); //Adicionando urnas na lista.
        urnas.add(urna2);
        urnas.add(urna4);
        urnas.add(urna3);
        urnas.add(urna2);
        urnas.add(urna5);
        urnas.add(urna6);        
        
   }
   
   public static MyWorld getInstancia(){
       if(instancia == null){
           instancia = new MyWorld();
        }
        return instancia;
    }
     public void instrucoes(){
          
        removeObject(telaInicial);
        removeObject(jogar);
        removeObject(instrucoes);
        removeObject(btnSobre);
         
         instrucoesMenu = new MenuInstrucoes();
         btnVoltar = new Voltar();
         addObject(instrucoesMenu, 486,310);
         addObject(btnVoltar, 467, 83);
        }
   public void iniciar(){
         
        removeObject(instrucoesMenu);
        removeObject(sobreMenu);
        removeObject(btnVoltar);
        
        telaInicial = new TelaInicial();
        addObject(telaInicial, 486, 310);
        
        jogar = new Jogar();
        addObject(jogar, 104, 186);
        
        instrucoes = new Instrucoes();
       
        addObject(instrucoes, 106, 289);
        btnSobre = new Sobre();
        addObject(btnSobre, 117, 551);
        introSom.play();

   }
   
   public void sobreJogo(){
        removeObject(telaInicial);
        removeObject(jogar);
        removeObject(instrucoes);
        removeObject(btnSobre);
        
        sobreMenu = new MenuSobre();
         btnVoltar = new Voltar();
         addObject(sobreMenu, 486,310);
         addObject(btnVoltar, 848, 37);
        
    }
   
   public GreenfootSound musica(){
    return jogoSom;
    }
    
   
   
   public void inicioJogo(){
        introSom.stop();
        musica().playLoop();
        
        removeObject(telaInicial);
        removeObject(jogar);
        removeObject(instrucoes);
        removeObject(btnVoltar);
        
        addObject (P1, 464,362);
        addObject (P2, 519,362);
         
        addObject(labelMisStar,48,82);//adicionando o objeto que representa a personagem Misstar
        addObject(nome1,47,112);//adicionando o objeto que representa a personagem Misstar        

        addObject(labelButterEvil,925,82);//adicionando o objeto que representa o personagem ButterEvil
        addObject(nome2,925,112);//adicionando o objeto que representa a personagem ButterEvil        
        
        addObject(contornoPoder, 130,61);//adicionando o objeto que circunda o poder de um personagem
       
        addObject(contornoPoder2, 834,61);//adicionando o objeto que circunda o poder de um personagem        
        
        addObject(nomeDoJogo,557,536);//adicionando objeto que nomeia o jogo ao seu design
        
        addObject (painelPoderMisStar, 213,64);
        addObject (painelPoderButterEvil, 753,68);
                
        addObject(coadj_1,234,459);//adicionando objeto ao design do jogo - Aécio
        addObject(coadj_2,851,569);//adicionando objeto ao design do jogo - Joaquim        
        addObject(coadj_3,928,437);//adicionando objeto ao design do jogo - Bolsomito        
        addObject(coadj_4,396,50);//adicionando objeto ao design do jogo - JapaFederal        
        addObject(coadj_5,141,560);//adicionando objeto ao design do jogo - JapaFederal        
        addObject(coadj_6,49,486);//adicionando objeto ao design do jogo - Marina        
        addObject(coadj_7,761,437);//adicionando objeto ao design do jogo - Cervero
             
        adicionaCercas();
        addObject (moro, 490,487);
        
        scoreP1();
        scoreP2();
                            
   }
           
   public void scoreP1(){
        
        if (P1.getVotos() == 0){
            
            showText("", 50,31);
        
        } else {
        
            showText(""+P1.getVotos(), 50,31);
            
        }

    }
    
    public void scoreP2(){

       if (P2.getVotos() == 0){
           
            showText("", 923,33);
       
        } else {
        
            showText(""+P2.getVotos(), 923,33);
       }

    }     
     
    public void adicionaCercas(){
        
        Mapa mapa1 = new Mapa();
        addObject(mapa1, 818, 223);
        mapa1.setRotation(-35);
        
        Mapa mapa2 = new Mapa();
        addObject(mapa2, 661, 321);
        mapa2.setRotation(-25);
        
        Mapa mapa3 = new Mapa();
        addObject(mapa3, 490, 366);
        
        Mapa mapa4 = new Mapa();
        addObject(mapa4, 142, 244);
        mapa4.setRotation(30);
        
        Mapa mapa5 = new Mapa();
        addObject(mapa5, 312, 332);
        mapa5.setRotation(20);
        
        Mapa mapa6 = new Mapa("mapa2.png");
        addObject(mapa6, 488, 286);
        mapa6.setRotation(90);
        
        Mapa mapa7 = new Mapa("mapa2.png");
        addObject(mapa7, 488, 140);
        mapa7.setRotation(90);
        
        Mapa mapa8 = new Mapa("mapa2.png");
        addObject(mapa8, 490, 390);
        mapa8.setRotation(90);
        
        Mapa mapa9 = new Mapa();
        addObject(mapa9, 330, 300);
        mapa9.setRotation(26);
        
        Mapa mapa10 = new Mapa();
        addObject(mapa10, 160, 230);
        mapa10.setRotation(30);
    
    }
            
    public int cicloAtual(){
        
        return cicloAtual;
    
    }

    public void addUrnas(){

        adicionaObjetos(urnas);
       
    }
       
    public void addPoderDeAjuda(){

        adicionaObjetos(poderAjuda);
    
    }
    
    public void adicionaObjetos(List<Actor> objetos){
        
         int indice = Greenfoot.getRandomNumber(400); // gera um número aleatótio para servir de indice ao adicionar  na tela
         
         int x = Greenfoot.getRandomNumber(900);  // valor aleatório da coordenada x.
         int y = Greenfoot.getRandomNumber(500);  // valor aleatório da coordenada y.
         
         List mapa = getObjectsAt(x, y, Mapa.class); // lista de objetos do tipo Mapa nas coordenadas geradas.
            
         if(indice < objetos.size()){
         
             if(!mapa.isEmpty()){
                 
                addObject(objetos.get(indice), x, y);  // Adiciona  nas coordenadas geradas acima.
            
            }
            
        }
    }    
    
    public void finalJogo (boolean fJ1, boolean fJ2){
       
        scoreP1();
        scoreP2();
        
        
       if ((fJ1) ||(fJ2)) {

           this.musica().stop();            
           Greenfoot.delay(200);
           Greenfoot.setWorld(new MyWorld() );

        }
        
        
    }
    
    public GreenfootSound getJogoSom(){
     
        return jogoSom;
    
    }
    
    
    public void act() {
        
        cicloAtual++;//variavel para utilizaçao nos metodos de animaçao de alguns objetos/sprites
       
        if(cicloAtual >= 1000){//condiçao para desacumular o contador de tempo/ciclos
        
            cicloAtual = 0;
        
        }
       
        addUrnas();
       
        addPoderDeAjuda();
       
        fimJogo1 = P1.fim();
        fimJogo2 = P2.fim();

        finalJogo(fimJogo1, fimJogo2);

    }
    
}
