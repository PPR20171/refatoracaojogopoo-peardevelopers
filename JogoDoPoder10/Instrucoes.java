import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instrucoes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrucoes extends Botoes
{
    /**
     * Act - do whatever the Instrucoes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){

            MyWorld.getInstancia().instrucoes();
            
        }
    }    
}
