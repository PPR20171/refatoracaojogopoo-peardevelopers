/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author adriano
 */
public class Urna5 extends Urna{
    
    public Urna5(){
        File file = new File("imagens//imagemUrna5.jpg");
        imagem = new ImageIcon(file.getPath());
        valor = 5;
    }
}
