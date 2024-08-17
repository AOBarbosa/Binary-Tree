import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Main {
    private static void populateTree(@NotNull BinarySearchTree tree) {
        tree.insert(new Product(28, "Product 28", 55));
        tree.insert(new Product(10, "Product 10", 10));
        tree.insert(new Product(5, "Product 5", 3));
        tree.insert(new Product(15, "Product 15", 31));
        tree.insert(new Product(3, "Product 3", 1));
        tree.insert(new Product(7, "Product 7", 9));
        tree.insert(new Product(12, "Product 12", 55));
        tree.insert(new Product(20, "Product 20", 2));
        tree.insert(new Product(42, "Product 42", 10));
        tree.insert(new Product(91, "Product 91", 9));
        tree.insert(new Product(17, "Product 17", 3));
        tree.insert(new Product(86, "Product 86", 31));
        tree.insert(new Product(63, "Product 63", 1));
        tree.insert(new Product(74, "Product 74", 2));
        tree.insert(new Product(45, "Product 45", 2));
    }

    private static void findProducts(@NotNull BinarySearchTree tree) {
        Random random = new Random();
        int[] codes = new int[10];

        for (int code : codes) {
            code = random.nextInt(91) + 3;
            System.out.print("Find Node: ");
            if (tree.find(code) != null) {
                System.out.println("Produto encontrado: " + tree.find(code).getProduct().getProductName() + " -> qtd: " + tree.find(code).getProduct().getProductAmount());
            } else {
                System.out.println("Produto com codigo " + code +  " não encontrado...");
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree estoque = new BinarySearchTree();
        populateTree(estoque);

        System.out.print("In Order: ");
        estoque.inOrder(estoque.getRoot());
        System.out.println();
        System.out.println("---------------");

        System.out.print("Min Node: ");
        System.out.println(estoque.minNode(estoque.getRoot()).getProduct().getProductCode());
        System.out.println("---------------");

        System.out.print("Max Node: ");
        System.out.println(estoque.maxNode(estoque.getRoot()).getProduct().getProductCode());
        System.out.println("---------------");

        findProducts(estoque);
        System.out.println("---------------");

        System.out.println("Remove Leaf: 6");
        estoque.remove(6);
        System.out.println();

        System.out.println("Remove node with only one child: 63");
        estoque.remove(63);
        System.out.println();

        System.out.println("Remove node with only two children: 42");
        estoque.remove(42);
        System.out.println();

        estoque.inOrder(estoque.getRoot());
    }
}