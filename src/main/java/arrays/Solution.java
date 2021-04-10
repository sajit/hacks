package arrays;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;

/**
 * Constraints  : A rectangular jimage is represented by a 2D array of 1s and 0s
 * An image is represented by 0s while the background is represnted by 1s
 * Write a function to return the co-cordinates of the image given a  2D array
 * Assumptions
 * 1. Each array has exactly 1 image
 * 2. An image is always a rectangle
 * image1 ={{0}}
 * image2 = {{1,1,1,1,1},{1,1,1,1,0}};
 * image3 = {{1,1,1,1,1},{1,1,0,0,0},{1,1,0,0,0}}
 */
public class Solution {

    public static List<Integer> getRectangle(int[][] image) {
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                if(image[i][j]==0){
                    //search right
                    int k=j;
                    while(k<image[i].length && image[i][k]==0){
                        k++;
                    }
                    //search down
                    int l=i;
                    while(l<image.length && image[l][j]==0) {
                        l++;
                    }
                    return ImmutableList.of(i,j,l-1,k-1);
                }
            }
        }
        return Collections.emptyList();
    }

}
