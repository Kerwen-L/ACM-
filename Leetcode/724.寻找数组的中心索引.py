#
# @lc app=leetcode.cn id=724 lang=python3
#
# [724] 寻找数组的中心索引
#

# @lc code=start
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        sums = sum(nums)
        temp_sum = 0
        for i,item in enumerate(nums):
            sums -= item
            if( sums == temp_sum):
                return i
            temp_sum += item
        return -1
# @lc code=end

