/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    private int[] tempNums;

    public NumArray(int[] nums) {
        int lens = nums.length;
        tempNums = new int[lens + 1];
        for(int i = 1 ; i <= lens ; i++){
            tempNums[i] = tempNums[i-1] + nums[i-1];
        }

    }
    
    public int sumRange(int i, int j) {
        return tempNums[j+1] - tempNums[i];

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

