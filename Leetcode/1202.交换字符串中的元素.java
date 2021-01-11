import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

/*
 * @lc app=leetcode.cn id=1202 lang=java
 *
 * [1202] 交换字符串中的元素
 */

// @lc code=start
class bing{
    public int[] fu;

    public  bing(int n){
        this.fu = new int[n];
        for( int i = 0; i < n; i++){
            this.fu[i] = i;
        }
    }

    public int find(int a){
        while(this.fu[a] != a){
            a = this.fu[a];
        }
        return a;

    }

    public void union(int a, int b){
        int x = this.find(a);
        int y = this.find(b);
        this.fu[x] = y;
    }
}


class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        String ans = "";
        if ( n == 0  ){
            return ans;
        }
        //并查集构建
        bing binchaji = new bing(n);

        //并查集插入元素 
        Set<Integer>  all_pos = new HashSet<Integer>();
        for (List<Integer> element : pairs) {
            all_pos.add(element.get(0));
            all_pos.add(element.get(1));
            binchaji.union(element.get(0), element.get(1)); 
        }

        //设置区块
        Map<Integer, List<String>> span =  new HashMap<>();
        //路径压缩
        for (int i = 0; i < n; i++) {
            binchaji.fu[i] = binchaji.find(i); 
            int key = binchaji.fu[i];
            if(span.containsKey(key)){
                span.get(key).add(s.substring(i,i+1));
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s.substring(i,i+1));
                span.put(key, temp);
            }
        }
        //span 排序
        for (Integer a : span.keySet()) {
            span.get(a).sort(new Comparator<String>(){
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2); 
                } 
            });
        }

       
        //开始组合答案
        for (int i = 0; i < n; i++) {
            if(all_pos.contains(i)){
                Integer key = binchaji.fu[i];
                String t = span.get(key).get(0);
                ans += t;
                span.get(key).remove(0);
            }else{
                ans += s.substring(i, i+1);

            }
            
        }
 
       
        return ans;

    }
}
// @lc code=end

