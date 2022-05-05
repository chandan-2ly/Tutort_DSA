package ArraysAndStrings;

import java.util.Objects;

public class ValidTic_Tac_Toe_State {
    public static void main(String[] args){
        String[] board = {"XXX","   ","OOO"};
        boolean result = isStateValid(board);
        System.out.println(result);
    }

    private static boolean isStateValid(String[] board) {
        int xMoves = getMovesCount(board, 'X');
        int oMoves = getMovesCount(board, 'O');

        boolean xWin = false;
        boolean oWin = false;

        //check winners
        for(int i = 0; i < board.length; i++){
            String row = board[i];
            String col = "" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i);

            if(row.equals("XXX") || col.equals("XXX")) xWin = true;
            else if(row.equals("OOO") || col.equals("OOO")) oWin = true;
        }

        //diagonals
        String diag = "" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2);
        String antiDiag = "" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0);

        if(diag.equals("XXX") || antiDiag.equals("XXX")) xWin = true;
        else if(diag.equals("OOO") || antiDiag.equals("OOO")) oWin = true;

        if (xWin) return !oWin && (oMoves + 1 == xMoves);
        if (oWin) return !xWin && (xMoves == oMoves);
        return xMoves == oMoves || oMoves + 1 == xMoves;
    }

    private static int getMovesCount(String[] board, char player) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == player) count++;
            }
        }
        return count;
    }
}
