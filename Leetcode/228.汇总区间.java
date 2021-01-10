/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n == 0){
            return ans;
        }
        if( n == 1){
            ans.add(""+nums[0]);
            return ans;
        }
        StringBuilder temp = new StringBuilder("");
        int pos = nums[0];
        for (int i = 0; i < n; i++) {
            if( i == 0){
                temp.append(Integer.toString(nums[i]));
            }else{
                if(nums[i] == pos+1){
                    pos = nums[i];
                }else{
                    if(pos != Integer.parseInt(temp.toString()))
                        temp.append("->"+pos);
                    ans.add(temp.toString());
                    pos = nums[i];
                    temp = new StringBuilder(""+pos);
                }
            }
        }
        if( n > 1){
            if(nums[n-1] != nums[n-2] +1){
                ans.add(temp.toString());
            }else{
                temp.append("->"+nums[n-1]);
                ans.add(temp.toString());
            }
        } 
        return ans;

    }
}
// @lc code=end

