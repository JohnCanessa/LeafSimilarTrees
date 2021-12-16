import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {


    // **** list used by leafSimilar0 ****
    static List<Integer> lst = null;


    /**
     * Return true if and only if the two given trees 
     * with head nodes root1 and root2 are leaf-similar.
     * 
     * 40 / 40 test cases passed.
     * Status: Accepted
     * Runtime: 8 ms
     * Memory Usage: 38.9 MB
     */
    static public boolean leafSimilar0(TreeNode root1, TreeNode root2) {
        
        // **** initialization ****
        List<Integer> lst1 = null;
        List<Integer> lst2 = null;

        // **** in-order first BT traversal ****
        lst = new ArrayList<Integer>();
        leafSimilar(root1);
        lst1 = lst;

        // **** in-order second BT traversal ****
        lst = new ArrayList<Integer>();
        leafSimilar(root2);
        lst2 = lst;

        // ???? ????
        // System.out.println("<<< lst1: " + lst1.toString());
        // System.out.println("<<< lst2: " + lst2.toString());

        // **** compare lists ****
        return lst1.equals(lst2);
    }


    /**
     * In-order traversal collecting leaf nodes.
     * Recursive function.
     */
    static private void leafSimilar(TreeNode root) {

        // **** base case ****
        if (root == null) return;

        // **** visit left child ****
        leafSimilar(root.left);

        // **** check if leaf node ****
        if (root.left == null && root.right == null)
            lst.add(root.val);

        // **** visit right child ****
        leafSimilar(root.right);
    }





   /**
     * Return true if and only if the two given trees 
     * with head nodes root1 and root2 are leaf-similar.
     * 
     */
    @SuppressWarnings("unchecked")
    static public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // **** initialization ****
        List<Integer> lst1 = new ArrayList<Integer>();
        List<Integer> lst2 = new ArrayList<Integer>();

        // **** in-order first BT traversal ****
        List<Integer>[] arr1 = new ArrayList[1];
        arr1[0] = lst1;
        leafSimilar(root1, arr1);

        // **** in-order second BT traversal ****
        List<Integer>[] arr2 = new ArrayList[1];
        arr2[0] = lst2;
        leafSimilar(root2, arr2);

        // ???? ????
        // System.out.println("<<< lst1: " + lst1.toString());
        // System.out.println("<<< lst2: " + lst2.toString());

        // **** compare lists ****
        return lst1.equals(lst2);
    }


    /**
     * In-order traversal collecting leaf nodes.
     * Recursive function.
     */
    static private void leafSimilar(TreeNode root, List<Integer>[] lst) {

        // **** base case ****
        if (root == null) return;

        // **** visit left child ****
        leafSimilar(root.left, lst);

        // **** check if leaf node ****
        if (root.left == null && root.right == null)
            lst[0].add(root.val);
            
        // **** visit right child ****
        leafSimilar(root.right, lst);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** create String[] with values for the first BST ****
        String[] strArr1 = br.readLine().trim().split(",");

        // **** create String[] with values for the second BST ****
        String[] strArr2 = br.readLine().trim().split(",");

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< strArr1: " + Arrays.toString(strArr1));
        System.out.println("main <<< strArr2: " + Arrays.toString(strArr2));

        // **** generate an Integer[] to build the first BT ****
        Integer[] arr1 = new Integer[strArr1.length];
        for (int i = 0; i < strArr1.length; i++) {
            if (strArr1[i].equals("null") || strArr1[i].isEmpty())
                arr1[i] = null;
            else
                arr1[i] = Integer.parseInt(strArr1[i]);
        }

        // **** generate an Integer[] to build the second BT ****
        Integer[] arr2 = new Integer[strArr2.length];
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i].equals("null") || strArr2[i].isEmpty())
                arr2[i] = null;
            else
                arr2[i] = Integer.parseInt(strArr2[i]);
        }

        // ???? ????
        System.out.println("main <<<    arr1: " + Arrays.toString(arr1));
        System.out.println("main <<<    arr2: " + Arrays.toString(arr2));

        // **** create and populate the first BT ****
        BST bt1 = new BST();
        bt1.root = bt1.populate(arr1);

        // ???? ????
        System.out.println("main <<<  bt1.inOrder: " + bt1.inOrder(bt1.root));
        System.out.println("main <<< bt1.preOrder: " + bt1.preOrder(bt1.root));

        // ???? ????
        System.out.print("main <<< bst.levelOrderTraversal: ");
        System.out.println(bt1.levelOrderTraversal(bt1.root).toString());
 
        // **** create and populate the second BT ****
        BST bt2 = new BST();
        bt2.root = bt2.populate(arr2);

        // ???? ????
        System.out.println("main <<<  bt2.inOrder: " + bt2.inOrder(bt2.root));
        System.out.println("main <<< bt2.preOrder: " + bt2.preOrder(bt2.root));

        // ???? ????
        System.out.print("main <<< bst.levelOrderTraversal: ");
        System.out.println(bt2.levelOrderTraversal(bt2.root).toString());

        // **** call the function of interest and display result ****
        System.out.println("main <<< leafSimilar0: " + leafSimilar0(bt1.root, bt2.root));



        // **** call the function of interest and display result ****
        System.out.println("main <<<  leafSimilar: " + leafSimilar(bt1.root, bt2.root));



    }

}