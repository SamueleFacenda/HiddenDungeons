package com;

import com.sun.source.doctree.EndElementTree;

import java.awt.event.ItemEvent;
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


    private Scanner in;

    public Game(String time,String name, PlayerType type, int difficulty){
        inventory=new ArrayList<Item>();
        map=new GameMap(difficulty);
        cash=0;
        life=type.getLife();
        clas=type;
        characterName=name;
        equipement=new Item[4];
        isPlaying = false;
        LocalityGenerator.createInstance(difficulty);
    }
    public void main(){
        if(!isPlaying){
            in= new Scanner(System.in);
            isPlaying=true;
            System.out.println("Benvenuto "+characterName+"\n");
            System.out.println("In qualunque momento puoi usare i seguenti comandi:\n" +
                    "M per vedere la mappa\n" +
                    "E per vedere l'inventario\n" +
                    "S per vedere le statistiche\n");
            System.out.println("Inizio gioco");
            String choose;
            do{
                System.out.println("\nInserisci scelta, E per uscire, I per entrare nella località:\n");
                choose = in.nextLine();
                choose= ""+checkForActions(choose.charAt(0));
                if(choose.equals("I")) locality(map.getLoc());
            }while (!choose.equals("E"));
            System.out.println("\nGrazie per aver giocato");
            isPlaying=false;
        }
    }

    private char checkForActions(char in){
        switch (in){
            case 'M':
            case 'm':
                mappa();
                return '\0';
            case 'E':
            case 'e':
                inventory();
                return '\0';
            case 'S':
            case 's':
                showStats();
                return '\0';
            default:
                return in;
        }
    }

    private void locality(Locality tmp){
        String choose;
        do{
            System.out.println(tmp.getActions() + "\nInserisci scelta, E per uscire:\n");
            choose = in.nextLine();
            if(choose.length()>1)
                System.out.println("Scelta non valida");
            else {
                choose= ""+checkForActions(choose.charAt(0));
                if(!choose.equals("\0")){
                    if (Pattern.compile("[0-9]").matcher(choose).matches()) {
                        //azione scelta
                        action(tmp.choose(Integer.parseInt(choose)));

                    } else
                        System.out.println("Scelta non buona");
                }
            }

        }while(!choose.equals("E"));
    }

    private void action(Action exec){
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

    private void mappa(){
        map.printMap();
        System.out.println("Inserisci il movimento, 0 per non fare niente:\n");
        String tmp = in.nextLine();
        if(tmp.length()>1)
            System.out.println("Scelta non valida");
        else {
            tmp = "" + checkForActions(tmp.charAt(0));
            if (!tmp.equals("\0")) {
                try{
                    map.move(Integer.parseInt(tmp));
                }catch (NumberFormatException e){
                    System.out.println("Scelta non valida");
                }
            }
        }
    }

    private void inventory(){
        System.out.println("Inventario:\n");
        for(Item e:inventory){
            System.out.println(e.getName());
        }
        char choose;
        do {
            System.out.println("\nInserisci scelta:\n1 per usare oggetto\n2 per equipaggiare oggetto\n3 per eliminare oggetto\nS per tornare indietro");
            choose = in.nextLine().charAt(0);
            choose = checkForActions(choose);
            if (choose != '\0') {
                if (Pattern.compile("[0-9]").matcher("" + choose).matches()) {
                    switch (Integer.parseInt("" + choose)) {
                        case 1:
                            use();
                            break;
                        case 2:
                            equip();
                            break;
                        case 3:
                            remove();
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            break;
                    }
                }else
                    if (choose != 'S') System.out.println("Scelta non valida");
            }
        }while(!choose.equals("S"));
    }

    private void use() {
        System.out.println("Inserisci nome oggetto da usare");
        String name = in.nextLine();
        for(Item e:inventory){
            if(e.getName().equals(name)){
                if(e instanceof Potion){
                    life+=e.getValue();
                    inventory.remove(e);
                    System.out.println("Hai guadagnato "+e.getValue()+" punti vita");
                } else
                    System.out.println("Non puoi usare questo oggetto");
                return;
            }
        }
        System.out.println("Oggetto non trovato");
    }

    private void equip(){
        System.out.println("Inserisci nome oggetto da equipaggiare");
        String name = in.nextLine();
        for(Item e:inventory){
            if(e.getName().equals(name)){
                if(e instanceof Weapon){
                    Weapon old = equipement[e.getType()];
                    equipement[e.getType()] = (Weapon) e;
                    inventory.remove(e);
                    System.out.println("Hai equipaggiato "+e.getName());
                    inventory.add(old);
                } else
                    System.out.println("Non puoi equipaggiare questo oggetto");
                return;
            }
        }
        System.out.println("Oggetto non trovato");
    }

    private void remove(){
        System.out.println("Inserisci nome oggetto da rimuovere");
        String name = in.nextLine();
        for(Item e:inventory){
            if(e.getName().equals(name)){
                inventory.remove(e);
                System.out.println("Hai rimosso "+e.getName());
                return;
            }
        }
        System.out.println("Oggetto non trovato");
    }

    private void showStats() {
        System.out.println("vita:"+life);
        System.out.println("chash:"+chash);
        for(Weapon e:equipement)
            if(e!=null) System.out.println("Arma:"+e.getName());
    }
}
