package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Dijkstra_Algo {
    public static void main(String[] args){
        int V = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        //adj.set(0, new ArrayList<>());

        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(0).add(1);
        adj.get(0).get(0).add(1);

        adj.get(0).add(new ArrayList<>());
        adj.get(0).get(1).add(2);
        adj.get(0).get(1).add(6);

        adj.add(new ArrayList<>());

        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(0).add(2);
        adj.get(1).get(0).add(3);

        adj.get(1).add(new ArrayList<>());
        adj.get(1).get(1).add(0);
        adj.get(1).get(1).add(1);

        adj.add(new ArrayList<>());

        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(0).add(1);
        adj.get(2).get(0).add(3);

        adj.get(2).add(new ArrayList<>());
        adj.get(2).get(1).add(0);
        adj.get(2).get(1).add(6);

        int src = 2;

        int[] result = dijkstra(V, adj, src);
        System.out.println(Arrays.toString(result));
    }

    private static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        HashSet<Integer> set = new HashSet();
        int[] distance = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;

        for(int i = 0; i < V-1; i++){       //no need to process last node
            int u = getMinimumNode(distance, set);
            set.add(u);

            for(int j = 0; j < V; j++){
                if(adj.get(u).size() > j){
                    ArrayList<Integer> conn = ((adj.get(u)).get(j));
                    int k = conn.get(0);
                    int edge = conn.get(1);


                    // Update distance[j] only if j is not in set, edge is present from u to j
                    if(!set.contains(k) && edge != 0 && distance[u] != Integer.MAX_VALUE && ((distance[u] + edge) < distance[k] )){
                        distance[k] = distance[u] + edge;
                    }
                }

            }
        }

        return distance;
    }
    private static int getMinimumNode(int[] distance, HashSet<Integer> set){
        int min = Integer.MAX_VALUE;
        int pos = -1;
        for(int i = 0; i < distance.length; i++){
            if(!set.contains(i) && distance[i] <= min){
                min = distance[i];
                pos = i;
            }
        }
        return pos;
    }
}
