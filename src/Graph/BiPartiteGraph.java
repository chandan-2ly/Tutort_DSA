package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraph {
    public static void main(String[] args){
        int[][] graph = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] graph2 = {{1,3}, {0,2}, {1,3}, {0,2}};
        boolean result = isBipartiteBFS(graph2);
        System.out.println(result);

        boolean resultDfs = isBipartiteDFS(graph2);
        System.out.println(resultDfs);
    }

    private static boolean isBipartiteDFS(int[][] graph) {
        int[] isColoured = new int[graph.length];
        Arrays.fill(isColoured, -1);

        for(int i = 0; i < graph.length; i++){
            if(isColoured[i] == -1){
                isColoured[i] = 1;
                if(!isBipartiteDfs(graph, isColoured, i))
                    return false;
            }
        }
        return true;
    }

    private static boolean isBipartiteDfs(int[][] graph, int[] isColoured, int node) {
        if(graph[node].length > 0) {
            for (Integer next : graph[node]) {
                if(isColoured[next] == -1){
                    isColoured[next] = 1 - isColoured[node];
                    if(!isBipartiteDfs(graph, isColoured, next)){
                        return false;
                    }
                }
                else if(isColoured[next] == isColoured[node])
                    return false;
            }
        }
        return true;
    }

    private static boolean isBipartiteBFS(int[][] graph) {
        int[] isColoured = new int[graph.length];
        Arrays.fill(isColoured, -1);

        for(int i = 0; i < graph.length; i++){
            if(isColoured[i] == -1){
                if(!isBipartiteBfs(graph, isColoured, i))
                    return false;
            }
        }
        return true;
    }

    private static boolean isBipartiteBfs(int[][] graph, int[] isColoured, int src) {
        Queue<Integer> queue = new LinkedList<>();

        isColoured[src] = 1;
        queue.add(src);

        while(!queue.isEmpty()){
            int node = queue.poll();

            if(graph[node].length > 0){
                for(Integer next : graph[node]){
                    if(isColoured[next] == -1){
                        isColoured[next] = 1 - isColoured[node];
                        queue.add(next);
                    }
                    else if(isColoured[next] == isColoured[node])
                        return false;
                }
            }
        }
        return true;
    }
}
