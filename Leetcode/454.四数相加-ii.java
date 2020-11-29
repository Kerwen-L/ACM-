import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        int lens = 0;
        if ( ( lens = A.length ) == 0){
            return ans;
        }
        Map<Integer,Integer> AB = new HashMap<>(); 
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lens; j++) {
                int tempSum = A[i] + B[j]; 
                AB.put(tempSum, AB.getOrDefault(tempSum,0) +1 );
                 
            }
        }
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lens; j++) {
                int tempSum = C[i] + D[j];
                if ( AB.containsKey( -tempSum)){
                    ans += AB.get(-tempSum) ;
                }
                 
            }
        }
         

        return ans; 
    }
}
// @lc code=end

