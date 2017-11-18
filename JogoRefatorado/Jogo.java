public class Jogo  
{
    private FabricaConectores fabrica;
    private ConectorAtor conectorJogador1;
    private ConectorAtor conectorJogador2;
    private Jogador jogador1 = Jogador.getInstancia(Jogador.MisStar);
    private Jogador jogador2 = Jogador.getInstancia(Jogador.ButterEvil);
    
    public Jogo(){
        fabrica = new FabricaConectoresGreenfoot();
        conectorJogador1 = fabrica.criarAtor(jogador1);
        conectorJogador2 = fabrica.criarAtor(jogador2);  
    }   
}
