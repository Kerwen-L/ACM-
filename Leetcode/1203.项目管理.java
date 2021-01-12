import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
 * @lc app=leetcode.cn id=1203 lang=java
 *
 * [1203] 项目管理
 */

// @lc code=start
//使用广度优先排序
class TopologicalSort{
    //存放节点数量
    private int n = 0;
    //用于存放临界表
    private List<Integer>[] graph = null;
    //用于存放点的出入度
    private int[] indegree = null;
    //存放拓扑排序的结果
    private List<Integer> sortedResult = null;
 
    public TopologicalSort(int n, List<Integer>[] graph){
        this.graph = graph; 
        this.n = n;
        this.indegree = new int[this.n];
        this.setIndegree();
        
    }
    //根据图构建入度矩阵
    private void setIndegree(){
        for (int i = 0; i < this.n; i++) { 
            for (Integer item : graph[i]) {
                
                this.indegree[item] += 1;
            }
        }  
    }
    //进行拓扑排序
    public boolean sorting(){

        //给结果赋初值
        this.sortedResult = new ArrayList<Integer>();
        //统计初始出发点 
        Queue<Integer> dp = new LinkedList<Integer>();
        for (int i = 0; i < this.n; i++) {
            if(this.indegree[i] == 0){
                dp.offer(i); 
            }
            
        }
        //统计访问过的点
        int finished = 0;

        while( !dp.isEmpty()){ 
            Integer first = dp.poll();   
            for(Integer next : this.graph[first]){ 
                this.indegree[next] -= 1;
                if(this.indegree[next] == 0 ){
                    dp.offer(next);
                } 
            } 
            finished += 1; 
            this.sortedResult.add(first);
        } 
        // System.out.println("sortedResult"+ this.sortedResult.toString());
        if( finished == this.n){
            return true;
        }else{
            return false;
        }
    }
    
    //返回结果
    public List<Integer> getSortedResult(){
        return this.sortedResult; 
    }


}

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // 数据预处理，给没有归属于某一个组的项目强行加上一个组号，这个组合>=m
   
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1){
                group[i] = m;
                m += 1;
            }
        }
        //实例化项目和组的项目邻接表，A->B ,A是B的前置项目
        List<Integer>[] groupAdj = new ArrayList[m];
        List<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }

        //构建邻接表,不需要构建入度矩阵
        for (int i = 0; i < n; i++) {
            int currGroup = group[i];
            for (Integer beforeItem : beforeItems.get(i)) { 
                int beforeGroup = group[beforeItem]; 
                if(beforeGroup != currGroup){ 
                    groupAdj[beforeGroup].add(currGroup);
                }
                itemAdj[beforeItem].add(i);
            } 
        }

   

        //原创部分
        //构建拓扑排序类
        TopologicalSort groupTopologicalSort = new TopologicalSort(m,groupAdj);
        TopologicalSort itemTopologicalSort = new TopologicalSort(n,itemAdj);
        //组拓扑排序
        List<Integer> groupsList, itemsList;
        if(!groupTopologicalSort.sorting()){
            System.out.println("组排序失败");
            return new int[0]; 
        }else{
            groupsList = groupTopologicalSort.getSortedResult();
        }
        //项目拓扑排序
        if(!itemTopologicalSort.sorting()){
            System.out.println("项目排序失败");
            return new int[0]; 
        }else{
            itemsList = itemTopologicalSort.getSortedResult();
        } 
        
        //下面两步，俺没懂为什么
        //根据项目的拓扑结果，建立组到项目的一对多关系
        //key：组，value：这一组的项目
        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemsList) {
            if(groups2Items.containsKey(group[item])){
                groups2Items.get(group[item]).add(item);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(item);
                groups2Items.put(group[item], temp);
            } 
        }
        //把组的拓扑排序结果替换成为项目的拓扑排序结果
        List<Integer> ans = new ArrayList<>(); 

        for (Integer groups : groupsList) {
            ans.addAll(groups2Items.getOrDefault(groups, new ArrayList<>())); 
        }

        return ans.stream().mapToInt(Integer::valueOf).toArray();


    }
}
// @lc code=end

