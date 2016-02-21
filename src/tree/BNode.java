package tree;

/**
 * Created by ory on 2/20/16.
 */
public class BNode {
    private BNode right;
    public BNode left;
    public Comparable data;

    public BNode(Comparable data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
    public BNode getRight() {
        return right;
    }
    public BNode getLeft() {
        return left;
    }
    public Comparable getData() {
        return data;
    }
    public void setRight(Comparable data) {
        this.right = new BNode(data);
    }
    public void setLeft(Comparable data) {
        this.left = new BNode(data);
    }
    public void setData(Comparable data) {
        this.data = data;
    }
}
