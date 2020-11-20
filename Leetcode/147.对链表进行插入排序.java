import java.util.List;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if( head == null){
            return null;
        }
        ListNode ans = new ListNode(0);
        ans.next = head; 
        head.next = null;
        ListNode Second = head.next;
        
        while(Second != null){
            ListNode temp = Second.next;
            ListNode pos = ans;
            ListNode pos_2;
            while((pos_2=pos.next) != null && Second.val > pos_2.val){
                pos = pos_2; 
            }
            if(pos_2 != null){
                Second.next = pos.next;
                pos.next = Second;
            }else{
                pos.next = Second;
                Second.next = null;
            }
            Second = temp;

        }
        return ans.next;

    }
}
// @lc code=end

