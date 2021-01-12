import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //广度优先搜索
        // 存放图的邻接关系,统计图中所有节点的入度
        List<List<Integer>> graph = new ArrayList<>();
        int[] visitied = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); 
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];
            graph.get(b).add(a);
            visitied[a] += 1;

        }
        //统计初始出发点

        Queue<Integer> dp = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(visitied[i] == 0){
                dp.offer(i); 
            }
            
        }
        //统计访问过的点
        int finished = 0;

        while( !dp.isEmpty()){
            int first = dp.poll();

            for(Integer next : graph.get(first)){
                visitied[next] -= 1;
                if(visitied[next] == 0 ){
                    dp.offer(next);
                } 
            }
            
            finished += 1; 
        }

        if( finished == numCourses){
            return true;
        }else{
            return false;
        }
  

    }
}
// @lc code=end

