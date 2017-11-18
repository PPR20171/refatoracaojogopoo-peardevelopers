/**
 * Write a description of class FabricaConectoresGreenfoot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FabricaConectoresGreenfoot implements FabricaConectores {
    
     public ConectorAtor criarAtor(Ator ator){
         return new AtorGreenfoot(ator);
     }
     
     public ConectorMundo criarMundo(){
         return new MundoGreenfoot();    
     }
}