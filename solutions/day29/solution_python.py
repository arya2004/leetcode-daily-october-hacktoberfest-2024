class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        def dfs(r, c, grid, mem):
            if mem[r][c] != -1:
                return mem[r][c]

            max_moves = 0
            if r - 1 >= 0 and c + 1 < len(grid[0]) and grid[r - 1][c + 1] > grid[r][c]:
                max_moves = 1 + dfs(r - 1, c + 1, grid, mem)
            if c + 1 < len(grid[0]) and grid[r][c + 1] > grid[r][c]:
                max_moves = max(max_moves, 1 + dfs(r, c + 1, grid, mem))
            if r + 1 < len(grid) and c + 1 < len(grid[0]) and grid[r + 1][c + 1] > grid[r][c]:
                max_moves = max(max_moves, 1 + dfs(r + 1, c + 1, grid, mem))
            
            mem[r][c] = max_moves
            return max_moves

        rows = len(grid)
        cols = len(grid[0])
        mem = [[-1] * cols for _ in range(rows)]

        max_moves = 0
        for i in range(rows):
            max_moves = max(max_moves, dfs(i, 0, grid, mem))
        
        return max_moves