class Solution {
public:
 vector<vector<string>> ans;  //2D array to store ans
    vector<vector<string>> solveNQueens(int n) {
        vector<string> board(n, string(n, '.')); //empty board
        rec(board, 0);
        return ans;
    }
    bool safe(vector<string>& board, int row, int col){
        int n = size(board);
        for(int i=0; i<n; i++){
     //3 cases to check where to place the Qn so no killing happens
     if(board[i][col] == 'Q') 
     return false; //Check if Queen in same col
     if(row-i>=0 && col-i>=0 && board[row-i][col-i] == 'Q') 
    return false; //diagnolly left up in backward direction: 45 deg
     if(row-i>=0 && col+i<n && board[row-i][col+i] == 'Q') 
     return false; //diagnolly right up in forward direction: 135 deg

        }
        return true; // For all other possiblities
    }
    void rec(vector<string>& board, int row){
        int l = size(board);
        if(row==l){ //Reached last row, we hv a solution
        ans.push_back(board);
         return;
        }
        for(int col=0; col<l; col++){
            if(safe(board, row, col)){
                board[row][col] = 'Q'; //Placed on a valid cell
                rec(board, row+1);  //move to next row
                //Backtracking to get all possible ways
                board[row][col] = '.';
            }
        }
    }
};
