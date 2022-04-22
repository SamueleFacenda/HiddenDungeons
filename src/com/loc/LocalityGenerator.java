package com.loc;

public class LocalityGenerator {
    private static LocalityGenerator singleInstance = null;
    private int difficulty=0;

    String namePool[] ={"Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","Sample","Sample","Sample","Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","Sample","Sample","Sample","Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","Sample","Sample","Sample"};
    String aggettivi[] ={"Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","","","","Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","Sample","Sample","Sample","Casa ","Locanda ","Chiesa ","Gilda ","Villa ","Grotta ","Sample","Sample","Sample"};

    public Locality generateLocality(){
        String name;
        int ind, indAgg, lucky, danger;
        ind = (int)(Math.random()*((20-1)+1)+1);
        if(ind > 10) {
            indAgg = (int) (Math.random() * ((20 - 10) + 1) + 10);
            name = namePool[ind] + aggettivi[(int) (indAgg)];
        }else{
            indAgg = (int) (Math.random() * ((10 - 0) + 1) + 0);
            name = namePool[ind] + aggettivi[(int) (indAgg)];
        }
        if(indAgg>=5 && indAgg<10 || indAgg>=15 && indAgg<20){
            lucky=(int) (Math.random() * ((5 - 1) + 1) + 1);
            danger=(int) (Math.random() * ((10 - 5) + 1) + 5);
        }else{
            lucky=(int) (Math.random() * ((10 - 5) + 1) + 5);
            danger=(int) (Math.random() * ((5 - 1) + 1) + 1);
        }
        return new Locality(name,danger,lucky);
    }

    public static LocalityGenerator getInstance() {
        if (singleInstance == null)
            singleInstance = new LocalityGenerator();
        return singleInstance;
    }

    public static void createInstance(int difficulty){
        if(singleInstance == null){
            singleInstance = new LocalityGenerator();
            singleInstance.difficulty = difficulty;
        }
    }
}
