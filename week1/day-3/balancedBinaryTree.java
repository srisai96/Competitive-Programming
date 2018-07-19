class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}


class Height
{
    int height = 0;
}

public class balancedBinaryTree {
    public boolean isBalanced(BinaryTreeNode root,Height h)
    {
        if(root==null)
        {
            h.height=0;
            return true;
        }
        Height lh=new Height();
        Height rh=new Height();

        boolean leftSTree=isBalanced(root.left,lh);
        boolean rightSTree=isBalanced(root.right,rh);

        h.height=(lh.height>rh.height?lh.height:rh.height)+1;

        if((lh.height-rh.height>=2)||(rh.height-lh.height>=2))
        {
            if((lh.height!=0)&&(rh.height!=0))
                return false;
        }


            return leftSTree & rightSTree;

    }
    public static void main(String[] args) {
        Height height = new Height();
        balancedBinaryTree tree=new balancedBinaryTree();
        BinaryTreeNode bt = new BinaryTreeNode(50);
        /*
        BinaryTreeNode btL=bt.insertLeft(2);
        BinaryTreeNode btLR=btL.insertRight(3);
        BinaryTreeNode btLRR=btLR.insertRight(4);
        */

        BinaryTreeNode a30 =bt.insertLeft(30);
        BinaryTreeNode a60 = a30.insertRight(40);
        BinaryTreeNode a20 = a30.insertLeft(20);
        BinaryTreeNode a80 = bt.insertRight(80);
        BinaryTreeNode a70 = a80.insertLeft(70);
        BinaryTreeNode a90 = a80.insertRight(90);



        System.out.println(tree.isBalanced(bt,height));
    }
}