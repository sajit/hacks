package hackerrank.algo.sort;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Fraud {

    static double findMedian(int[] array){
        if(array.length%2==0){
            return (double)(array[array.length/2]+array[(array.length/2)-1])/(double)2;
        }
        else{
            return array[array.length/2];
        }

    }


    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int count=0;
        int[] workingArray = new int[d];
        for(int i=0;i<d;i++){
            workingArray[i]=expenditure[i];
        }
        workingArray = modifyArray(workingArray,null,null,d);
        for(int i=d;i<expenditure.length;i++){
            //constant

            double median = findMedian(workingArray);

            if(expenditure[i]>=2*median){
                count++;
            }
            workingArray = modifyArray(workingArray,expenditure[i-d],expenditure[i],d);

        }
        return count;
    }

    private static int[] modifyArray(int[] workingArray, Integer toBeRemoved, Integer toBeAdded,int d) {
        TreeMap<Integer,Integer> valueCountMap = new TreeMap<>();
        for(int i=0;i<workingArray.length;i++){
            Integer count = valueCountMap.get(workingArray[i]);
            if(count==null){
                count=0;
            }
            valueCountMap.put(workingArray[i],count+1);
        }
        if(toBeRemoved!=null){
            Integer removedCount = valueCountMap.get(toBeRemoved);
            if(removedCount>1){
                valueCountMap.put(toBeRemoved,removedCount-1);
            }
            else{
                valueCountMap.remove(toBeRemoved);
            }
        }
        if(toBeAdded != null){
            Integer addCount = valueCountMap.get(toBeAdded);
            if(addCount==null){
                valueCountMap.put(toBeAdded,1);
            }
            else{
                valueCountMap.put(toBeAdded,addCount+1);
            }

        }


        int[] newArr = new int[d];
        int count=0;
        for(Integer key : valueCountMap.keySet()){
            int countVal = valueCountMap.get(key);
            for(int j=0;j<countVal;j++){
                newArr[count]=key;
                count++;
            }
        }
        return newArr;

    }



     static File file = new File("/Users/sajit.kunnumkal/Desktop/input02f.txt");
     public static void main(String[] args){

         try(Scanner scanner=new Scanner(file)) {
             try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

                 String[] nd = scanner.nextLine().split(" ");

                 int n = Integer.parseInt(nd[0]);

                 int d = Integer.parseInt(nd[1]);

                 int[] expenditure = new int[n];

                 String[] expenditureItems = scanner.nextLine().split(" ");
                 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                 for (int i = 0; i < n; i++) {
                     int expenditureItem = Integer.parseInt(expenditureItems[i]);
                     expenditure[i] = expenditureItem;
                 }

                 int result = activityNotifications(expenditure, d);

                 bufferedWriter.write(String.valueOf(result));
                 bufferedWriter.newLine();

                 bufferedWriter.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }





    }
}
