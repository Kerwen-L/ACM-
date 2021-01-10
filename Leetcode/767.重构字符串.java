import java.lang.invoke.ClassSpecializer.Factory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.graalvm.compiler.phases.common.CanonicalizerPhase.CustomCanonicalizer;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
class Solution {
    private StringBuffer ans = new StringBuffer("");
    private Boolean sign = false;
    private List<Integer> values = null;
    private Map< Character, Integer> counMap = null;
    public String reorganizeString(String S) {
         
        counMap =new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char a = S.charAt(i);
            counMap.put(a, counMap.getOrDefault(a, 0)+1 );
            
        }
        values = new ArrayList<Integer>(counMap.values()); 
        int Maxvalue = Collections.max(values);
        int Allvalues = 0;
        for (int object : values) {
            Allvalues += object;
        }
        if (Maxvalue > (Allvalues - Maxvalue + 1)){
            return ans.toString();
        }
        DFS('1');
        return ans.toString();

    }

    public void DFS(char s){
        if ( counMap.size() == 0){
            sign = true;
            return;
        }
        List<Map.Entry<Character, Integer>> infoIds =
        new ArrayList<Map.Entry<Character, Integer>>(counMap.entrySet());
 
        //排序
        Collections.sort(infoIds, new Comparator<Map.Entry<Character, Integer>>() {   
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {      
                //return (o2.getValue() - o1.getValue()); 
                return o1.getValue() > o2.getValue() ? -1:1;
            }
        }); 

       
        for (Map.Entry<Character, Integer> entry : infoIds) { 
            Character character = entry.getKey();
            if (!character.equals(s)){
                ans.append(character);
                counMap.put(character, counMap.get(character)-1);
                if(counMap.get(character) == 0){
                    counMap.remove(character);
                }
                DFS(character);
                break;
            }
        } 
    }
}
// @lc code=end

