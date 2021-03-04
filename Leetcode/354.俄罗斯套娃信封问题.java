import java.lang.Math;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //w升序，h降序

        int lens  = envelopes.length;

        Arrays.sort(envelopes,(e1,e2) -> {
            if( e1[0] != e2[0]){
                return e1[0] - e2[0];
            }else{
                return e2[1] - e1[1];
            }
        }); 

        List<Integer> dp = new ArrayList<Integer>();
        dp.add(0);

        int count = 0;

        for(int i = 0; i < lens; i++){
            if(envelopes[i][1] > dp.get(count)){
                dp.add(envelopes[i][1]);
                count++;
            }
            else{
                int returnValue = binarySearch(0,count,dp,envelopes[i][1]); 
                // dp.set(returnValue,Math.min(dp.get(returnValue),envelopes[i][1]));
                dp.set(returnValue,envelopes[i][1]);

            }  
         
        } 
 
        return count; 
    }

    private int binarySearch(int start, int end, List<Integer> dp,int value){
        while(start < end){
            int middle = start + (int)((end - start)/2);
            if( dp.get(middle) < value){
                if(dp.get(middle+1) >= value){
                    int returnValue = middle + 1; 
                    return returnValue; 
                }else{
                    start = middle + 1;
                }
            }else{
                end = middle-1; 
            } 
        } 
        int returnValue = end + 1; 
        return returnValue;
 
    }
}