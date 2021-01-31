import java.awt.List;
import java.util.ArrayList;

import jdk.tools.jlink.resources.plugins;

/*
 * @lc app=leetcode.cn id=839 lang=java
 *
 * [839] 相似字符串组
 */

// @lc code=start
class UnionSet{
    private int[] parent;
    private int n = 0;
    public int counter = 0;
    public UnionSet(int lens){
        this.n = lens;
        this.counter = lens;
        this.parent = new int[lens];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
        }
    }
    public int find(int a){
        if( a != this.parent[a]){
            this.parent[a] = this.find(this.parent[a]);
        }
        return this.parent[a];
    }

    public boolean union(int a, int b){
        int x = this.find(a);
        int y = this.find(b);
        if( x == y){
            return false;
        }
        this.counter -= 1;
        this.parent[x] = y;
        return true;
    }

    public boolean judge(int a,int b){
        int x = this.find(a);
        int y = this.find(b);
        return x == y;
    }
}
class Solution {
    public int numSimilarGroups(String[] strs) {
        int lens = strs.length;
        UnionSet unionSet = new UnionSet(lens);
        if ( lens == 1){
            return 1;
        }
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if( !unionSet.judge(i, j)){
                    if(this.strEquals(strs[i], strs[j])){
                        unionSet.union(i, j);
                    }
                }
            }
        }
        return unionSet.counter; 

    }

    private boolean strEquals(String s1, String s2){
        int lens = s1.length();
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < lens; i++) {
            if( s1.charAt(i) != s2.charAt(i)){
                difference.add(i);
            }
            
        }
        if( difference.size() == 0){
            return true;
        }
        if( difference.size() == 2){
            if( s1.charAt(difference.get(0)) == s2.charAt(difference.get(1))){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
// @lc code=end

