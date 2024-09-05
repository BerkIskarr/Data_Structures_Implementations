public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    int counter=0;

    public BinaryTree(int value) { this (value, null, null); }

    public BinaryTree(int value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left  = left;
        this.right = right;
    }

    public boolean isLeaf() { return left == null && right == null; }
    public BinaryTree leftChild()  { return left;  }
    public BinaryTree rightChild() { return right; }
    public int value() { return value; }

    /***************************************************************
     * contains(), written in a way that might be a bit less       *
     * cryptic              *
     **************************************************************/
    public boolean contains(int i) {
        if (this.value == i)
            return true;
        else if (left.contains(i))
            return true;
        else if (right.contains(i))
            return true;
        else
            return false;
    }

    /***************************************************************
     *  Part a                                                     *
     **************************************************************/
    public int size() {
        counter++;
        if(right!=null){counter+=rightChild().size();}

        if(left!=null){counter+=leftChild().size();}
        return counter; // placeholder
    }
    int total=0;
    /***************************************************************
     *  Part b                                                     *
     **************************************************************/
    public int total() {
        total+=value;
        if(right!=null){total+= rightChild().total();}
        if(left!=null){total+= leftChild().total();}
        return total; // placeholder
    }

    /***************************************************************
     *  Part c                                                     *
     **************************************************************/
    int maxval;
    public int max() {
        maxval=value;
        if(right!=null){maxval=right.max();}
        return maxval;
    }

    /***************************************************************
     *  Part d                                                     *
     **************************************************************/
    int leftheight, rightheight;
    public int height () {
    rightheight=1;
    if(right!=null){rightheight+=right.height();}
    if(left!=null){leftheight+=left.height();}
        return leftheight >= rightheight ? leftheight : rightheight; // placeholder
    }

    /***************************************************************
     *  Part e                                                     *
     **************************************************************/

    public BinaryTree mirror () {
        BinaryTree mirroredTree = new BinaryTree(value);
        if (right != null) {
            mirroredTree.left = right.mirror();
        }
        if (left != null) {
            mirroredTree.right = left.mirror();
        }

        return mirroredTree;
    }

    /***************************************************************
     *  Code to generate test trees and  *
     *  to convert trees to strings.                               *
     ***************************************************************
     *  tree1:     5         tree2:     5         tree3:     5
     *           /   \                 / \                 /   \
     *          /     \               /   \               /     \
     *         3       8             3     8             3       8
     *          \     / \                   \             \     / \
     *           4   7   9                   9             6   7   9
     */

    public static BinaryTree getTestTree1 () {
        return new BinaryTree (5,
                new BinaryTree (3, null, new BinaryTree (4)),
                new BinaryTree (8, new BinaryTree (7), new BinaryTree (9)));
    }

    public static BinaryTree getTestTree2 () {
        return new BinaryTree (5,
                new BinaryTree (3, null, null),
                new BinaryTree (8, null, new BinaryTree (9)));
    }

    public static BinaryTree getTestTree3 () {
        return new BinaryTree (5,
                new BinaryTree (3, null, new BinaryTree (6)),
                new BinaryTree (8, new BinaryTree (7), new BinaryTree (9)));
    }

    public String toString () {
        String s = "";
        if (left != null)
            s += left.toString() + " ";
        s += Integer.toString (value);
        if (right != null)
            s += " " + right.toString();
        return s;
    }
}
