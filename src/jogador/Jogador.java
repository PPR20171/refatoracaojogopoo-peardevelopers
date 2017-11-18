/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conectores.ConectorAtor;

/**
 *
 * @author Usuário
 */
public class Jogador {
	
	public List<Observador> observadores = new ArrayList<>();
    
    //conecta o jogador a uma plataforma
    ConectorAtor conector;
    
    //permite atacar outro jogador
    private Ataque ataque;
    
    /** analisa o movimento que o usuário deseja fazer e faz 
     *  com que ele se mova na plataforma em que o jogo
     *  está sendo executado
     */
    private Movimento movimento;
    
    /** analisa os votos do jogador e retorna
     *  o poder que ele pode usar
     */
    private AnalisadorVoto analisadorVotos;
    
    //quantidade de votos acumulada pelo jogador
    private Integer votos;
    
    //nome do jogador
    private String nome;
    
    //Lista de jogadores
    private static Map<String, Jogador> jogadores;
    
    //identificador dos jogadores
    public static String MisStar = "MisStar";
    public static String ButterEvil = "ButterEvil";
    
    //coordenadas do jogador no mapa do jogo
    private int x; private int y;
    
    //armazena o diretorio da imagem do jogador
    private String imagem;
    
    static {
        
        jogadores = new HashMap<String, Jogador>();    
        
        //Cria os jogadores e joga na lista
        Jogador jogador01 = new Jogador();
        jogador01.setNome(Jogador.MisStar);
        
        Jogador jogador02 = new Jogador();
        jogador02.setNome(Jogador.ButterEvil);
        
        jogadores.put(jogador01.getNome(), jogador01);
        jogadores.put(jogador02.getNome(), jogador02);
    }
    
    private Jogador(){
        //define a plataforma que será usada
        conector = new AtorGreenfoot();
         
        //inicializa o analisador de votos
        analisadorVotos = new AnalisadorVoto();
    }
    
    //retorna um jogador
    public static Jogador getInstancia(String nome){
        return jogadores.get(nome);
    }
    
    public void setVotos(Integer votos){
        this.votos = votos;
        for (Observador observador : this.observadores) {
			observador.atualiza(this);
		}
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Integer getVotos(){
        return votos;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getCoordX(){
        return x;
    }
    
    public int getCoordY(){
        return y;
    }
    
    public void mover(){

    }
    
    public void addNoMundo(){
        conector.addNoMundo(conector.getMundo());
    }
    
    public void removerDoMundo(){
        conector.removerDoMundo(conector.getMundo());
    }
    
    public Jogador getJogador(){
        return this;
    }
    
    public void setLocalizacao(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setImagem(String imagem){
        this.imagem = imagem;
    }
    
    public String getImagem(){
        return imagem;
    }
    
    //Realiza um ataque contra outro jogador
    public void atacar(Jogador jogador){
        ataque = analisadorVotos.analisar(this.getVotos());
        ataque.atacar(jogador);
    }
}
