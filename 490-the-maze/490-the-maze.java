// Time Complexity : O(m*n(m+n))
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        
        int m = maze.length;
        int n =maze[0].length;
        
        maze[start[0]][start[1]] = 2;
        row.add(start[0]);
        column.add(start[1]);
        
        int[][] dirs = {{0,-1},{0,1},{1,0},{-1,0}}; 
        while(!row.isEmpty()){
            
            int currRow = row.poll();
            int currCol = column.poll();
            
            for(int[] dir: dirs){
                int newRow = currRow;
                int newCol = currCol;
                
                while(newRow < m && newRow >=0 && newCol < n && newCol >= 0 && maze[newRow][newCol] != 1){
                    newRow += dir[0];
                    newCol += dir[1];
                    
                }
                newRow -= dir[0];
                newCol -= dir[1];
                
                if(newRow == destination[0] && newCol == destination[1]){
                    return true;
                }
                
                if(maze[newRow][newCol] != 2){
                    maze[newRow][newCol] = 2;
                    row.add(newRow);
                    column.add(newCol);
                    
                }
                
            }
            
            
        }
        return false;
    }
}