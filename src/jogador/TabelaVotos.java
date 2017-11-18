package jogador;

public class TabelaVotos implements Observador{

	
	
	@Override
	public void atualiza(Jogador jogador) {
		exibeVotos(jogador.getVotos());
		
	}
	
	public void exibeVotos(int votos) {
		//Exibe os votos na tela
	}

}
