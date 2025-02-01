class Solution {
    public void dfs(char[][] board, boolean[][] vis, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || vis[i][j]) {
            return;
        }
        vis[i][j] = true;

        dfs(board, vis, i + 1, j, m, n);
        dfs(board, vis, i - 1, j, m, n);
        dfs(board, vis, i, j + 1, m, n);
        dfs(board, vis, i, j - 1, m, n);
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        // Perform DFS on boundary 'O's
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, vis, i, 0, m, n);
            if (board[i][n - 1] == 'O') dfs(board, vis, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, vis, 0, j, m, n);
            if (board[m - 1][j] == 'O') dfs(board, vis, m - 1, j, m, n);
        }

        // Convert non-visited 'O' to 'X', and revert visited back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}