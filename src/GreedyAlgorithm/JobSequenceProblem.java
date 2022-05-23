package GreedyAlgorithm;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
class Job {
    int id;
    int profit;
    int deadline;
    Job(int _id, int _deadline, int _profit){
        id = _id;
        profit = _profit;
        deadline = _deadline;
    }
}
public class JobSequenceProblem {
    public static void main(String[] args){
        int n = 4;
        Job[] Jobs = {
                new Job(1,4,20),
                new Job(2,1,10),
                new Job(3,1,40),
                new Job(4,1,30)
        };

        int[] result = getJobsWithMaxProfit(Jobs, n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] getJobsWithMaxProfit(Job[] arr, int n) {
        Arrays.sort(arr, (a,b) -> b.profit - a.profit);
        int maxDeadline = getMaxDeadline(arr);
        int[] jobDone = new int[maxDeadline];
        Arrays.fill(jobDone, -1);
        int profit = 0;
        int jobCount = 0;
        for (Job job : arr){
            int i = job.deadline - 1;
            while (i >= 0 && jobDone[i] != -1){
                i--;
            }
            if(i >= 0)
            {
                jobDone[i] = job.id;
                jobCount++;
                profit += job.profit;
            }
        }
        return new int[]{jobCount, profit};
    }

    private static int getMaxDeadline(Job[] arr) {
        int max = arr[0].deadline;
        for (Job job : arr){
            max = Math.max(job.deadline, max);
        }
        return max;
    }
}
