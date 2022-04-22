package com.items;


import com.items.Item;

public class Tool extends Item {

    private int armory;
    private int damage;
    private ToolType type;

    /**
     * Costruttore con parametri della classe tool
     * @param name
     * @param armory
     * @param damage
     * @param type
     */
    public Tool(String name, int armory, int damage, ToolType type) throws Exception {
        super(name);
        setArmory(armory);
        setDamage(damage);
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
     * metodo set dell'attributo
     * @param armory
     */
    public void setArmory(int armory) {
        this.armory = armory;
    }

    /**
     * metodo get dell'attributo
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * metodo set dell'attributo
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * metodo get dell'attributo
     * @return type
     */
    public ToolType getType() {
        return type;
    }

    /**
     * metodo set dell'attributo
     * @param type
     */
    public void setType(ToolType type)throws Exception {
        try{
            this.type = type;
        }catch(NullPointerException ex){
            throw new Exception("parametro nel metodo setType della classe Tool null");
        }
    }
}


