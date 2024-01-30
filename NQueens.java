import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> sols = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            board.add(new String(new char[n]).replace('\0', '.'));
        }
        solve(board, 0);
        return sols;
    }

    private boolean isSafe(List<String> board, int row, int col) {
        int n = board.size();
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') return false;
            if (row - i >= 0 && col - i >= 0 && 
            board.get(row - i).charAt(col - i) == 'Q')
             return false;
            if (row - i >= 0 && col + i < n &&
             board.get(row - i).charAt(col + i) == 'Q') 
             return false;
        }
        return true;
    }

    private void solve(List<String> board, int row) {
        if (row == board.size()) {
            sols.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isSafe(board, row, col)) {
                board.set(row, board.get(row).substring(0, col) + 'Q' + 
                board.get(row).substring(col + 1));
                solve(board, row + 1);
                board.set(row, board.get(row).substring(0, col) + '.' + 
                board.get(row).substring(col + 1));
            }
        }
    }
}
