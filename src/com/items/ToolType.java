package com.items;

public class ToolType {
    private int use;
    private Name [][] names;

    /**
     * costruttore senza parametri
     */
    public ToolType() {
    }

    /**
     * costruttore con un parametro
     * @param use
     * @param names
     */
    public ToolType(int use, Name[][] names) {
        this.use = use;
        this.names = names;
    }

    /**
     * restituisce l'attributo names
     * @return names
     */
    public Name[][] getNames() {
        return names;
    }

    /**
     * setta il nome e lancia eventuali eccezioni
     * @param names
     * @throws Exception
     */
    public void setNames(Name[][] names) throws Exception{
        try{
            if(names.length>0 && names[0].length>0)
                this.names = names;
            else
                throw new Exception("almeno uno dei 2 valori non è valido");
        }catch(NullPointerException ex){
            throw new Exception("non può essere null");
        }

    }

    /**
     * restituisce l'attributo use
     * @return
     */
    public int getUse() {
        return use;
    }

    /**
     * setta l'attributo use e lancia eventuali eccezioni
     * @param use
     * @throws Exception
     */
    public void setUse(int use) throws Exception{
        try{
            this.use = use;
        }catch(NullPointerException ex){
            throw new Exception("non può essere null");
        }
    }
}
