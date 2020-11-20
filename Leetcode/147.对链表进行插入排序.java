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
        ListNode ans = new ListNode(-1);
        ans.next = head; 
        ListNode Second = head.next;
        head.next = null;
        while(Second != null){
            ListNode temp = Second.next;
            ListNode pos = ans;
            while(pos.next != null && Second.val > pos.next.val){
                pos = pos.next;
            }
            if(pos.next != null){
                
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

