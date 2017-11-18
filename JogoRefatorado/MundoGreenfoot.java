import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MundoGreenfoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MundoGreenfoot extends World implements ConectorMundo<Actor, World>
{
    private Mundo mundo;
    /**
     * Constructor for objects of class MundoGreenfoot.
     * 
     */
    
    public MundoGreenfoot(){
        super(970, 620, 1); 
        
        mundo = Mundo.getInstancia(Mundo.FASE01);
        GreenfootImage imagem = new GreenfootImage(mundo.getImagem());
        setBackground(imagem); 
    }
    
    public void removerDoMundo(Actor ator){
          this.removeObject(ator);
    }
    
    public void addNoMundo(Actor ator, int x, int y){
        this.addObject(ator, x, y);
    }
    
    public World getMundo(){
        return this;
    }
}
