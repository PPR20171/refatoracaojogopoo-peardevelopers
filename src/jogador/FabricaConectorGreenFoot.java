package jogador;

import conectores.*;
import greenfoot.AdptadorAtorGreenfoot;
import greenfoot.AdptadorImagemGreenfoot;
import greenfoot.AdptadorMundoGreenfoot;
import greenfoot.AdptadorSitemaGreenfoot;
import greenfoot.AdptadorSomGreenfoot;

public class FabricaConectorGreenFoot implements FabricaConectores {

	@Override
	public ConectorImagem criarConectorImagem() {
		// TODO Auto-generated method stub
		return new AdptadorImagemGreenfoot();
	}

	@Override
	public ConectorSom criarConectorSom() {
		// TODO Auto-generated method stub
		return new AdptadorSomGreenfoot();
	}

	@Override
	public ConectorSistema criarConectorSistema() {
		// TODO Auto-generated method stub
		return new AdptadorSitemaGreenfoot();
	}

	@Override
	public ConectorAtor criarConectorAtor() {
		// TODO Auto-generated method stub
		return new AdptadorAtorGreenfoot();
	}

	@Override
	public ConectorMundo criarConectorMundo() {
		// TODO Auto-generated method stub
		return new AdptadorMundoGreenfoot();
	}

}
