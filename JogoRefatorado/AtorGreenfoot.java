import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AtorGreenfoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AtorGreenfoot extends Actor implements ConectorAtor<Actor, World>
{
    /**
     * Act - do whatever the AtorGreenfoot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private Ator ator;
    private World mundo;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void setMundo(World mundo){
        this.mundo = mundo;    
    }
    
    public AtorGreenfoot(Ator ator){
        this.ator = ator;
    }
    public void setLocalizacao(int x, int y){
        ator.setLocalizacao(x,y);
        setLocation(x,y);
    }
    
    public int getX(){
        return ator.getCoordX();
    }
    
    public int getY(){
        return ator.getCoordY();
  
    }
    public void mover(int distancia){
        
    }

    public void removerDoMundo(Actor ator){
        getMundo().removeObject(ator);
    }
    
    public void addNoMundo(Actor ator, int x, int y){
        getMundo().addObject(ator, x, y);
    }
    
    public Actor getAtor(){
        return this;
    }
    
    public World getMundo(){
        return mundo;
    }
    
    public boolean intersecao(Actor ator){
        return false;
    }
    
    public void setImagem(String imagem){
        ator.setImagem(imagem);
    }
    
    public String getImagem(){
        return ator.getImagem();
    }
}
