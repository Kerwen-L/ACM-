import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import jdk.internal.vm.PostVMInitHook;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */
// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        List<List<Integer>> DP = new ArrayList<List<Integer>>();
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return (p1[0]*p1[0]+p1[1]*p1[1]) - (p2[0]*p2[0]+p2[1]*p2[1]);
            }
        }); 
        return Arrays.copyOfRange(points, 0, K);
    
    }
}
// @lc code=end