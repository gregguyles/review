/**
 * Created by ory on 2/20/16.
 */
import tree.BSearchTree;
public class Runner01 {

    public static void main(String[] args) {

        BSearchTree bTree = new BSearchTree(100);
        bTree.add(50);
        bTree.add(75);
        bTree.add(200);
        bTree.add(25);
        bTree.add(350);

        bTree.printInOrder();
        bTree.printLevels();
    }
}
