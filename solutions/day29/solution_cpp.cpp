class Solution {
    int maxMoves(int r,int c,vector<vector<int>>& grid,vector<vector<int>>& mem){
        if(mem[r][c]!=-1)       return mem[r][c];

        int max_moves=0;
        if(r-1>=0 and c+1<grid[0].size() and grid[r-1][c+1]>grid[r][c])
            max_moves = 1 + maxMoves(r-1,c+1,grid,mem);
        if(c+1<grid[0].size() and grid[r][c+1]>grid[r][c])
            max_moves = max(max_moves, 1 + maxMoves(r,c+1,grid,mem));
        if(r+1<grid.size() and c+1<grid[0].size() and grid[r+1][c+1]>grid[r][c])
            max_moves = max(max_moves, 1 + maxMoves(r+1,c+1,grid,mem));
        
        return mem[r][c]=max_moves;
    }
public:
    int maxMoves(vector<vector<int>>& grid) {
        int r=grid.size();
        int c=grid[0].size();

        vector<vector<int>> mem(r,vector<int>(c,-1));
        int max_moves = 0;
        for(int i=0;i<r;++i)
            max_moves = max(max_moves, maxMoves(i,0,grid,mem));
        
        return max_moves;
    }
};