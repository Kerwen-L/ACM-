/*
 * @lc app=leetcode.cn id=959 lang=java
 *
 * [959] 由斜杠划分区域
 */

// @lc code=start
class Solution {
    private int n = 0;
    public int regionsBySlashes(String[] grid) {
        n = grid[0].length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = 0;
            }
        }
        //dp: 0-> 未被访问; 1-> 左下；2左上；3-> 右上；4->右下;5 满
   

        int ans = 0;
     
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if(dp[i][j] == 5){
                    continue;
                }
                if(dp[i][j] == 0){
                    if(grid[i].charAt(j)!=' '){
                        ans += 1;
                    }
                    this.DFS(i, j, dp, grid, 3);
                    this.DFS(i, j, dp, grid, 4);
                }
                else if(dp[i][j] == 1 ||dp[i][j] == 2){
                    this.DFS(i, j, dp, grid, 4);
                }
                else if(dp[i][j] == 3 ||dp[i][j] == 4){
                    this.DFS(i, j, dp, grid, 3);
                }
                ans += 1; 
            } 
        }


        return ans;

    }


    //from: 0->中间,1->上,2->下,3->左,4->右
    public boolean DFS(int x, int y, int[][] dp, String[] grid,int from){
        

        if(grid[x].charAt(y) == ' '){
            if(dp[x][y] == 5){
                return false;
            }
            dp[x][y] = 5;
            if( x-1 >=0){
                this.DFS(x-1, y, dp, grid, 2);
            }
            if( x+1 < n){
                this.DFS(x+1, y, dp, grid, 1);
            }
            if( y-1 >=0){
                this.DFS(x, y-1, dp, grid, 4);
            }
            if( y+1 < n){
                this.DFS(x, y+1, dp, grid, 3);
            }  
            return true;

        }
        else if(grid[x].charAt(y) == '\\'){
            if(from == 3 || from == 2 ){
                if(dp[x][y] == 1 || dp[x][y] == 5){
                    return false;
                }else{
                    if(dp[x][y] == 0){
                        dp[x][y] = 1;
                    }else{
                        dp[x][y] = 5;
                    }
                }
                if( y-1 >=0){
                    this.DFS(x, y-1, dp, grid, 4);
                }
                if( x+1 < n){
                    this.DFS(x+1, y, dp, grid, 1);
                }
                
            }else{
                if(dp[x][y] == 3 || dp[x][y] == 5){
                    return false;
                }else{
                    if(dp[x][y] == 0){
                        dp[x][y] = 3;
                    }else{
                        dp[x][y] = 5;
                    }
                }
                if( x-1 >=0){
                    this.DFS(x-1, y, dp, grid, 2);
                }
                if( y+1 < n){
                    this.DFS(x, y+1, dp, grid, 3);
                }   
            }

        }else{
            if(from == 3 || from == 1 ){
                if(dp[x][y] == 2 || dp[x][y] == 5){
                    return false;
                }else{
                    if(dp[x][y] == 0){
                        dp[x][y] = 2;
                    }else{
                        dp[x][y] = 5;
                    }
                }
                if( y-1 >=0){
                    this.DFS(x, y-1, dp, grid, 4);
                }
                if( x-1 >=0){
                    this.DFS(x-1, y, dp, grid, 2);
                }
                
            }else{
                if(dp[x][y] == 4 || dp[x][y] == 5){
                    return false;
                }else{
                    if(dp[x][y] == 0){
                        dp[x][y] = 4;
                    }else{
                        dp[x][y] = 5;
                    }
                }
                if( x+1 < n){
                    this.DFS(x+1, y, dp, grid, 1);
                }
                if( y+1 < n){
                    this.DFS(x, y+1, dp, grid, 3);
                }   
            }

        }
 
        return false;
    }
}
// @lc code=end

