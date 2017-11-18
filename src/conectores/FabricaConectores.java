package conectores;

public interface FabricaConectores {
	
	public ConectorImagem criarConectorImagem();
	public ConectorSom criarConectorSom();
	public ConectorSistema criarConectorSistema();
	public ConectorAtor criarConectorAtor();
	public ConectorMundo criarConectorMundo();

}
