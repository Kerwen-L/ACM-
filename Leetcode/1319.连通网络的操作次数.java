import java.nio.file.NotLinkException;

import jdk.tools.jlink.resources.plugins;

/*
 * @lc app=leetcode.cn id=1319 lang=java
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start
class Solution {
    public int makeConnected(int n, int[][] connections) {

        int lens = connections.length;
        if( lens < n-1 ){
            return -1;
        } 

        UnionSet unionSet = new UnionSet(n);
        for(int[] conn : connections){
            unionSet.union(conn[0], conn[1]);
        }

        return unionSet.counts;

    }
}
class UnionSet{
    private int n = 0;
    public int[] parent = null;
    public int counts = 0;

    public UnionSet(int n){
        this.n = n;
        this.counts = n-1;
        this.parent = new int[this.n];

        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int a){
        if(a != this.parent[a]){
            this.parent[a] = this.find(this.parent[a]);
        }
        return this.parent[a];
    }

    public boolean union(int a, int b){
        int x = this.find(a);
        int y = this.find(b);

        if( x == y ){
            return false;
        }else{
            this.counts -= 1;
            this.parent[x] = y;
            return true;
        }

    }
}
// @lc code=end

