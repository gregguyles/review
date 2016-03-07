import CodeRust.CRString;
import tree.Tree;

/**
 * Created by ory on 3/6/16.
 */
public class Runner03 {
    public static void main(String[] args) {
        CRString crStr = new CRString();
        String out = crStr.removeDup("aabbacccdddeddaadea");
        System.out.println(out);

        System.out.println(crStr.reverseWords("Hello new far away World"));

        String[] dict = { "apple", "pear", "pier", "pie"};
        System.out.println(crStr.canSegment(dict, "applepearpieapple"));

        String html = "" +
                "<html>\n" +
                "   <body>\n" +
                "       <div>\n" +
                "           <h1>CodeRust</h1>\n" +
                "           <a>http://coderust.com</a>\n" +
                "       </div>\n" +
                "       <div>\n" +
                "           <h2>Chapter 1</h2>\n" +
                "       </div>\n" +
                "       <div>\n" +
                "           <h3>Chapter 2</h3>\n" +
                "           <h4>Chapter 2.1</h4>\n" +
                "       </div>\n" +
                "   </body>\n" +
                "</html>\n";

        Tree tree = crStr.htmlToTree(html);
        tree.printLevels();

    }

}
