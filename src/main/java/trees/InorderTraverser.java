package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InorderTraverser {

  public List<Integer> traverseInorder(TreeNode root) {
    if (root == null) return Collections.emptyList();

    ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();

    while (root != null || !nodeStack.isEmpty()) {
      while (root != null) {
        nodeStack.push(root);
        root = root.left;
      }
      root = nodeStack.pop();
      result.add(root.val);
      root = root.right;
    }

    return result;
  }
}
