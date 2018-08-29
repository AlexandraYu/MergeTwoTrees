public class MergeBinaryTrees{
    public static TreeNode merge(TreeNode n1, TreeNode n2) {
        if(n1==null) return n2; 
        if(n2==null) return n1; 
        n1.data = n1.data+n2.data; 
        n1.left = merge(n1.left, n2.left);
        n1.right = merge(n1.right, n2.right);
        return n1; 
    }

    public static void main(String []args){
        TreeNode node1, node2, node3, node4, node5; 
        TreeNode resultHeadNode; 
        node1 = new TreeNode(1);
        node2 = new TreeNode(2); 
        node3 = new TreeNode(3);
        node4 = new TreeNode(4);
        node5 = new TreeNode(5);
        node1.right = node2; 
        node4.left = node3; 
        node4.right = node5; 
        resultHeadNode = merge(node1, node4); 
        printTree(resultHeadNode); 
        
    }
    private static void printTree(TreeNode treeHead) {
        if(treeHead==null) return;
        printTree(treeHead.left);
        System.out.print("inorder: "+treeHead.data+"\n"); 
        printTree(treeHead.right); 
    }
    
}

class TreeNode {
    TreeNode left; 
    TreeNode right;
    int data; 
    TreeNode(int input) {
        this.data = input; 
    }
}

