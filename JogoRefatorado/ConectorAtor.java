public interface ConectorAtor <Ator, Mundo>{
    
    public void setLocalizacao(int x, int y);
    public int getX();
    public int getY();
    public void mover(int distancia);
    public void setMundo(Mundo mundo);
    public void removerDoMundo(Ator ator);
    public void addNoMundo(Ator ator, int x, int y);
    public Ator getAtor();
    public Mundo getMundo();
    public boolean intersecao(Ator ator);
    public void setImagem(String imagem);
    public String getImagem();
}
