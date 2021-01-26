import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1128 lang=java
 *
 * [1128] 等价多米诺骨牌对的数量
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int lens = dominoes.length;

        Map<Integer, Integer> numberCounter = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            int a = Math.min(dominoes[i][0], dominoes[i][1]);
            int b = Math.max(dominoes[i][0], dominoes[i][1]);
            int sign = a*10 + b;

            numberCounter.put(sign, numberCounter.getOrDefault(sign, 0)+1);

        }
        for(Integer values: numberCounter.values()){
            if(values > 1){
                ans += (1+values-1)*(values-1)/2;
            }
        }
        return ans;

    }
}
// @lc code=end

