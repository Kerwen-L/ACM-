#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#

# @lc code=start
from typing import Collection


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s1 = dict(collections.Counter(s))
        t1 = dict(collections.Counter(t))
        S1 = ""
        T1 = "" 
        for i in string.ascii_lowercase :
            try:
                S1 +=  i+str(s1[i])
            except BaseException:
                pass
            try:
                T1 +=  i+str(t1[i])
            except BaseException:
                pass
        print(S1)
        print(T1)
        return str(S1) == str(T1)

# @lc code=end

