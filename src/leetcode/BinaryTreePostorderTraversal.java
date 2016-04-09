package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null)
        {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root !=null || !stack.isEmpty())
        {
            if(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                TreeNode node = stack.peek();
                if(node.right!=null && pre != node.right)
                {
                    root = node.right;
                }
                else
                {
                    list.add(node.val);
                    pre = node;
                    stack.pop();
                }
            }
        }
        return list;
    }
}