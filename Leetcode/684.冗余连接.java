import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Integer q  = 1;
        Integer w = 1;
        System.out.println(q == w);
        Map<Integer,Integer> dp = new HashMap<>(); 
        int maxs = 0; 
        int[] ans = new int[2] ;
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1]; 
            
            if(dp.containsKey(a) && dp.containsKey(b)){
                // if(a == 102 && b == 521){
                //     System.out.println(find(a, dp));
                //     System.out.println( find(b, dp));
                //     System.out.println(find(a, dp) == find(b, dp));
                // }
                if(find(a, dp).equals(find(b, dp))){
                    
                    return edges[i];
                }
            }
            union(a, b, dp);
            for (Integer j : dp.keySet()) {
                dp.put(j, find(j, dp)); 
            } 
        }
        
        return ans;
    }

    private void union(int a, int b, Map<Integer,Integer> dp){
        int x = find(a, dp);
        int y = find(b, dp);
        dp.put(y, x);
    }

    private Integer find(int a, Map<Integer,Integer> dp){
        if( !dp.containsKey(a)){
            dp.put(a, a);
            return a;
        }else{
            while( a!= dp.get(a)){
                a = dp.get(a);
            }
            return a;
        }
    }
} 

