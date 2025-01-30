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

    void solve(List<List<String>> list, List<StringBuilder> board, int i, int n) {
        if (i == n) {
            // Convert the board from StringBuilder to String
            List<String> valboard = new ArrayList<>();
            for (StringBuilder sb : board) {
                valboard.add(sb.toString());
            }
            list.add(valboard);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (valid(board, i, j, n)) {
                // Place queen at position (i, j)
                board.get(i).setCharAt(j, 'Q');
                // Recurse to the next row
                solve(list, board, i + 1, n);
                // Backtrack and remove queen
                board.get(i).setCharAt(j, '.');
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();

        // Handle the base case when n == 1
        if (n == 1) {
            List<String> solution = new ArrayList<>();
            solution.add("Q");  // Only one solution when n == 1
            list.add(solution);
            return list;
        }

        List<StringBuilder> l = new ArrayList<>();
        // Initialize the board with empty rows of size n
        for (int i = 0; i < n; i++) {
            l.add(new StringBuilder(".".repeat(n))); // Use the correct board size
        }
        solve(list, l, 0, n);
        return list;
    }
}
