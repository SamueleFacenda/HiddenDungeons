package com.loc;

public class LocalityType {
    private int place;
    private Action [][] action;

    /**
     * costruttore senza parametri
     */
    public LocalityType() {
    }

    /**
     * costruttotre con parametri
     * @param place
     * @param action
     */
    public LocalityType(int place, Action [][] action) {
        this.place = place;
        this.action = action;
    }

    /**
     * questo metodo restituisce un array bidimensionale
     * @return
     */
    public Action[][] getAction() {
        return action;
    }

    /**
     * controlla i valori da inserire nell'array e lancia eventuali eccezioni
     * @param action
     * @throws Exception
     */
    public void setAction(Action [][] action) throws Exception{
        try{
            if(action.length>0 && action[0].length>0)
                this.action = action;
            else
                throw new Exception("almeno uno dei 2 valori non è valido");
        }catch(NullPointerException ex){
            throw new Exception("i valori non possono essere null");
        }

    }

    /**
     * restituisce l'attributo "place"
     * @return
     */
    public int getPlace() {
        return place;
    }

    /**
     * setta il valore di place e lancia eventuali eccezioni
     * @param place
     * @throws Exception
     */
    public void setPlace(int place) throws Exception{
        try{
            this.place = place;
        }catch(NullPointerException ex){
            throw new Exception("i valori non possono essere null");

        }
    }
}