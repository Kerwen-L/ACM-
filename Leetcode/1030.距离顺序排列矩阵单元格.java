import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import sun.tools.serialver.resources.serialver;

/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> ans = new ArrayList<int[]>();
        ans.add(new int[]{r0,c0});

        int[][] directions = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};

        for (int i = 1; i <= R+C-2; i++) {
            List<int[]> TT = new ArrayList<int[]>();
            for (int j = 0; j <= i; j++) {
                int x = j;
                int y = i-j; 
                for (int k = 0; k < 4; k++) {
                    int posx = r0+directions[k][0]*x;
                    int posy = c0+directions[k][1]*y;
                    if(posx>=0 && posx < R && posy >=0 && posy < C){
                        boolean sign = true;
                        for(int[] tt : TT){
                            if(tt[0] == posx && tt[1] == posy){
                                sign = false;
                                break;
                            }
                        }
                        if(sign){
                            int[] temp = new int[]{posx,posy};
                            TT.add( temp );
                        } 
                    }
                }     
            }
            ans.addAll(TT);
        }  
        return ans.toArray(new int[R*C][2]);
    }
}
// @lc code=end

