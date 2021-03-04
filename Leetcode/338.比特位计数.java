/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        int temp = 0;
        for (int i = 1; i <= num; i++) {
            if( i % 2 == 0 ){
                temp = i;
            }
            ans[i] = 1 + ans[i-temp];
        }
        return ans;

    }
}
// @lc code=end

