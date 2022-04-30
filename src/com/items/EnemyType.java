package com.items;

public class EnemyType {
    private int type;
    private static String [][] Enemy;

    /**
     * costruttore senza parametri
     */
    public EnemyType() {
    }

    /**
     * costruttore con parametri
     * @param type
     */
    public EnemyType(int type) {
        this.type = type;
    }

    /**
     * restituisce l'attributo "enemy"
     * @return enemy
     */
    public static String[][] getEnemy() {
        return Enemy;
    }

    /**
     * restituisce l'attributo "type"
     * @return enemy
     */
    public int getType() {
        return type;
    }

    /**
     * permette di settare l'attributo "type" e lanciare eventuali eccezioni
     * @param type
     * @throws Exception
     */
    public void setType(int type) throws Exception{
        try{
            this.type = type;
        }catch(NullPointerException ex){
            throw new Exception("il tipo non può essere null");
        }
    }


}
