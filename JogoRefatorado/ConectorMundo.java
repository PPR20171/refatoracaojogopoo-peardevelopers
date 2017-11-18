public interface ConectorMundo <Ator, Mundo>{
    
    public void removerDoMundo(Ator ator);
    public void addNoMundo(Ator ator, int x, int y);
    public Mundo getMundo();
}