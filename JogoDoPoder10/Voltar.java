import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Voltar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Voltar extends Botoes
{public int proximaImg = 1;
    public static final int TAXA_DE_ATUALIZACAO = 10;
    public void act() 
    {
          setImage(new GreenfootImage("voltar"+proximaImg+".png"));
          MyWorld mundo = MyWorld.getInstancia();
            
        if (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            proximaImg++;
            
        }
        
        if(proximaImg > 2){
            proximaImg = 1;
        }
      if(Greenfoot.mouseClicked(this)){

            mundo.iniciar();
            
        }
    }    
}
