import org.jetbrains.annotations.NotNull;

public class BinarySearchTree extends BinaryTree {
    public void insert(Product product) {
        Node newNode = new Node(product);

        if (this.getRoot() == null) {
            this.setRoot(newNode);
        } else {
            Node current = this.getRoot();
            Node parent;

            while (true) {
                parent = current;

                if (product.getProductCode() < current.getProduct().getProductCode()) {
                    current = current.getLeft();

                    if (current == null) {
                        parent.setLeft(newNode);
                        newNode.setParent(parent); // Define o nó pai
                        return;
                    }
                } else {
                    current = current.getRight();

                    if (current == null) {
                        parent.setRight(newNode);
                        newNode.setParent(parent); // Define o nó pai
                        return;
                    }
                }
            }
        }
    }


    public Node find(int key) {
        if (this.getRoot() == null) return null;

        Node current = this.getRoot();

        while (current.getProduct().getProductCode() != key) {
            if (key < current.getProduct().getProductCode()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current == null) {
                return null;
            }
        }

        return current;
    }

    private void removeLeaf(@NotNull Node node) {
        if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(null);
        } else {
            node.getParent().setRight(null);
        }
    }

    private void transplant(@NotNull Node u, Node v) {
        if (u.getParent() == null) {
            this.setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }

        if (v != null) {
            v.setParent(u.getParent());
        }
    }

    public void remove(int key) {
        Node node = this.find(key);

        if (node == null) return;

        if (node.isLeaf()) {
            this.removeLeaf(node);
            System.out.println("Folha removida");
        } else if (node.getLeft() == null) {
            this.transplant(node, node.getRight());
        } else if (node.getRight() == null) {
            this.transplant(node, node.getLeft());
        } else {
            Node successor = this.minNode(node.getRight());

            if (successor.getParent() != node) {
                this.transplant(successor, successor.getRight());
                successor.setRight(node.getRight());
                successor.getRight().setParent(successor);
            }

            this.transplant(node, successor);
            successor.setLeft(node.getLeft());
            successor.getLeft().setParent(successor);
        }
    }
}
