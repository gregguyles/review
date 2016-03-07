/**
 * Created by ory on 2/20/16.
 */
import tree.BSearchTree;
import tree.GenBSearchTree;

public class Runner01 {

    public static void main(String[] args) {

        GenBSearchTree<Integer> bTree = new GenBSearchTree<Integer>(100);
        bTree.add(50);
        bTree.add(75);
        bTree.add(200);
        bTree.add(25);
        bTree.add(350);

        bTree.printInOrder();
        bTree.printLevels();
        System.out.println(bTree.height());
        GenBSearchTree<Integer> bTree2 = new GenBSearchTree<Integer>();
        bTree2.printLevels();
        System.out.println(bTree2.height());
    }
}
