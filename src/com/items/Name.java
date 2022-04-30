package com.items;

public class Name {
    private String name;
    private int danger;
    private int lucky;

    /**
     * costruttore senza parametri
     */
    public Name() {
    }

    /**
     * costruttore con parametri
     * @param name
     * @param danger
     * @param lucky
     */
    public Name(String Name, int danger, int lucky) {
        this.name = Name;
        this.danger = danger;
        this.lucky = lucky;
    }

    /**
     * restituisce il valore di nome
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setta il nome e lancia eventuali eccezioni
     * @param Name
     * @throws Exception
     */
    public void setName(String Name) throws Exception{
        try{
            this.name = Name;
        }catch(NullPointerException ex){
            throw new Exception("non può essere null");
        }
    }

    /**
     * restituisce il valore di danger
     * @return danger
     */
    public int getDanger() {
        return danger;
    }

    /**
     * setta danger e lancia eventuali eccezioni
     * @param danger
     * @throws Exception
     */
    public void setDanger(int danger) throws Exception{
        try{
            this.danger = danger;
        }catch(NullPointerException ex){
            throw new Exception("non può essere null");
        }
    }

    /**
     *  restituisce il valore di lucky
     * @return lucky
     */
    public int getLucky() {
        return lucky;
    }

    /**
     * setta lucky e lancia eventuali eccezioni
     * @param lucky
     * @throws Exception
     */
    public void setLucky(int lucky) throws Exception{
        try{
            this.lucky = lucky;
        }catch(NullPointerException ex){
            throw new Exception("non può essere null");
        }
    }
}
