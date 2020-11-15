/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        String tempNum = new String(num);
        String ans=  "";   
        for (int i = 0; i < tempNum.length(); i++) { 
           
            while(ans.length()>0 && ans.charAt(ans.length()-1) > tempNum.charAt(i) && k>0){
                ans = ans.substring(0, ans.length()-1);
                k-=1;

            } 
            ans = ans + tempNum.charAt(i) ;
            
            
        }
         
        if(k>0){
            ans = ans.substring(0, ans.length()-k);
        } 

        
        if(ans.equals("")){
            return "0";
        }
        int sign = -1; 
        for (int i = 0; i < ans.length(); i++) { 
            if(ans.charAt(i) !='0' ){
                sign = i ;
                break;
            } 
        }
        if(sign == -1){
            return "0";
        }
        
        ans = ans.substring(sign, ans.length());
        if(ans.equals("")){
            return "0";
        }
        return  ans;

    }
}
// @lc code=end

