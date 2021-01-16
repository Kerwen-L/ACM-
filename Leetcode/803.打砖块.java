import java.lang.module.FindException;

import org.graalvm.compiler.lir.amd64.AMD64Arithmetic.FPDivRemOp;
import org.graalvm.compiler.nodes.graphbuilderconf.GeneratedInvocationPlugin;

/*
 * @lc app=leetcode.cn id=803 lang=java
 *
 * [803] 打砖块
 */

// @lc code=start
class UnionSet{
    // 并查集树
    int[] father = null;
    // 以当前节点为father的节点的总数量
    int[] nodeSize = null;

    public UnionSet(int size){
        this.father = new int[size];
        this.nodeSize = new int[size];

        for (int i = 0; i < size; i++) {
            this.father[i] = i;
            this.nodeSize[i] = 1; 
        } 
    }

    //在find的时候顺便进行路径压缩
    public int Find(int root){
        if(root != this.father[root]){
            this.father[root] = this.Find(this.father[root]);
        }
        return this.father[root];
    }

    // 节点联合
    public void Union(int a, int b){
        int x = this.Find(a);
        int y = this.Find(b);

        if(x == y){
            return ;
        }

        this.father[x] = y;

        this.nodeSize[y] += this.nodeSize[x];
    }

    //获取一节点所在联通区间的所有节点数量
    public int getSize(int a){
        return this.nodeSize[this.Find(a)];
    }

}
class Solution {
    private int m = 0;
    private int n = 0;
    int[][] tempGrid = null;
    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {

        this.m = grid.length;
        this.n = grid[0].length;

        //第一步，规范化复制，防止对输入数据造成破坏，也可省略 
        this.tempGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.tempGrid[i][j] = grid[i][j]; 
            }
        }
        //击碎石块
        for (int[] is : hits) {
            this.tempGrid[is[0]][is[1]] = 0;
        }
        //构造并查集
        int size = this.m * this.n;
        UnionSet nSet = new UnionSet(size + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0){
                    if(this.tempGrid[0][j] == 1){
                        nSet.Union(j, size);
                    }
                }else{
                    if(this.tempGrid[i][j] == 1){
                        if(this.tempGrid[i-1][j] == 1){
                            nSet.Union(this.getIndex(i, j), this.getIndex(i-1, j)); 
                        }
                        if(j-1 >= 0 && this.tempGrid[i][j-1] == 1){
                            nSet.Union(this.getIndex(i, j), this.getIndex(i, j-1));
                        }
                    }
                }
            }
        }
        //逆序补砖头
        int hitLength = hits.length;
        int[] ans = new int[hitLength];
        for (int i = hitLength - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0)
                continue;

            int before = nSet.getSize(size);

            if( x == 0){
                nSet.Union(this.getIndex(x, y), size);
            }

            for (int[] dir : this.directions) {
                if(this.outOfIndex(x+dir[0], y+dir[1]) && this.tempGrid[x+dir[0]][y+dir[1]]==1){
                    nSet.Union(this.getIndex(x, y), this.getIndex(x+dir[0], y+dir[1]));
                }
                
            }

            int after = nSet.getSize(size);

            ans[i] = Math.max(0, after - before - 1); 

            this.tempGrid[x][y] = 1;
            
        }
        return ans;

    }

    private int getIndex(int x, int y){
        return x * this.n + y;
    }

    private boolean outOfIndex(int x, int y){
        return (x>=0) && (x<m) && (y>=0) && (y<n);
    }
}
// @lc code=end

