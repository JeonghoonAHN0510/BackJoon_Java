import java.io.*;
import java.util.*;

class Node {
    String name;
    Node left, right;
    public Node(String name){
        this.name = name;
        left = right = null;
    }
}

public class Main {
    static StringBuilder answer = new StringBuilder();
    static Map<String, Node> nodeMap = new HashMap<>();
    static int nodeNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        nodeNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < nodeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            String parentNode = st.nextToken();
            String leftNode = st.nextToken();
            String rightNode = st.nextToken();

            Node parent = getNode(parentNode);

            if (!leftNode.equals(".")){
                Node left = getNode(leftNode);
                parent.left = left;
            }
            if (!rightNode.equals(".")){
                Node right = getNode(rightNode);
                parent.right = right;
            }
        }

        preOrder(nodeMap.get("A"));
        answer.append("\n");
        inOrder(nodeMap.get("A"));
        answer.append("\n");
        postOrder(nodeMap.get("A"));

        bw.write(answer.toString().trim());
        bw.flush();
        bw.close();
    }
    private static Node getNode(String name) {
        return nodeMap.computeIfAbsent(name, key -> new Node(key));
    }
    static void preOrder(Node node) {
        if (node == null) return;
        answer.append(node.name);
        preOrder(node.left);
        preOrder(node.right);
    }
    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        answer.append(node.name);
        inOrder(node.right);
    }
    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        answer.append(node.name);
    }
}