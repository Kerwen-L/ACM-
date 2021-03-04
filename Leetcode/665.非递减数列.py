#
# @lc app=leetcode.cn id=665 lang=python3
#
# [665] 非递减数列
#

# @lc code=start
class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        counter = 0
        nums.insert(- 1e5+1)
        temp = nums[1]
        for i in range(1, len(nums)):
            if temp > nums[i+1]:
                counter += 1
                if i == 0:
                    temp = nums[1]
                else:
                    temp = nums[i-1]
                if counter == 2:
                    nums.pop(-1)
                    return False
            else:
                temp = nums[i+1]

        nums.pop(-1)
        return True
# @lc code=end

