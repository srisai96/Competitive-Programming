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
public class bstChecker {
    public boolean checkBST(BinaryTreeNode root,int min,int max)
    {
        if(root!=null)
        {
            if(root.value>min && root.value<max){
                return checkBST(root.left,min,root.value) && checkBST(root.right,root.value,max);

            }
            else{
                return false;
            }
        }
        else
        {
            return true;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode bt = new BinaryTreeNode(50);
        BinaryTreeNode a30 =bt.insertLeft(30);
        BinaryTreeNode a60 = a30.insertRight(40);
        BinaryTreeNode a20 = a30.insertLeft(20);
        BinaryTreeNode a80 = bt.insertRight(80);
        BinaryTreeNode a70 = a80.insertLeft(70);
        BinaryTreeNode a90 = a80.insertRight(90);

        bstChecker obj = new bstChecker();
        System.out.println(obj.checkBST(bt,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}