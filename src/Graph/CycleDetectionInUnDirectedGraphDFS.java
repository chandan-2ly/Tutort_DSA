package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInUnDirectedGraphDFS {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //Test case 1
        /*int V = 5;
        adj.add(new ArrayList<>());
        adj.get(0).add(1);

        adj.add(new ArrayList<>());
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);

        adj.add(new ArrayList<>());
        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.add(new ArrayList<>());
        adj.get(3).add(2);
        adj.get(3).add(4);

        adj.add(new ArrayList<>());
        adj.get(4).add(1);
        adj.get(4).add(3);*/

        //test case 2
        int V = 4;
        adj.add(new ArrayList<>());

        adj.add(new ArrayList<>());
        adj.get(1).add(2);

        adj.add(new ArrayList<>());
        adj.get(2).add(1);
        adj.get(2).add(3);

        adj.add(new ArrayList<>());
        adj.get(3).add(2);

        boolean result = isCycleExistDFS(adj, V);
        System.out.println(result);
    }

    private static boolean isCycleExistDFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];

        Arrays.fill(visited, false);

        for(int i = 0; i < v; i++){
            if(!visited[i]){
                if(dsfCycleExist(adj, visited, i, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean dsfCycleExist(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src, int parent) {
        visited[src] = true;

            if(adj.get(src).size() > 0) {
                for (Integer next : adj.get(src)) {
                    if (!visited[next]) {
                        if(dsfCycleExist(adj, visited, next, src))
                            return true;
                    }
                    else if (next != parent)
                        return true;
                }
            }
        return false;
    }
}
