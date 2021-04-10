package arrays;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
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

    /**
     * returns rectangles coordinates for rectangle starting at xCor, yCor or empty Array if no such rectangle
     * @param image
     * @param xCor
     * @param yCor
     * @return
     */
    public static List<Integer> getRectangleStartingAt(int[][] image,int xCor, int yCor) {
        int i = xCor;
        int j = yCor;
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
        else
            return Collections.emptyList();
    }

    public static List<List<Integer>> findAllRectangles(int[][] image){
        List<List<Integer>> allImageCors = new ArrayList<>();
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[i].length;j++){
                List<Integer> imageCoordinates = getRectangleStartingAt(image,i,j);
                if(!imageCoordinates.isEmpty()) {
                    boolean isInsideExistingRectangle = false;
                    for(List<Integer> imageCor : allImageCors){
                        if(isInImage(imageCor,i,j)) {
                            isInsideExistingRectangle = true;
                            break;
                        }
                    }
                    if(!isInsideExistingRectangle) {
                        allImageCors.add(imageCoordinates);
                    }
                }

            }
        }
        return allImageCors;
    }

    public static boolean isInImage(List<Integer> imageCor, int i, int j) {
        return i>=imageCor.get(0) && i <= imageCor.get(2) && j>=imageCor.get(1) && j <= imageCor.get(3);
    }

}
