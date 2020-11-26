import javax.swing.tree.TreeNode;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

import sun.font.TrueTypeFont;

/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean search = true;
    private int leaf_node = 0;
    private int Deepth = 0;
    public int countNodes(TreeNode root) {
        int ans = 0;
        if( root == null){
            return ans;
        } 
        TreeNode temp_root = root;
        while(temp_root != null){
            temp_root = temp_root.left;
            this.Deepth += 1;
        } 
        this.DFS(root, 1);
        System.out.println(this.Deepth);
        return (int)(Math.pow(2, this.Deepth-1) +this.leaf_node)-1;

    }

    public void DFS(TreeNode root, int deepth){
        if(deepth == this.Deepth){
            if( root == null){
                this.search = false;
            }else{
                this.leaf_node += 1;
            }
            return ;
        }
        if( root.left != null && this.search){
            this.DFS(root.left, deepth+1);
        }
        if( root.right != null && this.search){
            this.DFS(root.right, deepth+1);
        } 
        return ;


    }
}
// @lc code=end

