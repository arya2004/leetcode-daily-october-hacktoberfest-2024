# 2684. Maximum Number of Moves in a Grid

## problem statement:

You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.

Return the maximum number of moves that you can perform.

### examples
1) Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

2) Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.

# solution
1) Define a DFS function that computes the max moves from a cell if it has not been visited (memoized).
2) Check valid directions (top-right, right, bottom-right) where the next cell is greater than the current cell.
3) Update max moves from each cell by taking 1 + the result of DFS on the next cell.
4) Memoize the result for each cell to avoid recomputation.
5) Iterate over the first column of each row, using DFS to find the maximum path length starting from each cell in the first column.

## dry run
grid = [[1,2,3],[6,5,4],[7,8,9]].

Start at grid[0][0] = 1:
Check the right cell grid[0][1] = 2, which is greater than 1, so move right.
Next, move to grid[0][2] = 3 (greater than 2).
Path length from (0,0): 2 (right-right path).

Starting from grid[1][0] = 6:
Move top-right to grid[0][1] = 2 (not greater than 6) is invalid.
Move right to grid[1][1] = 5 (not greater than 6) is invalid.
Move bottom-right to grid[2][1] = 8 (greater than 6) → grid[2][2] = 9 (greater than 8).
Path length from (1,0): 2 (bottom-right path).

Compute other paths similarly to find the longest valid path.

### Time complexity:
=> O(R×C), where R is the number of rows and C is the number of columns. Each cell is processed once due to memoization

#### Space complexity:
=> O(R×C) for the memoization array mem