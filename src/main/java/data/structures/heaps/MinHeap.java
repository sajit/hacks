package data.structures.heaps;

import java.util.Random;

/**
 * Created by sajit on 7/18/14.
 */
public class MinHeap {

    private final int[] heapArr;
    private int heapSize = 0;

    private int getParent(int idx){
        return idx/2;
    }

    private int getLeftChild(int idx){
        return idx*2;
    }

    private int getRighChild(int idx){
        return 2*idx+1;
    }

    public MinHeap(int size){
        heapArr = new int[size+1];
    }

    public int findMin(){

        if(heapSize==0){
            throw new RuntimeException("Empty");
        }
        return heapArr[1];
    }

    public void deleteMin(){
        heapArr[1]=heapArr[heapSize];
        heapSize--;
        int idx=1;
        while(idx<=heapSize){
            int lc = getLeftChild(idx);
            int rc = getRighChild(idx);
            boolean isGreaterThanLC = false,isGreaterThanRC = false;
            if(lc<=heapSize && heapArr[idx]>heapArr[lc]){
                isGreaterThanLC = true;
            }
            if(rc<=heapSize && heapArr[idx]>heapArr[rc]){
                isGreaterThanRC = true;
            }
            if(isGreaterThanLC && isGreaterThanRC){
                if(heapArr[lc]<heapArr[rc]){
                    swap(idx, lc);
                    idx = lc;
                }
                else{
                    swap(idx,rc);
                    idx = rc;
                }
            }
            else if(isGreaterThanLC){
                swap(idx,lc);
                idx = lc;
            }
            else if(isGreaterThanRC){
                swap(idx,rc);
                idx = rc;
            }
            else{
                return;
            }
        }

    }

    private void swap(int idx, int lc) {
        int temp = heapArr[idx];
        heapArr[idx] = heapArr[lc];
        heapArr[lc] = temp;
    }

    public void insert(int value){
        if(heapSize>heapArr.length){
            throw new RuntimeException("Too long");

        }
        heapArr[heapSize+1] = value;
        heapSize++;
        int idx = heapSize, parent = getParent(idx);
        while(idx>=1 && heapArr[parent] > heapArr[idx]){
            swap(idx,parent);
            idx = parent;
            parent = getParent(idx);
        }

    }

    public void printHeap(){
        for(int i=1;i<=heapSize;i++){
            System.out.print(" " + heapArr[i]);
        }
    }

    public int getSize(){

        return heapSize;

    }

    public static  void main(String[] args){
        MinHeap heap = new MinHeap(10);
        Random r = new Random();
        for(int i=0;i<7;i++){
            int val = r.nextInt(100);
            System.out.print(" Inserting .. " + val);
            heap.insert(val);
            System.out.println(" size = " + heap.getSize());
        }

        heap.printHeap();

        System.out.println("Moving to delete..");

        heap.deleteMin();

        heap.deleteMin();

        heap.printHeap();
    }
}
