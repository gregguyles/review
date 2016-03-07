package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ory on 2/20/16.
 */
public class GenBSearchTree <T extends Comparable>{
    GenBNode<T> root;
    public GenBSearchTree() {
        this.root = null;
    }
    public GenBSearchTree(T data) {
        this.root = new GenBNode(data);
    }

    public boolean add(T data) {
        return add(this.root, data);
    }

    private boolean add(GenBNode root, T data) {
        if (root == null) {
            this.root = new GenBNode<T>(data);
            return true;
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

    private void printInOrder(GenBNode<T> root) {
        if (root == null)
            return;
        printInOrder(root.getLeft());
        System.out.print(root.getData() + ", ");
        printInOrder(root.getRight());
    }

    public void printLevels() {
        if (this.root == null) {
            System.out.println("This tree is empty");
            return;
        }
        int level = 0;
        Queue<GenBNode<T>> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        System.out.print("\n" + level + ": ");
        while (!que.isEmpty()) {
            GenBNode current = que.poll();
            if (current == null) {
                if (!que.isEmpty()) {
                    que.add(null);
                    System.out.print("\n" + ++level + ": ");
                } else {
                    System.out.println();
                    return;
                }
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

    public int height() {
        if (this.root == null) { return 0; }
        int level = 0;
        Queue<GenBNode<T>> que = new LinkedList<>();
        que.add(this.root);
        que.add(null);
        level++;
        while (!que.isEmpty()) {
            GenBNode current = que.poll();
            if (current == null) {
                if (!que.isEmpty()) {
                    que.add(null);
                    level++;
                } else
                    return level;
            }
            else {
                if (current.getLeft() != null)
                    que.add(current.getLeft());
                if (current.getRight() != null)
                    que.add(current.getRight());
            }
        }
        return level;
    }
}
