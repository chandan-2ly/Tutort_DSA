package ArraysAndStrings;

public class ValidTic_Tac_Toe_State {
    public static void main(String[] args){
        String[] board = {"XOX"," X ","   "};
        boolean result = isStateValid(board);
        System.out.println(result);
    }

    private static boolean isStateValid(String[] board) {
        boolean xMove = true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < 3; j++){
                char nextMove = xMove ? 'X' : 'O';
                if(board[i].charAt(j) != ' ' && board[i].charAt(j) != nextMove)
                    return false;

                xMove = !xMove;
            }
        }
        return true;
    }
}
