class Solution {
    boolean valid(List<StringBuilder> board, int i, int j, int n) { 
        // Check the column (upwards)
        for (int k = 0; k < i; k++) {
            if (board.get(k).charAt(j) == 'Q') return false;
        }

        // Upper-right diagonal check
        int x = i, y = j;
        while (x > 0 && y < n - 1) {  
            x--;
            y++;
            if (board.get(x).charAt(y) == 'Q') return false;
        }

        // Upper-left diagonal check
        x = i;
        y = j;
        while (x > 0 && y > 0) {  
            x--;
            y--;
            if (board.get(x).charAt(y) == 'Q') return false;
        }

        return true;  // Position is safe
    }
    void solve(List<List<String>> list,List<StringBuilder> board,int i,int n){
        if(i==n){
            List<String> valboard=new ArrayList<>();
            for(StringBuilder sb:board){
                valboard.add(sb.toString());
            }
            list.add(valboard);
            return;
        }
        for(int j=0;j<n;j++){
            if(valid(board,i,j,n)){
            board.get(i).setCharAt(j,'Q');
            solve(list,board,i+1,n);
            board.get(i).setCharAt(j,'.');
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        List<StringBuilder> l=new ArrayList<>();
        if(n==1){
            List<String> s=new ArrayList<>();
            s.add("Q");
            list.add(s);
            return list;
        }
        for(int i=0;i<n;i++){
            l.add(new StringBuilder(".".repeat(n)));        }
        solve(list,l,0,n);
        return list;
    }
}