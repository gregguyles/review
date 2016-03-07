package tree;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ory on 3/6/16.
 */
public class Tree<T> {

    public static class Node<T>{
        private T data;
        private Node<T> parent;
        private LinkedList<Node<T>> children;
        public Node() {
            this.data = null;
            this.parent = null;
            this.children = new LinkedList<Node<T>>();
        }
        public Node(T data) {
            this();
            this.data = data;
        }
        public Node(Node<T> parent, T data) {
            this(data);
            this.parent = parent;
        }
        public T getData() {
            return this.data;
        }
        public void setData(T data) {
            this.data = data;
        }
        public LinkedList<Node<T>> getChildren() {
            return this.children;
        }
        public Node<T> getParent() {
            return this.parent;
        }
        public void setParent(Node<T> parent) {
            this.parent = parent;
        }
    }

    private Node root;

    public Tree(){
        this.root = new Node<T>();
    }
    public Tree(T data){
        this.root = new Node<T>(data);
    }
    public Tree(Node<T> root){
        this.root = root;
    }

    public void printLevels() {
        if (this.root == null) {
            System.out.println("This tree is empty");
            return;
        }
        int level = 0;
        Queue<Node<T>> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        System.out.print("\n" + level + ": ");
        while (!que.isEmpty()) {
            Node current = que.poll();
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
                Iterator<Node<T>> itr = current.getChildren().iterator();
                while (itr.hasNext()){
                    que.add(itr.next());
                }
                System.out.print(current.getData() + " ");
            }
        }
    }
}
