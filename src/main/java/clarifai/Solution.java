package clarifai;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    // Complete the roadsAndLibraries function below.

    static Map<Integer,Integer> addEdge(Set<Map<Integer,Integer>> graph,int startNode,int destNode) {
        for(Map<Integer,Integer> partition : graph){
            Set<Integer> vertices = partition.keySet();
            if(vertices.contains(startNode) || vertices.contains(destNode)){
                Integer connectedEdges1 = partition.get(startNode);
                connectedEdges1 = (connectedEdges1==null)?0:connectedEdges1;
                partition.put(startNode,connectedEdges1+1);
                Integer connectedEdges2 = partition.get(destNode);
                connectedEdges2 = (connectedEdges2==null)?0:connectedEdges2;
                partition.put(destNode,connectedEdges2+1);
                return partition;
            }
        }
        Map<Integer,Integer> newParition = new HashMap<>();
        newParition.put(startNode,1);
        newParition.put(destNode,1);
        graph.add(newParition);
        return newParition;

    }
    static int roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        Set<Map<Integer,Integer>> graph = new HashSet<>();
        for(int i=0;i<cities.length;i++){
            int start = cities[i][0];
            int dest = cities[i][1];
            addEdge(graph,start,dest);
        }
        int leastCost = 0;
        for(Map<Integer,Integer> partition : graph){
            leastCost += calcLeastCost(partition,c_lib,c_road);
        }
        return leastCost;
    }

    private static int calcLeastCost(Map<Integer, Integer> graphPartition, int c_lib, int c_road) {
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<graphPartition.size();i++){
            int costForCombo = (i+1)*c_lib+(graphPartition.size()-1-i)*c_road;
            if(costForCombo<minCost){
                minCost = costForCombo;
            }
        }
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                String[] nmC_libC_road = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nmC_libC_road[0]);

                int m = Integer.parseInt(nmC_libC_road[1]);

                int c_lib = Integer.parseInt(nmC_libC_road[2]);

                int c_road = Integer.parseInt(nmC_libC_road[3]);

                int[][] cities = new int[m][2];

                for (int i = 0; i < m; i++) {
                    String[] citiesRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 2; j++) {
                        int citiesItem = Integer.parseInt(citiesRowItems[j]);
                        cities[i][j] = citiesItem;
                    }
                }

                int result = roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }

        scanner.close();
    }
}
