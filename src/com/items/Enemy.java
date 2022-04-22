package com.items;


public class Enemy extends Item {

    private int armory;
    private int damage;
    private Item loot;
    private Enemytype type;


    /**
     * Costruttore com parametri della classe Enemy
     * @param name
     * @param armory
     * @param damage
     * @param loot
     * @param type
     */
    public Enemy(String name, int armory, int damage, Item loot, Enemytype type) throws Exception {
        super(name);
        setArmory(armory);
        setDamage(damage);
        setLoot(loot);
        setType(type);
    }

    /**
     * metodo get dell'attributo
     * @return armory
     */
    public int getArmory() {
        return armory;
    }

    /**
     * metodo get dell'attributo
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * metodo get dell'attributo
     * @return loot
     */
    public Item getLoot() {
        return loot;
    }

    /**
     * metodo get dell'attributo
     * @return type
     */
    public Enemytype getType() {
        return type;
    }

    /**
     * metodo set dell'attributo
     * @param armory
     */
    public void setArmory(int armory) {
        this.armory = armory;
    }

    /**
     * metodo set dell'attributo
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * metodo set dell'attributo
     * @param loot
     */
    public void setLoot(Item loot) {
        this.loot = loot;
    }

    /**
     * metodo set dell'attributo
     * @param type
     */
    public void setType(Enemytype type)throws Exception {
        try{
            this.type = type;
        }catch(NullPointerException ex){
            throw new Exception("Parametro del metodo setType della classe Enemy null");
        }
    }


}
