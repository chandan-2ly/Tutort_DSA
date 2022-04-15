package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/rank-teams-by-votes/
public class RankTeamByVotes {
    public static void main(String[] args){
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String result = getTopRankedTeam(votes);
        System.out.println(result);
    }

    private static String getTopRankedTeam(String[] votes) {
        if(votes.length == 1) return votes[0];
        int n = votes[0].length();
        String ans = "";

        int[][] freq = new int[26][n];

        for(int i = 0; i < votes.length; i++){
            for(int j = 0; j < n; j++){
                freq[votes[i].charAt(j) - 'A'][j]++;
            }
        }

        List<Character> posList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            posList.add(votes[0].charAt(i));
        }

        posList.sort((a,b) -> {
            int[] first = freq[a -'A'];
            int[] second = freq[b - 'A'];

            for(int i = 0; i < n; i++){
                if (first[i] == second[i]) {
                    continue;
                }
                return second[i] - first[i];
            }
            return a - b;
        });

        for(int i = 0; i < posList.size(); i++){
            ans += String.valueOf(posList.get(i));
        }

        return ans;
    }

    
}
