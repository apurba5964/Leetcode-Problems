package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphs {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}	

private Map<Node, Node> map = new HashMap<Node, Node>();
// DFS Clone graph
public Node cloneGraph(Node node) {
    if (node == null) return null;
    if (map.containsKey(node)) return map.get(node);
    Node copy = new Node(node.val,new ArrayList<Node>());
    map.put(node, copy);
    for (Node n : node.neighbors)
        copy.neighbors.add(cloneGraph(n));
    return copy;
}
    
    


}
