package tree;

/**
 * Created by ory on 2/20/16.
 */
public class GenBNode <T extends Comparable>{
    private GenBNode right;
    public GenBNode left;
    public T data;

    public GenBNode(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
    public GenBNode getRight()      { return right;}
    public GenBNode getLeft()       { return left;}
    public T getData()              { return data;}
    public void setRight(T data)    { this.right = new GenBNode(data);}
    public void setLeft( T data)    { this.left  = new GenBNode(data);}
    public void setData( T data)    { this.data  = data;
    }
}
