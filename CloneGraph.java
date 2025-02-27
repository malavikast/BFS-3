import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

//Time Complexity: O(V+E)
//Space Complexity O(2v)~O(v)-> no. of nodes in the hashmap & Queue

/*
// Definition for a Node.
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
*/

class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        map = new HashMap<>();
        Node copyNode = clone(node);
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    clone(neighbor);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private Node clone(Node node) {
        if (map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}