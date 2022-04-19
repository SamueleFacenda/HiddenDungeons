package com.map;

import com.Locality;
import com.LocalityGenerator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * nodo della mappa, e' un punto di un semi-grafo, nel senso che e' un grafo
 * ma i collegamenti non si incrociano e sono disposti in modo geometrico, in questo caso a esagoni:
 * ogni punto tocca tre altri punti, se li vediamo come triangoli ogni nodo tocca tre triangoli riversi rispetto
 * a lui, uno dei tre collegamenti e' verticale, si formano degli esagoni verticali:
 *
 *  | | |
 *  o o o
 * /\/\/\
 *o o o o
 *| | | |
 *o o o o
 *\/\/\/
 *o o o
 *
 * ha altri diversi altri attributi: la localita' contenuta, la coordinata nella mappa e un flag generico(usabile in una bfs/dfs), piu' altri attributi
 * statici come la lista completa dei nodi...
 *
 * i nodi vicini vengono generati con il metodo apposito, richiamato da Map quando mi muovo in un nodo che non ha vicini(o almeno non tutti)
 *
 * visto che i nodi vicino sono capovolti e le direzioni vengono usate capovolte, la direzione in cui un nodo vede un altro e' uguale a quella con cui l'altro
 * vede il nodo
 *
 *
 * prendendo come nodo dritto quello con coordinate (0,0), per stampare sempre la mappa nello stesso senso faccio riferimento al verso del nodo partendo dalla coordinata
 */
public class MapNode {
    private static LinkedList<MapNode> nodes = new LinkedList<>();

    private Locality locality;
    private Coor coor;
    private boolean flag;

    private MapNode[] neighbours;

    /**
     * costruttore semplice, con la localita' e la coordinata
     * @param locality localita'
     * @param coor coordinata del nodo
     */
    public MapNode(Locality locality, Coor coor){
        this.locality = locality;
        this.coor = coor;
        this.flag = false;
        nodes.add(this);
        neighbours = new MapNode[3];
    }

    /**
     * aggiungo un nodo vicino, se non esiste
     * @param node nodo vicino
     * @param direction direzione in cui vedo il nodo
     */
    private void addNear(MapNode node, int direction){
        if(neighbours[direction] == null) {
            neighbours[direction] = node;
            node.addNear(this, direction);
        };
    }

    /**
     * genera i nodi vicini, se non esistono
     */
    public void generateNear(){
        for(int i = 0; i < neighbours.length; i++){
            if(neighbours[i] == null){
                MapNode nearNode = new MapNode(LocalityGenerator.getInstance().generateLocality(),coor.move(i));
                MapNode.insertNode(nearNode);
            }
        }
    }

    /**
     * inserisce un nodo nella lista dei nodi e nel posto giusto per tutti i nodi vicini
     * @param to nodo da inserire
     */
    private static void insertNode(MapNode to){
        for(MapNode node : nodes){
            if(node.coor.isDiagonal(to.coor)){
                node.addNear(to, node.coor.getDir(to.coor));
            }
        }
    }

    public Locality getLocality(){
        return locality;
    }

    /**
     * ritorna una stringa con un disegno della mappa del nodo e dei nodi vicini
     * @return mappa bellina
     */
    public String getMap(){
        char[][] map = new char[20][50];
        boolean isDritto = coor.getY() % 2 == 0;
        if(isDritto){
            for (int i = 0; i < 10; i++)
                map[i][25] = '|';
            for (int i = 10; i < 20; i++) {
               map[i][25+i*2-20] = '\\';
               map[i][25-(i*2-20)] = '/';
            }
            addQuad(map, 20, 0, getInDir(0).getLocality().getName());
            addQuad(map,0,14, getInDir(2).getLocality().getName());
            addQuad(map,30, 14, getInDir(1).getLocality().getName());
        }else{
            for (int i = 10; i < 20; i++)
                map[i][25] = '|';
            for (int i = 0 ; i < 10; i++) {
                map[i][i*2] = '\\';
                map[i][29-i*2] = '/';
            }
            addQuad(map, 20, 14, getInDir(0).getLocality().getName());
            addQuad(map,0,0, getInDir(1).getLocality().getName());
            addQuad(map,30, 0, getInDir(2).getLocality().getName());
        }
        addQuad(map, 8,20, locality.getName());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 50; j++){
                sb.append(map[i][j]==0 ? ' ' : map[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * metodo di supporto per getMap(), aggiunge un disegno di un quadrato alla mappa, con i bordi e gli a capi a ogni parola
     * @param map array di char in cui aggiungere il nome
     * @param x coordinata x dell'angolo in alto a sinistra
     * @param y coordinata y dell'angolo in alto a sinistra
     * @param in nome da aggiungere
     */
    private static void addQuad(char[][] map, int x, int y, String in){
        String[] parole = in.split(" ");
        int maxLen = Arrays.stream(parole).max(Comparator.comparingInt(String::length)).get().length();
        for(int riga = y; riga < y + 2 + parole.length; riga++){
            if(riga == y ){
                for(int col = x + 1; col < x + maxLen + 1; col++)
                    map[riga][col] = '-';
                map[riga][x] = '/';
                map[riga][x + maxLen + 1] = '\\';
            }
            else if(riga == y + 1 + parole.length){
                for(int col = x + 1; col < x + maxLen + 1; col++)
                    map[riga][col] = '-';
                map[riga][x] = '\\';
                map[riga][x + maxLen + 1] = '/';
            }
            else{
                map[riga][x] = '|';
                map[riga][x + maxLen + 1] = '|';
                for(int i = 0;i< parole[riga - y - 1].length(); i++)
                    map[riga][x + 1 + i] = parole[riga - y - 1].charAt(i);
            }
        }
    }

    /**
     * per avere il nodo in una direzione
     * @param n direzione
     * @return nodo in quella direzione
     */
    public MapNode getInDir(int n) {
        return neighbours[n];
    }
}
