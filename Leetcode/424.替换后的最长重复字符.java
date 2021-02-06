import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int lens = s.length();
        if (lens < 2 ){
            return lens;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            freq.put( (char)('A' +i) , 0);
        }

        int ans = 0;

        int left = 0;
        int right = 0;
        int maxCounter = 0;
        while( right < lens ){
            char rightChar = s.charAt(right);
            int rightCounter = freq.get(rightChar);
            freq.put(rightChar, rightCounter + 1);
            maxCounter = Math.max(maxCounter, rightCounter + 1);
            right ++ ;
            if( right - left - maxCounter > k){
                freq.put(s.charAt(left), freq.get(s.charAt(left))-1);
                left++ ;
            } 
            ans = Math.max(ans, right - left); 
        } 
        return ans; 
    }
}
// @lc code=end

