public class SimpleTreeMap {

    TreeNode root;

    SimpleTreeMap() {
        root = null;
    }

    void put(String key, int value) {
        root = putNode(root, key, value);
    }

    TreeNode putNode(TreeNode node, String key, int value) {
        if (node == null) {
            return new TreeNode(key, value);
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            node.left = putNode(node.left, key, value);
        } else if (cmp > 0) {
            node.right = putNode(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    int get(String key) {
        TreeNode current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.value;
            }
        }

        return -1;
    }


    void printTree() {
        System.out.println("TreeMap :");
        printInOrder(root);
    }

    void printInOrder(TreeNode node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.println(node.key + " = " + node.value);
        printInOrder(node.right);
    }
}