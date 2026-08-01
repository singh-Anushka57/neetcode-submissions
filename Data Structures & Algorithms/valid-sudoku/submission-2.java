class Solution {
    public boolean isValidSudoku(char[][] board) {
        //for row
        for(int i=0;i<9;i++){
            HashSet<Character> row=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')
                continue;
                if(row.contains(board[i][j]))
                return false;
                row.add(board[i][j]);
            }
        }
        //for column
        for(int j=0;j<9;j++){
                HashSet<Character> col=new HashSet<>();
                for(int i=0;i<9;i++){
                    if(board[i][j]=='.')
                    continue;
                    if(col.contains(board[i][j]))
                    return false;
                    col.add(board[i][j]);
                }
        }
        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                HashSet<Character> box=new HashSet<>();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(board[i][j]=='.')
                        continue;
                        if(box.contains(board[i][j]))
                        return false;
                        box.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
