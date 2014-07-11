package data.structures.hashing;

/**
 * Created by skunnumkal on 6/28/14.
 */
//FIXME This code is not clean and needs to be refactored

/**
 * All cells have an Integer value and a boolean marked
 * when created marked = false, integer value not null
 * when deleted marked = true,
 * when new value inserted, marked = false, value = new value
 */
public class OpenAddress {
    private Cell[] table; // = new Cell[10];
    private int usedCount = 0;
    public OpenAddress(int size){
        table = new Cell[size];
        for(int i=0;i<table.length;i++){
            table[i] = new Cell();
        }
    }



    private int getNext(int idx){
        if(idx==table.length-1){
            return 0;
        }
        return idx+1;
    }


    public Integer find(int val){
        int hashedIdx = hash(val);
        int curIdx = hashedIdx;
        while(!table[curIdx].isEmpty() && table[curIdx].value != val){
            curIdx = getNext(curIdx);
            if(curIdx == hashedIdx){
                return null;//completed round trip
            }
        }
        //either its empty or we found a match
        if(table[curIdx].isEmpty()){
            return null;
        }
        else{
            return curIdx;
        }
    }

    public void insert(int val){
        if(usedCount >= table.length){
            throw new RuntimeException("No more space");
        }
        int hashedIdx = hash(val);
        int curIdx = hashedIdx;
        while(!table[curIdx].isEmpty()){
            curIdx = getNext(curIdx);
        }
        table[curIdx].insert(val);
        usedCount++;
    }

    public void delete(int val){
        Integer elIdx = find(val);
        if(elIdx != null){
            table[elIdx].marked = true;
            usedCount--;
        }

    }

    private int hash(int val) {
        return val % table.length;
    }


}
class Cell{
    public boolean marked = false;
    public Integer value = null;



    public boolean isEmpty(){
        return marked || value == null;
    }

    public void insert(int val){
        marked = false;
        this.value = val;
    }



}
