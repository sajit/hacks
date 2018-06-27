package hackerrank.algo.sort;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Fraud {

    public static double findMedian(int[] array, int d,Map<Integer,Integer> freqIdxExpenseMap){
        int count=0;
        int i=-1;
        while(count<=d/2){
            i++;
            count += array[i];


        }
        if(d%2==0){
            double mid1 = (double)freqIdxExpenseMap.get(i);
            double mid2 = mid1;
            if(array[i]<=1 && i>=1){
                mid2 = (double)freqIdxExpenseMap.get(i-1);
            }

            return (mid1+mid2)/(double)2;
        }
        else{
            return freqIdxExpenseMap.get(i);
        }

    }


    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int[] sortedExpArr = Arrays.stream(expenditure).distinct().sorted().toArray();
        //map of expenditure to its index in freq Map
        Map<Integer,Integer> expenseIdxMap = new HashMap<>();

        //Map of index in freq map to Expenditure
        Map<Integer,Integer> freqIdxExpenseMap = new HashMap<>();
        for(int i=0;i<sortedExpArr.length;i++){
            expenseIdxMap.put(sortedExpArr[i],i);
        }
        int[] freqMap = new int[sortedExpArr.length];
        int count=0;

        for(int i=0;i<d;i++){
            addToFreqMap(expenditure[i], expenseIdxMap.get(expenditure[i]), freqIdxExpenseMap, freqMap);
        }

        for(int i=d;i<expenditure.length;i++){

            double median = findMedian(freqMap,d,freqIdxExpenseMap);

            if(expenditure[i]>=2*median){
                count++;
            }
            addToFreqMap(expenditure[i],expenseIdxMap.get(expenditure[i]),freqIdxExpenseMap,freqMap);
            int toBeRemovedExpense = expenditure[i-d];
            int freqMapIdx = expenseIdxMap.get(toBeRemovedExpense);
            freqMap[freqMapIdx] = freqMap[freqMapIdx]-1;


        }
        return count;
    }

    private static void addToFreqMap(int expenditure, Integer freqMapIdx, Map<Integer, Integer> freqIdxExpenseMap, int[] freqMap) {
        freqMap[freqMapIdx] = freqMap[freqMapIdx]+1;
        freqIdxExpenseMap.put(freqMapIdx, expenditure);
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

//        int[] exp = {1,2,3,4,4};
//        System.out.println(activityNotifications(exp,4));
//        Map<Integer,Integer> map = new HashMap<>();
//        map.put(0,2);
//        map.put(1,3);
//        map.put(2,4);
//        map.put(3,5);

        //System.out.println(findMedian(new int[]{3,1,1,1,0,0,0},6,map));
    }
}
