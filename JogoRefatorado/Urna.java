/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuário
 * 
 * Classe abstrata que representa um flyweight de Urna com o estado intrinseco imagem e valor
 * 
 */
public abstract class Urna {

    
    
    protected Icon imagem;
    protected int valor;


    public void imprimirLocalizacao(Localizacao localizacao) {
        System.out.println("Coordenadas da urna: x: " + localizacao.getX() + " y: " + localizacao.getY());
    }
    

    public Icon getImagem() {
        return imagem;
    }

    public int getValor() {
        return valor;
    }
    
    
}
