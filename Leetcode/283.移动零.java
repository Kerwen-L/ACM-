import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int x = 0; 
        int lens = nums.length;
        
        for (int i = 0; i < lens; i++) {
            if( nums[i] !=0){
                nums[x] = nums[i];
                x += 1;
            }
        }
        while( x < lens){
            nums[x] = 0;
            x += 1;
        }
        
    }
}
// @lc code=end

