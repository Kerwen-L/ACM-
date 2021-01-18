import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.management.AttributeList;

/*
 * @lc app=leetcode.cn id=721 lang=java
 *
 * [721] 账户合并
 */

// @lc code=start
class UnionSet{
    private int lens = 0;
    public int[] father = null;
    public UnionSet(int lens){
        this.lens = lens;
        this.father = new int[this.lens];

        for (int i = 0; i < this.father.length; i++) {
            this.father[i] = i;
        } 
    }

    public int find(int a ){
        if (a != this.father[a]){
            this.father[a] = this.find(this.father[a]);
        }
        return this.father[a];
    }

    public void union(int a,int b){
        int x = this.find(a);
        int y = this.find(b);

        this.father[y] = x; 
    }

    public void yasuo(){
        for(int i = 0;i<this.lens;i++){
            this.father[i] = this.find(i);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int lens = accounts.size();
        System.out.println(lens);
        
        UnionSet unionSet = new UnionSet(lens);

        Map<String,Integer> email = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> tempAccount = accounts.get(i); 
            for(int j = 1 ; j< tempAccount.size();j++){
                if(email.containsKey(tempAccount.get(j))){
                    unionSet.union(i, email.get(tempAccount.get(j)));
                }else{
                    email.put(tempAccount.get(j), i);
                }
            }
        }

        unionSet.yasuo();

        Map<Integer,Integer> Maps = new HashMap<>();
        List<List<String>> ans = new ArrayList<List<String>>();

        for (int i = 0; i < lens; i++) {
            int father = unionSet.father[i];
            if( Maps.containsKey(father)){
                List<String> temp = ans.get(Maps.get(father));
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    if(!temp.contains(accounts.get(i).get(j))){
                        temp.add(accounts.get(i).get(j));
                    }
                    
                }
                // ans.set(Maps.get(father), temp);

            }else{
                Maps.put(father, ans.size());
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    if(!temp.contains(accounts.get(i).get(j))){
                        temp.add(accounts.get(i).get(j));
                    }
                }
                ans.add(temp);
            }
            
        } 
        for (int i = 0; i < ans.size(); i++) {
            List<String> temp = ans.get(i);
            temp.set(0, "!!!"+temp.get(0));
            Collections.sort(temp,new Comparator<String>(){
                @Override
                public int compare(String s1,String s2){
                    return s1.compareTo(s2);
                }
 
            });
            temp.set(0, temp.get(0).substring(3));
          
        }
        return ans; 

    }
}
// @lc code=end