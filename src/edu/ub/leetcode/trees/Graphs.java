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
    
    
public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length==0)
        return 0;
    int[][] visited = new int[matrix.length][matrix[0].length];
    int m= matrix.length;
    int n = matrix[0].length;
    
    int result = 1;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
        int count = doDfS(matrix,visited,i,j,m,n);
        result= Math.max(result,count);    
        }
    }
    
    
    return result;
}

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
public int doDfS(int[][] matrix,int[][] visited,int i,int j,int m,int n){
  
    if(visited[i][j]!=0)
        return visited[i][j];
    int count1 = 1;
    for(int[] dir : dirs){
        int x= i+dir[0];
        int y= j+dir[1];
        if(x<0 || y<0 || x>=m || y>=n || matrix[x][y]<=matrix[i][j])
            continue;
        int dist = 1 + doDfS(matrix,visited,x,y,m,n);
        
        count1=Math.max(dist,count1);
    }
    
    visited[i][j]=count1;
    return count1;
}

}
