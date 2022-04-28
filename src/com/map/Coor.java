package com.map;

/**
 * ogni punto ha la sua coordinata, così quando ne aggiungo uno nuovo lo attacco alle
 * celle vicine.
 * notazione direzionale: 0 su, 1 basso destra, 3 basso sinistra, per triangoli equilateri
 */
public class Coor {

    public static Coor ZERO=new Coor(0,0);
    private int x;
    private int y;


    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * ritorna un numero da sommare a una x per avere la x spostata di uno in quella direzione
     * @param dir direzione del movimento
     * @return numero da sommare
     */
    public static int ix(int dir) {
        return switch(dir) {
            case 1 -> 1;
            case 2 -> -1;
            default -> 0;
        };
    }

    /**
     * uguale a ix, solo per le ypsilon
     * @param dir direzione di movimento voluta
     * @return numero da sommare
     */
    public static int yp(int dir) {
        return dir == 0 ? 1 : -1;
    }

    /**
     * ritorna la coordinata nella direzone dir a distanza uno
     * @param dir
     * @return
     */
    public Coor move(int dir) {
        return new Coor(x + ix(dir), y + yp(dir));
    }

    /**
     * ritorna true se le coordinate sono adiacenti
     * @param c coordinata da controllare
     * @return true se sono adiacenti
     */
    public boolean isAdiacent(Coor c) {
        return (Math.abs(x - c.x) + Math.abs(y - c.y)) == 1;
    }

    /**
     * controlla se le due coordinate sono vicine in diagonale
     * @param c coordinata da controllare
     * @return true se sono in diagonale
     */
    public boolean isDiagonal(Coor c) {
        return (Math.abs(x - c.x) + Math.abs(y - c.y)) == 2 && (x != c.x && y != c.y);
    }

    /**
     * ritorna la direzione rispetto a questa della coordinata parametro, ammettendo che siano vicine
     * @param c coordinata da controllare
     * @return direzione di c
     */
    public int getDir(Coor c){
        if(c.x == x)
            return 0;
        else
            return (c.x == x + 1 ^ y + 1 == c.y) ? 2 : 1;
    }
}
