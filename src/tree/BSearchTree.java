package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ory on 2/20/16.
 */
public class BSearchTree {
    BNode root;
    public BSearchTree(Comparable data) {
        this.root = new BNode(data);
    }

    public boolean add(Comparable data) {
        return add(this.root, data);
    }

    private boolean add(BNode root, Comparable data) {
        if (root == null) {
            this.root = new BNode(data);
            return true;
        }
        if (!root.getData().getClass().equals(data.getClass())) {
            return false;
        }
        if (root.getData().compareTo(data) >= 0) {
            if (root.getLeft() == null) {
                root.setLeft(data);
                return true;
            } else
                return add(root.getLeft(), data);
        } else {
            if (root.getRight() == null) {
                root.setRight(data);
                return true;
            } else
                return add(root.getRight(), data);
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(BNode root) {
        if (root == null)
            return;
        printInOrder(root.getLeft());
        System.out.print(root.getData() + ", ");
        printInOrder(root.getRight());
    }

    public void printLevels() {
        int level = 0;
        Queue<BNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        System.out.print("\n" + level + ": ");
        while (!que.isEmpty()) {
            BNode current = que.poll();
            if (current == null) {
                if (!que.isEmpty()) {
                    que.add(null);
                    System.out.print("\n" + ++level + ": ");
                } else
                    return;
            }
            else {
                if(current.getLeft() != null)
                    que.add(current.getLeft());
                if(current.getRight() != null)
                    que.add(current.getRight());
                System.out.print(current.getData() + " ");
            }
        }
    }
}
