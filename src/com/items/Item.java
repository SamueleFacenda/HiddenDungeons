package com.items;


public abstract class Item {

    private String name;

    /**
     * Costruttore con parametri della classe Item
     * @param name
     */
    public Item(String name) throws Exception {
        setName(name);
    }

    /**
     * metodo get dell'attributo
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * metodo set dell'attributo
     * @param name
     */
    public void setName(String name)throws Exception {
        try {
            if(!name.equals(""))
                this.name = name;
            else
                throw new Exception("Il nome non può essere una stringa vuota");
        }catch(NullPointerException ex){
            throw new Exception("Il nome non può essere null");
        }
    }

}







