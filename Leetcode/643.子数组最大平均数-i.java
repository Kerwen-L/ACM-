/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxs = 0; 
        int lens = nums.length;
        long sums = 0L;
        for (int i = 0; i < k; i++) {
            sums += nums[i];
        }
        maxs = sums/(k*1.0);
        int left = 0;
        int right = k;
        while(right < lens){
            right += 1 ;
            maxs = Math.max(maxs, maxs +(sums[right]-sums[left])/(k*1.0));
            left += 1 ;

        }
        return maxs;
 
    }
}
// @lc code=end

