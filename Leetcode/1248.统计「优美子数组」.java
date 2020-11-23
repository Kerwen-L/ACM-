import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> DP = new ArrayList<>( );
        int count = 0;
        int pos = 1;
        for (int i = 0; i < nums.length; i++) { 
            count +=1;
            if( (nums[i]&1) == 1 ){
                pos +=1;
                DP.add(count);
                count = 1; 

                if(pos - k >= 0){

                }
            }
            
        }
        return ans;
    }
}
// @lc code=end

