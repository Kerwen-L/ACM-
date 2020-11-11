import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 

/*
 * @lc app=leetcode.cn id=514 lang=java
 *
 * [514] 自由之路
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        Integer ans = 0xffff;
        Integer ring_lens = ring.length();
        Map dp = new HashMap<Integer,Map<Integer,Integer>>();
        for (int i = 0; i < key.length(); i++) {
            Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
            for (int j = 0; j < ring.length(); j++) {
                if(ring.charAt(j) == key.charAt(i)){
                    temp.put(j, 0xffff);
                }
            }
            dp.put(i, temp);
        } 

        Map<Integer,Integer> pos = new HashMap<Integer,Integer>();
        pos.put(0,0);
        for (int i = 0; i < key.length(); i++) {
            Map<Integer,Integer> t = (Map<Integer,Integer>)dp.get(i) ;
            for(Integer prePos: pos.keySet()){
                Integer preValue = pos.get(prePos);
                for (Map.Entry<Integer, Integer> entry : t.entrySet()) {
                    Integer Key = entry.getKey();
                    Integer Value = Math.min(entry.getValue(), Math.min(Math.abs(prePos-Key), ring_lens-(Math.abs(prePos-Key)))+1+preValue);
                    t.put(Key, Value );
                }
            }
            pos = t;
        }
        Map<Integer,Integer> t = (Map<Integer,Integer>)dp.get(key.length()-1) ;
        
        for(Integer steps: t.values()){
            ans = Math.min(ans, steps);
        } 
        return ans;
    }
}
// @lc code=end

