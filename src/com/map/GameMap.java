package com.map;

import com.Locality;
import com.LocalityGenerator;

public class GameMap {

    private MapNode current;
    public GameMap(){
        current= new MapNode(LocalityGenerator.getInstance().generateLocality(),Coor.ZERO);
        current.generateNear();
    }
    public String getMap(){
        return current.getMap();
    }

    public void printMap(){
        System.out.println(current.getMap());
    }
    public void move(int n){
        current = current.getInDir(n);
        current.generateNear();
    }
    public Locality getLoc(){
        return current.getLoc();
    }

}
