package CodeRust;

import java.util.*;

import tree.Tree;
import tree.Tree.Node;

/**
 * Created by ory on 3/6/16.
 */

public class CRString {

    public String removeDup(String input) {
        Set letters = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!letters.contains(c)) {
                letters.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String reverseWords(String input) {
        StringBuilder sb = new StringBuilder();
        String[] words = input.split("\\s");
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public boolean canSegment(String[] dict, String str) {
        Set<String> wordDict = new HashSet<String>(Arrays.asList(dict));
        int start = 0;
        int end = start + 1;
        boolean segmented = false;
        while (end <= str.length()) {
            segmented = wordDict.contains(str.substring(start, end));
            if (segmented) {
                start = end;
            }
            end++;
        }
        return segmented;
    }


    public boolean isAllSpaces(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                return false;
        }
        return true;
    }

    public Tree<String> htmlToTree(String html) {
        String arr[] = html.split("<|>|\n");
        int idx = 0;
        while (isAllSpaces(arr[idx]))
            idx++;
        Node<String> root = new Node<String>(arr[idx++]);
        Stack<Node<String>> stk = new Stack<Node<String>>();
        stk.push(root);
        for (; idx < arr.length; idx++){
            if (isAllSpaces(arr[idx])) {
                continue;
            }
            if (arr[idx].charAt(0) == '/'){
                Node<String> n = stk.pop();
                while (!arr[idx].substring(1).equals(n.getData()))
                    n = stk.pop();
            }
            else {
                Node<String> n = new Node<String>(arr[idx]);
                stk.peek().getChildren().add(n);
                stk.push(n);
            }
        }
        return new Tree<String>(root);
    }
}
