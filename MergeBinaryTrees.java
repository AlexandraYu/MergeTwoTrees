public class MergeBinaryTrees{
    public static TreeNode merge(TreeNode n1, TreeNode n2) {
        //first, consider if there's only one node from either of the 2 trees
        if(n1==null) return n2; 
        if(n2==null) return n1; 
        //2nd, here you get 1 "valid" node from each of the trees so you add the data part
        n1.data = n1.data+n2.data; 
        //we use pre-order traversal to build the tree, which is root, left, right.
        n1.left = merge(n1.left, n2.left); //so we go all the way to the most left node and adding function stack on top of previous function, unless one function is "popped" (returned), the next line will not execute. 
        n1.right = merge(n1.right, n2.right); //by the time this is executed, there's at least 1 n1.left(merge(...) below this function stack
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
        //we use in-order traveral to print the tree
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

