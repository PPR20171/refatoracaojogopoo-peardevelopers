/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectores;

/**
 *
 * @author laine
 * @param <X>
 * @param <Y>
 */
public interface ConectorAtor <X, Y>{
    
    public void setLocalizacao(int x, int y);
    public int getX();
    public int getY();
    public void mover(int distancia);
    public void setRotacao(int rotacao);
    public int getRotacao();
    public void removerDoMundo(Y y);
    public void addNoMundo(Y y);
    public X getAtor();
    public Y getMundo();
    public boolean intersecao(X x);
    public void setImagem(String imagem);
    public String getImagem();
}