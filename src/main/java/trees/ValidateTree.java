package trees;

import java.util.ArrayDeque;

public class ValidateTree {

  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>();
    TreeNode previous = null;

    while (root != null || !nodeStack.isEmpty()) {
      while (root != null) {
        nodeStack.push(root);
        root = root.left;
      }
      root = nodeStack.pop();
      if (previous != null && root.val <= previous.val) return false;
      previous = root;
      root = root.right;
    }

    return true;
  }
}
