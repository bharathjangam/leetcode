package leetcode;

public class SumOfLeftLeaves {
    int sumOfLeftLeavesCalculating = 0;
    public static void main(String[] ar){
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        sumOfLeftLeaves.testcase1(sumOfLeftLeaves);
        sumOfLeftLeaves.testcase2(sumOfLeftLeaves);
    }
    private void testcase1(SumOfLeftLeaves sumOfLeftLeaves){
        TreeNode root = populateTreeNodeWithDataForTestcase1();
        int sum = sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println("sum calculated %s"+sum);
        assert true;
        assert sum == 24;
    }
    private void testcase2(SumOfLeftLeaves sumOfLeftLeaves){
        sumOfLeftLeavesCalculating = 0;
        TreeNode root = new TreeNode(1);
        int sum = sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println("sum calculated %s"+sum);
        assert true;
        assert sum == 0;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        recur(root, false);
        return sumOfLeftLeavesCalculating;
    }

    public void recur(TreeNode node, boolean isLeft){

        if(node != null && node.left == null && node.right == null){
            if(isLeft){
                sumOfLeftLeavesCalculating = sumOfLeftLeavesCalculating + node.val;
            }
            return;
        }
        if(node != null && node.left != null){
            recur( node.left,  true );
        }
        if(node != null && node.right != null){
            recur( node.right, false );
        }

    }
    private static TreeNode populateTreeNodeWithDataForTestcase1(){
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.left = node9;
        root.right = node20;

        node20.left = node15;
        node20.right = node7;
       return root;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


