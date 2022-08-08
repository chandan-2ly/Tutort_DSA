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
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);

        ArrayList<ArrayList<Integer>> adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] item : prerequisites){
            adj.get(item[0]).add(item[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i])
                if(bfsCycleExist(i, visited, adj))
                    return false;
        }
        return true;
    }

    private static boolean bfsCycleExist(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            if(adj.get(u).size() > 0)
            {
                for(Integer next : adj.get(u)){
                    if(!visited[next]){
                        queue.add(next);
                        visited[next] = true;
                    }
                    else
                        return true;
                }
            }

        }
        return false;
    }
}
