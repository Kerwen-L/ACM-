#
# @lc app=leetcode.cn id=1423 lang=python3
#
# [1423] 可获得的最大点数
#

# @lc code=start
class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        sums = sum(cardPoints)
        left = 0
        right = len(cardPoints) - k
        dp = 0
        for i in range(right):
            dp += cardPoints[i]
        ans = dp
        while right < len(cardPoints):
            dp  = dp + cardPoints[right] - cardPoints[left]
            ans = min(ans,dp)
            left += 1
            right += 1
        return sums - ans
        

# @lc code=end

