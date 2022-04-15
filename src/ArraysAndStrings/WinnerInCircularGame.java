package ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class WinnerInCircularGame {
    public static void main(String[] args){
        int n = 6;
        int k = 5;
        int winner = getWinnerInCircularGame(n, k);
        System.out.println(winner);
    }

    private static int getWinnerInCircularGame(int n, int k) {
        List<Integer> player = new ArrayList<>();
        for(int i = 0; i < n; i++){
            player.add(i+1);
        }

        int i = 0;
        int winner = 0;

        while(player.size() > 1){
            int playerToRemove = (i + k - 1) % player.size();
            i = playerToRemove;
            player.remove(playerToRemove);
        }
        winner = player.get(0);

        return winner;
    }


}
