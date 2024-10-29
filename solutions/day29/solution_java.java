class Solution {
    private int maxMoves(int r, int c, int[][] grid, int[][] mem) {
        if (mem[r][c] != -1) return mem[r][c];

        int maxMoves = 0;
        if (r - 1 >= 0 && c + 1 < grid[0].length && grid[r - 1][c + 1] > grid[r][c]) {
            maxMoves = 1 + maxMoves(r - 1, c + 1, grid, mem);
        }
        if (c + 1 < grid[0].length && grid[r][c + 1] > grid[r][c]) {
            maxMoves = Math.max(maxMoves, 1 + maxMoves(r, c + 1, grid, mem));
        }
        if (r + 1 < grid.length && c + 1 < grid[0].length && grid[r + 1][c + 1] > grid[r][c]) {
            maxMoves = Math.max(maxMoves, 1 + maxMoves(r + 1, c + 1, grid, mem));
        }
        
        mem[r][c] = maxMoves;
        return maxMoves;
    }
    
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] mem = new int[rows][cols];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        int maxMoves = 0;
        for (int i = 0; i < rows; ++i) {
            maxMoves = Math.max(maxMoves, maxMoves(i, 0, grid, mem));
        }
        
        return maxMoves;
    }
}