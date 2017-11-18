import java.util.Map;
import java.util.HashMap;

public class Mundo  {
    
    private String imagem;
    private int width;
    private int height;
    public static String FASE01;
    private static Map<String, Mundo> fases;
    
    private Mundo(){
        
    }
    
    public void setImagem(String imagem){
        this.imagem = imagem;
    }
    
    public String getImagem(){
        return imagem;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public static Mundo getInstancia(String fase){
        return fases.get(fase);
    }
    
    static{
        fases = new HashMap<String, Mundo>();
        Mundo fase1 = new Mundo();
        fases.put(Mundo.FASE01, fase1);
        fase1.setImagem("mundoBrisal.png");
        fase1.setWidth(970);
        fase1.setHeight(620);
    }
}
