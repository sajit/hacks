package l33t;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skunnumkal on 10/24/14.
 */
public class LeaderBoard {


    public static int[] leaders(int[] arr){
        List<Integer> result = new ArrayList<Integer>();
        int currentMax = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i] > currentMax){
                result.add(arr[i]);
                currentMax = arr[i];
            }
        }
        int[] resp = new int[result.size()];
        for(int i=result.size()-1;i>=0;i--){
            resp[resp.length-1-i] = result.get(i);
        }
        return resp;
    }

    public static void main(String[] args){
        int[] arr = {4,3,6,7,13,3,8,4};
        int[] out = LeaderBoard.leaders(arr);
        for(int x : out){
            System.out.print(" "+x);
        }
    }
}
