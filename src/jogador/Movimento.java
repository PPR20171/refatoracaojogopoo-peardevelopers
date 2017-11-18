/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogador;

/**
 *
 * @author Usuário
 */
public interface Movimento {
    
    public int moverOeste(int distancia);
    public int moverLeste(int distancia);
    public int moverNorte(int distancia);
    public int moverSul(int distancia);
}
