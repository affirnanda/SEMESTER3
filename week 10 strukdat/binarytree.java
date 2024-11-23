public class binarytree {
    Node root;

    public static void main(String[] args) {
        binarytree tree = new binarytree();
        /*
         * lakukan proses penambahan data dengan memanggil method insert, ambil studi
         * kasus sebanyak n nilai
         * 
         */

        tree.insert(7);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        tree.insert(9);
        tree.insert(69);
        tree.dataShow();
        tree.findMax();
tree.search(7);
       

    }

    public binarytree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecord(root, data);
    }

    private Node insertRecord(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRecord(root.left, data);
        else if (data > root.data)
            root.right = insertRecord(root.right, data);
        return root;
    }

    public void dataShow() {
        System.out.print("inorder  : ");
        inorderRec(root);
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.print("Postorder : ");
        postorderTraversal(root);
    }

    /*
     * Inorder traversal
     * a. Traverse the left subtree
     * b. Visit the root.
     * c. Traverse the right subtree
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    /*
     * Preorder traversal
     * a. Visit the root.
     * b. Traverse the left subtree
     * c. Traverse the right subtree
     */
    void preorderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /*
     * Postorder traversal
     * a. Traverse the left subtree
     * b. Traverse the right subtree
     * c. Visit the root.
     */

    void postorderTraversal(Node node) {
        if (node == null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null)
            return false;

        else if (root.data == data) {
            System.out.println("Nilai " + data + " ditemukan " + root.data);
            
            return true;
        } else if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    public int findMax() {
        return findMaxRec(root);
    }

    private int findMaxRec(Node root) {
        if (root == null)
            throw new IllegalStateException("Empty Tree");

        /*
         * jika child kanan memiliki nilai null, berarti data ditemukan pada node
         * tersebut
         */
        if (root.right == null) {
            System.out.println("Nilai maksimum di tree: " + root.data);
            return root.data;
        }
        /*
         * rekursif jika data child kanan masih memiliki nilai
         */
        return findMaxRec(root.right);
    }

    // Node Class
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
