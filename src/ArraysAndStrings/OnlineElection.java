package ArraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

//https://leetcode.com/problems/online-election/
public class OnlineElection {
    public static void main(String[] args){
        int[] persons = {0,1,0,1,1};
        int[] times = {24,29,31,76,81};
        int[] query = {28,24,29,77,30,25,76,75,81,80};
//        int[] query = {15,24,8};
        int[] ans = new int[query.length];
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);

        for(int i = 0; i < query.length; i++){
            ans[i] = obj.q(query[i]);
        }

        System.out.println(Arrays.toString(ans));
    }
}
class TopVotedCandidate {

    int[] persons;
    int[] times;
    int[] topVote;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;

        this.topVote = new int[persons.length];

        HashMap<Integer, Integer> map = new HashMap();
        int maxVote = 1;
        int maxVotedCandidate = persons[0];
        map.put(persons[0], map.getOrDefault(persons[0], 0) + 1);
        for(int i = 1; i < persons.length; i++){
            map.put(persons[i], map.getOrDefault(persons[i], 0)+ 1);
            if(map.get(persons[i]) >= maxVote){
                maxVote = map.get(persons[i]);
                maxVotedCandidate = persons[i];
            }
            topVote[i] = maxVotedCandidate;
        }
    }

    public int q(int t) {
        //binary Search
        int low = 0, high = times.length - 1;
        int topVotedCandidateIndex = -1;
        int mid = -1;
        while(low <= high){
            mid = (low + high)/2;
            if(t == times[mid]){
                topVotedCandidateIndex = mid;
                break;
            }
            else if(t > times[mid]){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if(topVotedCandidateIndex == -1){
            if(low == (mid+1) )
                topVotedCandidateIndex = mid;
            else if(high == (mid-1))
                topVotedCandidateIndex = mid-1;
        }


        return topVote[topVotedCandidateIndex];
    }
}
