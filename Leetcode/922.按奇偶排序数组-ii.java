/*
 * @lc app=leetcode.cn id=922 lang=java
 *
 * [922] 按奇偶排序数组 II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0; 
        for ( ; even < A.length; even+=2) {
            if( A[even] % 2 == 1){
                while( A[odd] % 2 == 1){
                    odd += 2;
                }
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }

        return A;

    }
}
// @lc code=end

