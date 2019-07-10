package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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


//https://leetcode.com/problems/word-ladder/

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(beginWord.equals(endWord))
        return 1;
    Queue<String> q = new LinkedList<>();
    
    q.add(beginWord);
    HashSet<String> visited = new HashSet<>();
    HashSet<String> wl = new HashSet<>();
    for(String s:wordList){
        wl.add(s);
    }
    if(!wl.contains(endWord))
        return 0;
    
    wl.remove(beginWord);
    visited.add(beginWord);
    int dist = 2;
    
    while(!q.isEmpty()){
        int sz = q.size();
    
        for(int j=0; j<sz; j++) {
        String s1 = q.poll();
        
        
        for(int i=0;i<s1.length();i++){
            char[] chars = s1.toCharArray();
            for(char c = 'a';c<='z';c++){
                chars[i]=c;
                String newStr = new String(chars);
                if(newStr.equals(endWord))
                        return dist;
                
                if(!visited.contains(newStr)){
                   
                    visited.add(newStr);
                    
                    if(wl.contains(newStr))
                        q.add(newStr);
                    
                    
                }
                
            }
           
        }
        }
       
         dist++;
    }
 
    return 0;
}




//https://leetcode.com/problems/number-of-islands/
int m;
int n;
public int numIslands(char[][] grid) {
    if(grid.length==0)
        return 0;
    
    m = grid.length;
    n = grid[0].length;
   
    int result=0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]=='1'){
                doDFS(grid,i,j);
                ++result;
            }
            
           
        }
    }
    
    return result;
}


public void doDFS(char[][] grid,int x,int y){
    if(x<0 || y<0 || x>=m || y>=n || grid[x][y]!='1')
        return;
    
    grid[x][y]='0';
    for(int[] dir:dirs){
        doDFS(grid,x+dir[0],y+dir[1]);
    }    
    
}





//https://leetcode.com/problems/max-area-of-island/
int k;
public int maxAreaOfIsland(int[][] grid) {
    if(grid.length==0)
        return 0;
    
    m = grid.length;
    n = grid[0].length;
   
    int result=0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==1){
                k=0;
                doDFS(grid,i,j);
                result=Math.max(result,k);
                
            }
            
           
        }
    }
    
    return result;
}


public void doDFS(int[][] grid,int x,int y){
    if(x<0 || y<0 || x>=m || y>=n || grid[x][y]!=1)
        return;
    
    grid[x][y]=0;
    //System.out.println(k);
    k++;
   // k=Math.max(k,c);
    for(int[] dir:dirs){
        doDFS(grid,x+dir[0],y+dir[1]);
    }    
    
    
}

}
