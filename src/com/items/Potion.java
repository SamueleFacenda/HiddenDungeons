package com.items;

public class Potion extends Item {

    private int value;

    /**
     * Costruttore con parametri della classe Potion
     * @param name
     * @param value
     */
    public Potion(String name, int value) throws Exception {
        super(name);
        setValue(value);
    }

    /**
     * metodo get dell'attributo
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * metodo set dell'attributo
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }


}




