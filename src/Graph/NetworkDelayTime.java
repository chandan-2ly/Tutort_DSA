package Graph;

import java.util.*;

//https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime {
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        int delayTime = getNetworkDelayTime(times, n, k);
        System.out.println(delayTime);
    }

    private static int getNetworkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int[] time : times){
            int src = time[0];
            int dest = time[1];
            int wt = time[2];
            map.putIfAbsent(src, new HashMap<>());
            map.get(src).put(dest, wt);
        }

        int[] distance = new int[n+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{k, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int curNode = curr[0];
            int curWt = curr[1];

            for(int nextNode : map.getOrDefault(curNode, new HashMap<>()).keySet()){
                int nextWeight = map.get(curNode).get(nextNode);

                if(curWt + nextWeight < distance[nextNode]){
                    distance[nextNode] = curWt + nextWeight;
                    queue.add(new int[]{nextNode, curWt + nextWeight});
                }
            }
        }

        int max = -1;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}
