class Solution {
    public int minCostConnectPoints(int[][] points) {
        int lens = points.length;
        int[][] Dist = new int[lens][lens];

        for(int i=0; i<lens-1; i++){
            for(int j=i+1; j<lens; j++){
                int dist = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                Dist[i][j] = dist;
                Dist[j][i] = dist;
            }
        } 

        int ans = 0;
        int x =  Integer.MAX_VALUE;
        int pos = 0;

        int[] minDist = new int[lens];
        for(int i = 1; i<lens; i++){
            minDist[i] = Math.abs(points[i][0] - points[0][0]) + Math.abs(points[i][1]-points[0][1]);
            if(minDist[i] < x){
                x = minDist[i];
                pos = i;
            }
        }
        boolean[] visited = new boolean[lens];
        visited[0] = true;

        int rest = lens - 1;

        while(rest > 0){
 
            // System.out.println(x);
            ans += x;
            visited[pos] = true;
            rest -= 1;
            
            x =  Integer.MAX_VALUE; 
            int newPos = 0;
            
            for(int i=1; i<lens; i++){
                if(visited[i]){
                    continue;
                }
                int temp = Math.abs(points[i][0] - points[pos][0]) + Math.abs(points[i][1]-points[pos][1]);
                minDist[i] = Math.min(minDist[i], temp);

                if(minDist[i] <= x ){
                    x = minDist[i];
                    newPos = i;
                }  
            } 
            pos = newPos;
        }

        return ans;
 
    }
}