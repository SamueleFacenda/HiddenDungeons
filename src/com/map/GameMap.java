package com.map;

import com.loc.Locality;
import com.loc.LocalityGenerator;

/**
 * contenitore della classe MapNode, che fa una mappa esagonale, con una stampa automatica
 *
 * @author Samuele Facenda
 */
public class GameMap {

    private MapNode current;

    /**
     * costruttore che genera anche i nodi vicini del nodo corrente, creato anch'esso
     */
    public GameMap(){
        current= new MapNode(LocalityGenerator.getInstance().generateLocality(),Coor.ZERO);
        current.generateNear();
    }

    /**
     * stringa delle zone vicine
     * @return stringa tipo toString
     */
    public String getMap(){
        return current.getMap();
    }

    /**
     * stampa la mappa, metodo per velocizzare tutto
     */
    public void printMap(){
        System.out.println(current.getMap());
    }

    /**
     * si muove nella direzione data, poi genera i nodi vicini del nuovo nodo corrente
     * @param n direzione da 0 a 2
     */
    public void move(int n){
        if(n<0 || n>2)
            throw new IllegalArgumentException();
        current = current.getInDir(n);
        current.generateNear();
    }

    /**
     * ritorna la localita' del nodo corrente
     * @return localita' corrente
     */
    public Locality getLocality(){
        return current.getLocality();
    }

}
