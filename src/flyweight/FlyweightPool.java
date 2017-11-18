
package flyweight;

import aleatorio.GeradorUrnaALeatoria;
import java.util.HashMap;

/**
 * Classe responsável pelo gerenciamento da instância do objeto urna retornando
 * ao jogo Uma urna quando requisitada
 *
 * @author Usuário
 */
public class FlyweightPool {

    //atributo responsável por retornar uma urna aleatória do map de urnas para o jogo
    private GeradorUrnaALeatoria gerador;

    private HashMap<String, Urna> urnas;

    public FlyweightPool() {
        urnas = new HashMap<String, Urna>();
        urnas.put("urna5", new Urna5());
        urnas.put("urna10", new Urna10());
        urnas.put("urna5", new Urna5());
        urnas.put("urna10", new Urna10());
        urnas.put("urna5", new Urna5());

    }

    public void setGerador(GeradorUrnaALeatoria gerador) {
        this.gerador = gerador;
    }

    public Urna adquirir() {
        ///retorna uma urna para o jogo passando uma localização aleatória utilizando o gerador
        //para dar uma aleatoriedade nas aquisições
    }

    public void devolver(Urna urna) {
        ///Devolve a urna ao pool depois de usada
    }
}
