package data.structures.heaps;

import java.util.Random;

/**
 * Created by sajit on 7/18/14.
 *
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
            throw new IllegalStateException("Empty");
        }
        return heapArr[1];
    }

    public void deleteMin(){
        if(heapSize==0){
            throw new IllegalStateException("Empty");
        }
        heapArr[1]=heapArr[heapSize];
        heapSize--;
        int idx=1;
        while(idx<=heapSize){
            int lc = getLeftChild(idx);
            int rc = getRighChild(idx);
            boolean isGreaterThanLC = lc<=heapSize && heapArr[idx]>heapArr[lc];
            boolean isGreaterThanRC = rc<=heapSize && heapArr[idx]>heapArr[rc];

            if(isGreaterThanLC && isGreaterThanRC){
                if(heapArr[lc]<heapArr[rc]){
                    idx = swapAndGetCurrentWorkingIdx(idx, lc);
                }
                else{
                    idx = swapAndGetCurrentWorkingIdx(idx,rc);
                }
            }
            else if(isGreaterThanLC){
                idx = swapAndGetCurrentWorkingIdx(idx,lc);
            }
            else if(isGreaterThanRC){
                idx = swapAndGetCurrentWorkingIdx(idx,rc);
            }
            else{
                return;
            }
        }

    }

    /**
     * Swaps two elements in the array . Swaps the elements between the original index and newIndex.
     * @param originalIndex
     * @param newIndex
     * @return the new index of the element that was in the original index
     */
    private int swapAndGetCurrentWorkingIdx(int originalIndex, int newIndex) {
        int temp = heapArr[originalIndex];
        heapArr[originalIndex] = heapArr[newIndex];
        heapArr[newIndex] = temp;
        return newIndex;
    }

    public void insert(int value){
        if(heapSize>heapArr.length){
            throw new IllegalStateException("Too long");

        }
        heapArr[heapSize+1] = value;
        heapSize++;
        int idx = heapSize;
        int parent = getParent(idx);
        while(idx>=1 && heapArr[parent] > heapArr[idx]){
            idx = swapAndGetCurrentWorkingIdx(idx,parent);
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
