package week04.BOJ_5_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 강용민_1991{
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char lValue = st.nextToken().charAt(0);
            char rVlaue = st.nextToken().charAt(0);

            Node.insertNode(head, value, lValue, rVlaue);
        }

        Node.preOrder(head);
		System.out.println();
		Node.inOrder(head);
		System.out.println();
		Node.postOrder(head);
		System.out.println();
    }

    static class Node{
        char value;
        Node lNode;
        Node rNode;
        
        Node(char value, Node lNode, Node rNode){
            this.value = value;
            this.lNode = rNode;
            this.rNode = rNode;
        }

        public static void insertNode(Node root, char value, char lValue, char rValue){
            if(root.value == value){
                root.lNode = (lValue == '.' ?null :new Node(lValue,null,null));
                root.rNode = (rValue == '.' ?null :new Node(rValue,null,null));
            }
            else{
                if(root.lNode != null) insertNode(root.lNode, value, lValue, rValue);
                if(root.rNode != null) insertNode(root.rNode, value, lValue, rValue);
            }
        }

        public static void preOrder(Node node) {
            if(node ==null) return;
            System.out.print(node.value);
            preOrder(node.lNode);
            preOrder(node.rNode);
        }
        
        public static void inOrder(Node node) {
            if(node ==null) return;
            inOrder(node.lNode);
            System.out.print(node.value);
            inOrder(node.rNode);
        }
        
        public static void postOrder(Node node) {
            if(node ==null) return;
            postOrder(node.lNode);
            postOrder(node.rNode);
            System.out.print(node.value);
        }
    }

}