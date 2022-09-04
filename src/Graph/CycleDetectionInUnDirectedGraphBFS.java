package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInUnDirectedGraphBFS {
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
//        int V = 4;
//        adj.add(new ArrayList<>());
//
//        adj.add(new ArrayList<>());
//        adj.get(1).add(2);
//
//        adj.add(new ArrayList<>());
//        adj.get(2).add(1);
//        adj.get(2).add(3);
//
//        adj.add(new ArrayList<>());
//        adj.get(3).add(2);

        //test case 3
        adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(0);

        int V = 2;
        boolean result = isCycleExistBFS(adj, V);
        System.out.println(result);
    }

    private static boolean isCycleExistBFS(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];

        Arrays.fill(visited, false);

        for(int i = 0; i < v; i++){
            if(!visited[i]){
                if(bsfCycleExist(adj, visited, i))
                    return true;
            }
        }
        return false;
    }

    private static boolean bsfCycleExist(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            if(adj.get(pair.node).size() > 0){
                for(Integer next : adj.get(pair.node)){
                    if(!visited[next]){
                        queue.add(new Pair(next, pair.node));
                        visited[next] = true;
                    }
                    else if(next != pair.parent)
                        return true;
                }
            }
        }
        return false;
    }
    static class Pair{
        int node;
        int parent;
        Pair(int _node, int _parent){
            node = _node;
            parent = _parent;
        }
    }
}
