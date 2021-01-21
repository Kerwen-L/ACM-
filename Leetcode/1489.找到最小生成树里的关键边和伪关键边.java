import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1489 lang=java
 *
 * [1489] 找到最小生成树里的关键边和伪关键边
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;

        int[][] newEdges = new int[m][4];
        
        for (int i = 0; i < newEdges.length; i++) {
            for (int j = 0; j < 3; j++) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[2] - b[2];
            }
        });


        UnionSet unionSet1 = new UnionSet(n);

        int minValue = 0;
 

        for (int i = 0; i < newEdges.length; i++) {
            if(unionSet1.union(newEdges[i][0], newEdges[i][1]) ){
                minValue += newEdges[i][2];
            }
        }

        System.out.println(minValue);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<Integer> temp  = new ArrayList<>();
            ans.add(temp);
            
        }

        for (int i = 0; i < newEdges.length; i++) {

            int iValue = 0;
            UnionSet unionSet = new UnionSet(n);
            for (int j = 0; j < newEdges.length; j++) {
                if( j != i && unionSet.union(newEdges[j][0], newEdges[j][1])){
                    iValue += newEdges[j][2];
                }
                
            }
            if( unionSet.counts >1 || iValue > minValue){
                ans.get(0).add(newEdges[i][3]);
                continue; 
            }
            unionSet = new UnionSet(n);
            iValue = 0;
            unionSet.union(newEdges[i][0], newEdges[i][1]);
            iValue += newEdges[i][2];
            for (int j = 0; j < newEdges.length; j++) {
                if( j != i && unionSet.union(newEdges[j][0], newEdges[j][1])){
                    iValue += newEdges[j][2];
                } 
            }
            if(iValue == minValue){
                ans.get(1).add(newEdges[i][3]);
            } 
        }
        
          
        return ans;

    }
}


class UnionSet{

    public int counts = 0;

    private int lens = 0;
    private int[] parent = null;
    
    public UnionSet( int n ){
        this.lens = n;
        this.counts = n;
        this.parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = i;
        } 
    }

    public int findParent(int a){
        if(a != this.parent[a]){
            this.parent[a] = this.findParent(this.parent[a]);
        }
        return this.parent[a];
            
    }

    public boolean union(int a,int b){
        int x = this.findParent(a);
        int y = this.findParent(b);

        if(x == y){
            return false;
        }

        this.counts--; 
        this.parent[x] = y;

        return true;

    }
}
// @lc code=end

