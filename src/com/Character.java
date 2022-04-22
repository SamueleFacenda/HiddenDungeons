package com;


public class Character {
    private int lucky;
    private int power;
    private int baseLife;
    private int agility;
    private String nome;

    /**
     * Costruttore con paraetri della classe Character
     * @param lucky
     * @param power
     * @param baseLife
     * @param agility
     * @param nome
     */
    private Character(int lucky, int power, int baseLife, int agility, String nome) {
        this.lucky = lucky;
        this.power = power;
        this.baseLife = baseLife;
        this.agility = agility;
        this.nome = nome;
    }

    /**
     * metodo get dell'attributo
     * @return lucky
     */
    public int getLucky() {
        return lucky;
    }

    /**
     * metodo get dell'attributo
     * @return power
     */
    public int getPower() {
        return power;
    }

    /**
     * metodo get dell'attributo
     * @return baseLife
     */
    public int getBaseLife() {
        return baseLife;
    }

    /**
     * metodo get dell'attributo
     * @return agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * metodo get dell'attributo
     * @return nome
     */
    public String getNome() {
        return nome;
    }
}


