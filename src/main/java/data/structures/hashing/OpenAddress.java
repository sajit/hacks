package data.structures.hashing;

/**
 * Created by skunnumkal on 6/28/14.
 */
public class OpenAddress {
    private Cell[] table; // = new Cell[10];
    public OpenAddress(int size){
        table = new Cell[size];
        for(int i=0;i<table.length;i++){
            table[i] = new Cell();
        }
    }

    public void helperInsert(Cell cell,int idx){
        table[idx]  = cell;
    }

    private int getNext(int idx){
        if(idx==table.length-1){
            return 0;
        }
        return idx+1;
    }

    public int findNextEmpty(int idx){
        int curIdx = idx;
        while(table[curIdx].value != null ){
           curIdx = getNext(curIdx);
           if(curIdx == idx){
               return -1;
           }
        }
       return curIdx;
    }

    public boolean exists(int val,int idx){
        int curIdx = idx;
        while(table[curIdx].value == null || table[curIdx].value.intValue() != val){
            if(!table[curIdx].marked && table[curIdx].value == null)
                return false;
            curIdx = getNext(curIdx);
            if(curIdx==idx){
                return false;
            }

        }

        return true;
    }


}
class Cell{
    public boolean marked = false;
    public Integer value = null;

    public Cell(Integer val,boolean marked){
        this.value = val;
        this.marked = marked;
    }

    public Cell(Integer val){
        this.value = val;
    }
    public Cell(){}


}
