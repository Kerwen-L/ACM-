 

/*
 * @lc app=leetcode.cn id=1541 lang=java
 *
 * [1541] 平衡括号字符串的最少插入次数
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int LeftStack = 0;
        int RightStack = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                if(RightStack == 1){
                    if(LeftStack >0) {
                        LeftStack -=1;
                        ans +=1;
                    } 
                    else {
                        LeftStack = 1;
                        ans +=2;
                    }     
                    RightStack = 0 ;        
                }else{
                    LeftStack +=1;
                }

            }else{
                if(RightStack == 1){ 
                    if(LeftStack >0) {
                        LeftStack -=1;
                    } 
                    else{ 
                        ans +=1;
                    }
                    RightStack = 0;
                }else{
                    RightStack = 1;
                }

            }
            
        }
        System.out.println(ans);
        if(2*LeftStack > RightStack){
            ans += (2*LeftStack - RightStack);
        }else{
            ans += (int)(RightStack/2) - LeftStack;
            if(ans%2 == 1){
                ans+=2;
            }
        }
        return ans;
    }
    
}
// @lc code=end

