import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) { 
        Arrays.sort(A); 
        int lens = A.length;
        int sums =  A[lens-3] + A[lens-2] + A[i-1];
        for (int i = lens ; i >= 3; i--) {
            int ans = 0;
            int a = A[i-3];
            int b = A[i-2];
            int c = A[i-1];
            System.out.println(i);
            if( (ans = A[i-3] + A[i-2]) > c ){ 
                return a+b+c;
            } 
        }
         
        return 0;
 
    }
}
// @lc code=end

