
abstract class BinaryTree {
    public static class Node {
        private Product product;

        private Node parent;
        private Node left;
        private Node right;

        public Node(Product product) {
            this.product = product;
            this.left = null;
            this.right = null;
        }

        public Node getParent() {
            return this.parent;
        }

        public Node getLeft() {
            return this.left;
        }

        public Node getRight() {
            return this.right;
        }

        public Product getProduct() {
            return this.product;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
        this.root.setParent(null);
    }

    public void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.product.getProductCode() + " ");
            inOrder(current.right);
        }
    }

    public Node minNode(Node current) {
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public Node maxNode(Node current) {
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public Product find(Product product) {
        Node current = this.root;

        while (current.product.getProductCode() != product.getProductCode()) {
            if (product.getProductCode() < current.product.getProductCode()) {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }

        return current.product;
    }
}
