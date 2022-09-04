package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CloneGraph {
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node7);

        node3.neighbors.add(node1);

        node4.neighbors.add(node1);
        node4.neighbors.add(node5);
        node4.neighbors.add(node6);
        node4.neighbors.add(node8);

        node5.neighbors.add(node4);

        node6.neighbors.add(node4);

        node7.neighbors.add(node2);

        node8.neighbors.add(node4);

        Node result = cloneGraph(node1);

        Node[] visited = new Node[101];

        visited[result.val] = result;
        displayGraph(result, visited);

    }

    private static void displayGraph(Node result, Node[] visited) {
        if(result == null)
            return;
        //System.out.println(result.val);
        List<Integer> temp = new ArrayList<>();
        for (Node adj : result.neighbors) {
            temp.add(adj.val);
            if(visited[adj.val] == null) {
                visited[adj.val] = adj;
                displayGraph(adj, visited);
            }
        }
        System.out.println(result.val+" - "+ temp);
    }

    public static Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        //visited.add(new Node());    //dummy node

        Node copy = new Node(node.val);

        visited[copy.val] = copy;
        for(Node adj : node.neighbors){
            if(visited[adj.val] == null){
                Node newNode = new Node(adj.val);
                copy.neighbors.add(newNode);
                dfs(adj, newNode, visited);
            }
            else{
                copy.neighbors.add(visited[adj.val]);
            }
        }

        return copy;
    }

    private static void dfs(Node curr, Node node, Node[] visited){
        visited[node.val] = node;

        for(Node adj : curr.neighbors){
            if(visited[adj.val] == null){
                Node newNode = new Node(adj.val);
                node.neighbors.add(newNode);
                dfs(adj, newNode, visited);
            }
            else{
                node.neighbors.add(visited[adj.val]);
            }
        }
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
