import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if( nums.length == 1)  return 0;
        List<Integer> BucketId = new ArrayList<>();
        Map<Integer, List<Integer>> BucketSort = new HashMap<>();

        for(int Obj : nums){
            int bucket = (int)(Obj / 20);
            if ( !BucketId.contains(bucket)) {
                BucketId.add(bucket);
                List<Integer> BucketTemp = new ArrayList<>() ;
                BucketTemp.add(Obj);
                BucketSort.put(bucket, BucketTemp);

            }else{
                BucketSort.get(bucket).add(Obj);
            }

        }
        Collections.sort(BucketId, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if (a <b){
                    return -1;
                }else{
                    return 1;
                } 
            }
        });
        // System.out.println(BucketId.toString());
        int ans = 0;
        int posItem = -1;
        for(int pos : BucketId){
            List<Integer> temp = BucketSort.get(pos);
            Collections.sort(temp);
            // System.out.println(temp);
            for(int Item: temp){
                if(posItem == -1){
                    posItem = Item;
                }else{
                    ans = Math.max(ans,Item - posItem);
                    posItem = Item;
                }
            } 
        } 
        return ans;

    }
}
// @lc code=end

