import java.awt.List;
import java.util.ArrayList;

import org.graalvm.compiler.asm.Assembler.CodeAnnotation;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<int[]> DP = new ArrayList<int []>();
        DP.add(new int[]{0,gas[0]-cost[0]});
        int Sign = 0;
        for (int i = 1; i < cost.length; i++) {
            int temp = gas[i] - cost[i];
            int temp_sign = Integer.signum(temp);
            if(temp_sign == 0 || temp_sign == Sign){
                DP.get(DP.size()-1)[1]+=temp;
            }
            else{
                DP.add(new int[]{i,temp});
                Sign = temp_sign;
            }
            
        }
        int lens = DP.size();
        int ans = -1;
        for (int i = 0; i < lens; i++) {
            int[] temp = DP.get(i);

            if( temp[1] >= 0){
                int Sums = 0;
                boolean sign = true;
                for (int j = 0; j < lens; j++) {
                    int pos = (i+j)%lens;
                    Sums += DP.get(pos)[1];
                    if( Sums<0 ){
                        sign = false;
                        break;
                    }
                }
                if(sign){
                    ans = temp[0];
                    break;
                }
            } 
        }

 
        return ans;

    }
}
// @lc code=end

