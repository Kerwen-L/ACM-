/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int lens = nums.length;
        if( lens <= 1){
            return lens;
        }
        int ans = 1;
        int dp = 1;
        for (int i = 1; i < nums.length; i++) {
            if( nums[i] > nums[i-1]){
                dp += 1;
                ans = Math.max(ans, dp);
            }else{
                dp = 1;
            }
            
        }
        return ans;

    }
}
// @lc code=end

