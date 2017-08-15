import greenfoot.*;  

public class Jogar extends Botoes
{
  public int proximaImg = 1;
    public static final int TAXA_DE_ATUALIZACAO = 10;
    public void act() 
    {
          setImage(new GreenfootImage("jogar"+proximaImg+".png"));
          MyWorld mundo = MyWorld.getInstancia();
            
        if (mundo.cicloAtual() % TAXA_DE_ATUALIZACAO == 0){ 
            proximaImg++;
            
        }
        
        if(proximaImg > 2){
            proximaImg = 1;
        }
        
        if(Greenfoot.mouseClicked(this)){

            ((MyWorld)getWorld()).inicioJogo();
            
        }
    }
}
