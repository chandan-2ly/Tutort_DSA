package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_DetectCycleInDirectedGraph {
    public static void main(String[] args){
        int[][] prerequisites = {{1,0}};
        int numCourses = 2;
        
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);

        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] item : prerequisites){
            adj.get(item[0]).add(item[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0)
                if(bfsCycleExist(i, visited, adj))
                    return false;
        }
        return true;
    }

    private static boolean bfsCycleExist(int src, int[] visited, ArrayList<ArrayList<Integer>> adj) {
//        if(visited[src] == 2)
//            return true;
        //visited[src] = 2;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = 2;

        while(!queue.isEmpty()){
            int u = queue.poll();
            if(adj.get(u).size() > 0)
            {
                for(Integer next : adj.get(u)){
                    if(visited[next] > 0)
                        return true;
                    else {
                        queue.add(next);
                        visited[next] = 2;
                    }
                }
            }
            visited[u] = 1;
        }
        return false;
    }
}
