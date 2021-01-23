import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>(); 
        int lens = A.length;
        int[] tempA = new int[A.length];
        for (int i = 0; i < lens; i++) {
            tempA[i] = A[lens - i - 1];
        } 
        int tempK = K;
        int jin = 0;
        int counts = 0;
 
        while(tempK > 0 || counts < lens){

            int a = counts < lens? tempA[counts] : 0;
            int b = tempK % 10;
 
            tempK /= 10;

            int number = a + b + jin;
            if(number > 9){
                number -= 10;
                jin = 1;
            }else{
                jin = 0;
            }
            ans.add(number); 
            counts += 1;

        }
        if( jin == 1){
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans; 
    }
}
// @lc code=end

