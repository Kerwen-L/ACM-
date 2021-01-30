/*
 * @lc app=leetcode.cn id=778 lang=java
 *
 * [778] 水位上升的泳池中游泳
 */

// @lc code=start
class UnionSet{
    private int[] parent;

    public UnionSet(int n){
        this.parent = new int[n];
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

    public boolean union(int a ,int b){
        int x = this.find(a);
        int y = this.find(b);
        if(x == y){
            return false;
        }
        this.parent[x] = y;
        // System.out.println(Arrays.toString(this.parent));

        return true;

    }

    public boolean judge(){
        int x = this.find(0);
        int y = this.find(this.parent.length-1);
        return x == y;
    }
}

class Solution {
    private int n = 0;

    private int getIndex(int x, int y){
        return x * this.n + y; 

    }
    public int swimInWater(int[][] grid) {
        int lens = grid.length;
        this.n = lens;
        int[] position = new int[lens * lens];
        int[] heighs = new int[lens * lens];
        for (int i = 0; i < lens; i++) {
            for (int j = 0; j < lens; j++) {
                int index = this.getIndex(i,j);
                int heigh = grid[i][j];
                position[heigh] = index; 
                heighs[index] = heigh;
            } 
        }
        UnionSet unionSet = new UnionSet(lens * lens); 
        for (int i = 0; i < lens * lens; i++) {
            // System.out.println();
            int pos = position[i];
            // 向左
            if( pos - 1 >= 0 && (pos-1) % lens !=(lens-1)){
                
                if(heighs[pos - 1] < i)
                    unionSet.union(pos, pos-1);
            }
            // 向右
            if( pos + 1 < lens * lens && (pos+1) % lens != 0 ){
                if(heighs[pos + 1] < i)
                    unionSet.union(pos, pos+1);
            }
            // 向上
            if( pos + lens < lens * lens   ){
                if(heighs[pos + lens] < i)
                    unionSet.union(pos, pos+lens);
            }
            // 向下
            if( pos - lens >= 0   ){
                if(heighs[pos - lens] < i)
                    unionSet.union(pos, pos-lens);
            }
            if(unionSet.judge()){
                return i;
            }
        }
        return lens * lens - 1;
    }
}
// @lc code=end