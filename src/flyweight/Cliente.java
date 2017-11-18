/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

/**
 *
 * @author Usuário
 */

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    public static void main(String[] args){
        
        Runtime teste = Runtime.getRuntime();
        
        FlyweightPool criador = new FlyweightPool();
        
        List<Urna> lista = new ArrayList<Urna>();
        
        for(int i=0; i < 1000000; i++){
            lista.add(criador.criar());
        }
        
        
        /**for(int i=0; i < 1000000; i++){
            lista.add(new Urna());
        }**/
       
        System.out.println((((teste.totalMemory()-teste.freeMemory())/1024)/1024)+"MB");
    }
}