package hackerrank.algo.friends.circle;

import java.io.*;
import java.util.*;


public class FriendsCircle {

    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {

        int[] maxSizes = new int[queries.length];
        Comparator<Set<Integer>> intSetComparator  = (set1,set2) -> set2.size()-set1.size();
        Set<Set<Integer>> friendsCircles = new HashSet<>();
        for(int i=0;i<queries.length;i++){
            int a = queries[i][0];
            int b = queries[i][1];
            Set<Integer> aFriends = null;
            Set<Integer> bFriends = null;
            for(Set<Integer> friends : friendsCircles) {
                if(friends.contains(a)) {
                    aFriends = friends;
                }
                if(friends.contains(b)) {
                    bFriends = friends;
                }
                if(aFriends != null && bFriends != null){
                    break;
                }
            }
            if(aFriends==null){
                aFriends = new HashSet<>(Arrays.asList(a));
            }
            if(bFriends==null) {
                bFriends = new HashSet<>(Arrays.asList(b));
            }
            Set<Integer> newSet = new HashSet<>();
            newSet.addAll(aFriends);
            newSet.addAll(bFriends);

            friendsCircles.remove(bFriends);
            friendsCircles.remove(aFriends);

            friendsCircles.add(newSet);
            printSet(friendsCircles);
            int maxSize=0;
            for(Set<Integer> friendSet : friendsCircles){
                if(friendSet.size()>maxSize){
                    maxSize = friendSet.size();
                }
            }
            maxSizes[i] = maxSize;
        }

        return maxSizes;


    }

    private static void printSet(Set<Set<Integer>> circles) {
        System.out.println("Printing out all sets..");
        for(Set<Integer> friends : circles){
            System.out.println("Next set");
            for(int i : friends){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.print("*******");
    }

    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        Arrays.sort(a);
        Arrays.sort(b);
        int numOfNums = 0;
        for(int i=a[a.length-1];i<=b[0];i++) {
            boolean satisfies = true;
            for(int j=0;j<a.length;j++){
                if(i%a[j]!=0){
                    satisfies = false;
                    break;
                }
            }
            if(satisfies){
                for(int j=0;j<b.length;j++){
                    if(b[j]%i!=0){
                        satisfies = false;
                        break;
                    }
                }
            }
            if(satisfies){
                numOfNums++;
            }
        }
        return numOfNums;

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(getTotalX(new int[]{2,6},new int[] {24,36}));
        System.out.println(getTotalX(new int[]{2,4},new int[]{16,32,96}));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] queriesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int queriesItem = Integer.parseInt(queriesRowItems[j]);
                    queries[i][j] = queriesItem;
                }
            }

            int[] ans = maxCircle(queries);

            for (int i = 0; i < ans.length; i++) {
                bufferedWriter.write(String.valueOf(ans[i]));

                if (i != ans.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();

            bufferedWriter.close();
        }

        scanner.close();
    }
}
