package com;

import java.util.ArrayList;

public class Map {
    class Node{
        private Locality loc;
        private Node[] near;
        private int size;
        public Node(Locality loc){
            this.loc = loc;
            size = 0;
        }
        public void addNear(Node n){
            if(size == 0){
                near = new Node[2];
            }else if(size == near.length){
                Node[] temp = new Node[near.length*2];
                for(int i = 0; i < near.length; i++)
                    temp[i] = near[i];
            }
            near[size++] = n;
        }
        public Locality getLoc(){
            return loc;
        }
        public Node[] getNear(){
            return near;
        }
        public int getSize(){
            return size;
        }
    }
    private Node current;
    private ArrayList<Node> nodes;
    public Map(){
        LocalityGenerator tmp= LocalityGenerator.getInstance();
        current= new Node(tmp.generateLocality());
        Node tmpNode;
        for (int i = 0; i < 5; i++){
            tmpNode = new Node(tmp.generateLocality());
            current.addNear(tmpNode);
            tmpNode.addNear(current);
        }
    }
    public String getMap(){
        String out = "";
        for(int i = 0; i < current.getSize(); i++)
            out += i+" "+current.getNear()[i].getLoc().getName() + " ";
        return out;
    }
    public void move(int n){
        current = current.getNear()[n];
    }
    public Locality getLoc(){
        return current.getLoc();
    }

}
