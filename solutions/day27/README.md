# Solution Approach
### Language Used: Java

The code uses dynamic programming to count all square submatrices of 1s in a given binary matrix. We create a DP array that keeps track of the largest square of 1s ending at each cell. If a cell contains a 1, we check its neighboring cells (top, left, and top-left) to determine the size of the square we can form. The value at each cell in the DP array tells us how many squares end there, and we sum these values to get the total count.

Let's use this example from leetcode:

` Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.`

- There are 10 1x1 squares (every 1 counts).
- There are 4 2x2 squares formed by groups of 1s.
- There is 1 3x3 square covering the entire bottom right block.
So, the `total number` of squares is 10 + 4 + 1 = `15`.


### Time complexity:
- O(*m* * *n*)

### Space complexity:
- O(*m* * *n*)
