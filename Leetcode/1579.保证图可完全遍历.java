/*
 * @lc app=leetcode.cn id=1579 lang=java
 *
 * [1579] 保证图可完全遍历
 */

// @lc code=start
class UnionSet{
    private int[] parent = null;
    private int lens = 0;
    private int counter = 0;

    public UnionSet(int n){
        this.lens = n;
        this.parent = new int[n+1];
        this.counter = n;
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
        }
    }

    public boolean isUnion(){
        return this.counter == 1;
    }

    public int find(int a){
        if( a != this.parent[a]){
            this.parent[a] = this.find(this.parent[a]);
        }
        return this.parent[a];
    }

    public boolean Union(int a, int b){
        int x = this.find(a);
        int y = this.find(b);
        if( x == y){
            return false;
        }
        this.counter -= 1;
        this.parent[x] = y;
        return true;
    }
}


class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionSet unionSet1 = new UnionSet(n);
        UnionSet unionSet2 = new UnionSet(n);
        int ans = 0;
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            if( type != 3){
                continue;
            }
            int a = edges[i][1];
            int b = edges[i][2];
            unionSet1.Union(a, b);
            if( !unionSet2.Union(a, b) ){
                ans += 1;
            } 
        }
        // type1
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            if( type != 1){
                continue;
            }
            int a = edges[i][1];
            int b = edges[i][2];
            if( !unionSet1.Union(a, b)){
                ans += 1;
            } 
        }
        if( !unionSet1.isUnion()){
            return -1;
        }
        // type2
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            if( type != 2){
                continue;
            }
            int a = edges[i][1];
            int b = edges[i][2];
            if( !unionSet2.Union(a, b)){
                ans += 1;
            } 
        }
        if( !unionSet2.isUnion()){
            return -1;
        }

        return ans; 

    }
}
// @lc code=end

