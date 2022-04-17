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
    public static int ix(int dir) {
        return switch(dir) {
            case 1 -> 1;
            case 2 -> -1;
            default -> 0;
        };
    }
    public static int yp(int dir) {
        return dir == 0 ? 1 : -1;
    }

    public Coor move(int dir) {
        return new Coor(x + ix(dir), y + yp(dir));
    }

    public boolean isAdiacent(Coor c) {
        return (Math.abs(x - c.x) + Math.abs(y - c.y)) == 1;
    }

    public boolean isDiagonal(Coor c) {
        return (Math.abs(x - c.x) + Math.abs(y - c.y)) == 2 && (x != c.x && y != c.y);
    }

    public int getDir(Coor c){
        if(c.x == x)
            return 0;
        else{
            if(c.x +1 == x)
                return 2;
            else
                return 1;
        }
    }
}
