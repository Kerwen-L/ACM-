import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        int lens = people.length;
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] a ,int[] b){
                if(a[0] == b[0])
                   return a[1] - b[1];
                return b[0] - a[0] ;
            }
        }); 
        for (int i = 0; i < lens; i++) { 
            int counts = 0;
            boolean sign = true;
            int a = people[i][0];
            int b = people[i][1];
            for (int j = 0 ; j < ans.size(); j++) {
                if( ans.get(j).get(0) >= a){
                    counts++;
                    
                }else{
                    continue;
                }
                if ( counts > b){
                    List<Integer> temp = new ArrayList<Integer>( );
                    temp.add(a);
                    temp.add(b);
                    ans.add(j,temp);
                    sign = false;
                    break;
                }
            }
            if(sign){
                List<Integer> temp = new ArrayList<Integer>( );
                temp.add(a);
                temp.add(b);
                ans.add(temp);
            }
            
        }
        int[][] Ans = new int[lens][2]; 
        for (int i = 0; i < Ans.length; i++) {
            List t = ans.get(i);
            Ans[i][0] = (int)t.get(0);
            Ans[i][1] = (int)t.get(1);
        }

        return Ans;

    }
}
// @lc code=end

