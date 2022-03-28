package com;

import com.sun.source.doctree.EndElementTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;



public class Game {
    private String lastDatePlay;
    private final String characterName;
    private final PlayerType clas;
    private ArrayList<Item> inventory;
    private GameMap map;
    private int difficulty,cash,life;
    private Item[] equipement;
    private boolean isPlaying;

    public Game(String time,String name, PlayerType type, int difficulty){
        inventory=new ArrayList<Item>();
        map=new GameMap(difficulty);
        cash=0;
        life=type.getLife();
        clas=type;
        characterName=name;
        equipement=new Item[4];
        isPlaying = false;
    }
    public void main(){
        if(!isPlaying){
            Scanner in= new Scanner(System.in);
            isPlaying=true;
            System.out.println("Premi M per vedere la mappa\nPremi E per aprire l'inventario\nPremi 0 per entrare nella localita'\nPremi S per uscire e salvare tutto, se sei in una localita' ritorni alla mappa");
            String choose;

            do{
                System.out.println(map.getNearNodes() + "\nInserisci scelta:\n");
                choose = in.nextLine();
                if(choose.equals("M"))
                    System.out.println(map.getNearNodes());
                else if(choose.equal("E"))
                    System.out.println(inventory());
                else if(choose.length()==1 && Pattern.compile("[0-9]").matcher(choose).matches()){
                    if(choose.equals("0")){
                        //entra nella localita'
                        choose=locality(map.getCurrent());


                    }else{
                        map.moveTo(Integer.parseInt(choose));
                    }
                }else
                    System.out.println("Scelta non buona");

            }while(!choose.equals("S"));

        }
    }

    private String locality(Locality tmp){
        String choose;
        do{
            System.out.println(tmp.getActions() + "\nInserisci scelta:\n");
            choose = in.nextLine();
            if(choose.equals("M"))
                System.out.println(map.getNearNodes());
            else if(choose.equal("E"))
                System.out.println(inventory());
            else if(choose.length()==1 && Pattern.compile("[0-9]").matcher(choose).matches()){
                //azione scelta
                action(tmp.choose(Integer.parseInt(choose)));

            }else
                System.out.println("Scelta non buona");

        }while(!choose.equals("S"));
        return choose;
    }

    private void action(Actoin exec){
        Item out;
        if(exec instanceof Shop)
            out=exec.main(this);
        else
            out=exec.main();

        if(out instanceof Ememy)
            fight((Enemy) out);
        else
            inventory.add(out);
    }

    private void fight(Enemy ene){

    }
    private String inventory(){
        return inventory.toString();
    }

}
