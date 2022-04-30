package com.loc;

public class LocalityName {
    private LocalityType type;

    /**
     * costruttore senza parametri
     */
    public LocalityName() {
    }

    /**
     * costruttore con un parametro
     * @param tipe
     */
    public LocalityName(LocalityType tipe) {
        this.type = tipe;
    }

    /**
     * restituisce l'attributo "type"
     * @return type
     */
    public LocalityType getType() {
        return type;
    }

    /**
     * permette di settare l'attributo "type" e lanciare eventuali eccezioni
     * @param type
     * @throws Exception
     */
    public void setType(LocalityType type) throws Exception{
        try{
            this.type = type;
        }catch(NullPointerException ex){
            throw new Exception("il tipo non può essere null");
        }
    }
}
