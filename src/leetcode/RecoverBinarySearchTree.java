package leetcode;

public class RecoverBinarySearchTree {
    static TreeNode pre;
    static TreeNode mistake1;
    static TreeNode mistake2;
   public void recoverTree(TreeNode root) {
       pre = null;
       mistake1 = null;
       mistake2 = null;
       recover(root);
       if(mistake1 != null && mistake2 != null)
       {
           int value = mistake1.val;
           mistake1.val = mistake2.val;
           mistake2.val = value;
       }
   }
   
   public void recover(TreeNode node)
   {
       if(node == null)
           return;
       recover(node.left);
       if(pre == null)
           pre = node;
       else
       {
           if(pre.val > node.val)
           {
               if(mistake1 == null)
                   mistake1 = pre;
               mistake2 = node;
           }
           pre = node;
       }
       recover(node.right);
   }
}
