public class TicTacToe {
    public static String checkWinner(int[][] board) {
        // Checking the rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 1) return "X wins";
                if (board[i][0] == -1) return "O wins";
            }
        }

        // Checking the columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 1) return "X wins";
                if (board[0][i] == -1) return "O wins";
            }
        }

        // Checking diagonally
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 1) return "X wins";
            if (board[0][0] == -1) return "O wins";
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 1) return "X wins";
            if (board[0][2] == -1) return "O wins";
        }

        return "No winner";
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, 0, 1},
                {0, -1, 1},
                {0, 0, -1}
        };

        System.out.println(checkWinner(board));
    }
}
