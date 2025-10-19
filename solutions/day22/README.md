# Day 22: 2583. Kth Largest Sum in a Binary Tree

## Problem Description
You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

## Solution Approach
- **BFS Level Order Traversal**: Use queue to process each level
- **Level Sum Calculation**: Sum all node values at each level
- **Min Heap**: Maintain k largest level sums efficiently
- **Time Complexity**: O(n log k) - n nodes, k for heap operations
- **Space Complexity**: O(m) - m levels in the tree

## Example
Input: root = [5,8,9,2,1,3,7,4,6], k = 2
Level sums:
Level 0: 5
Level 1: 8 + 9 = 17
Level 2: 2 + 1 + 3 + 7 = 13
Level 3: 4 + 6 = 10
2nd largest level sum = 13
Output: 13

## Java Solution
See `solution_java.java` for the implementation using BFS and min heap.