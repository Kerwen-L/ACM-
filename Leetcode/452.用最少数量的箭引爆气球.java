import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Compare implements Comparator< int[]>{
    @Override
    public int compare(int[] a,int[] b){
        return a[1]>b[1]? 1:-1;
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        if( points.length == 0){
            return 0;
        }
        Arrays.sort(points,new Compare());

        // for (int i = 0; i < points.length; i++) {
        //     for (int j = 0; j < points[0].length; j++) {
        //         System.out.print(points[i][j]+ "  ");
        //     }
        //     System.out.println();
        // }

        int ans = 0;
        long right = ((long)points[0][0]-1);
        for (int i = 0; i < points.length; i++) {
            if( points[i][0] > right){
                ans += 1;
                right =  (long)points[i][1];
            }
        }

        return ans;

    }
}

// @lc code=end

