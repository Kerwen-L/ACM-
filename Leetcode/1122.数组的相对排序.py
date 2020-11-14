#
# @lc app=leetcode.cn id=1122 lang=python3
#
# [1122] 数组的相对排序
#

# @lc code=start
class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        rank = {x:i for i,x in enumerate(arr2)}
        def CMP(x):
            return rank[x] if x in arr2 else x+1000
        
        arr1.sort(key = CMP)
        return arr1
        
# @lc code=end

