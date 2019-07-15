package edu.ub.leetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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

//https://leetcode.com/problems/satisfiability-of-equality-equations
public boolean equationsPossible(String[] equations) {
	ArrayList<Integer> res = new ArrayList<>();
	
    int[] map = new int[26];
    
    for(int i=0;i<26;i++)
        map[i]=i;
    
    for(String s: equations){
        char ch1 = s.charAt(0);
        char ch2 = s.charAt(1);
        char ch3 = s.charAt(3);
        
        if(ch2=='='){
            int i = ch1-'a';
            int j = ch3-'a';
            markAsSame(map,i,j);
        }else{
           int i = ch1-'a';
           int j = ch3-'a';
           if(map[i]==map[j])
               return false;
        }
        
    
        
    }
    
    for(String s: equations){
        char ch1 = s.charAt(0);
        char ch2 = s.charAt(1);
        char ch3 = s.charAt(3);
        
        if(ch2=='!'){
           
           int i = ch1-'a';
           int j = ch3-'a';
           if(map[i]==map[j])
               return false;
        }
        
    
        
    }
    
    return true;
}


public void markAsSame(int[] map,int i,int j){
    int min = Math.min(i,j);
    int temp1 = map[i];
    int temp2 = map[j];
    map[i]=min;
    map[j]=min;
   
    
    for(int k=0;k<26;k++){
        if(map[k]==i || map[k]==j || map[k]==temp1|| map[k]==temp2){
            map[k]=min;
        }
            
    }
    //System.out.println(map[0]+" "+i+" "+j);    
    
}






//https://leetcode.com/problems/course-schedule-ii/
public int[] findOrder(int numCourses, int[][] prerequisites) {
	 
    int[] res = new int[numCourses];
    int[] indeg = new int[numCourses];
    Queue<Integer> q = new LinkedList<>();
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    
    
    for(int[] preq: prerequisites){
      ArrayList<Integer> temp = map.getOrDefault(preq[1],new ArrayList<Integer>());
        temp.add(preq[0]);
        map.put(preq[1],temp);
        indeg[preq[0]]++;
    }
    
    for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0)
            q.add(i);
    }
   
        
    
    int n=0;
    while(!q.isEmpty()){
        int course = q.poll();
        
        if(map.containsKey(course)){
            ArrayList<Integer> temp = map.get(course);
            for(int i:temp){
                 indeg[i]--;
                 if(indeg[i]==0)
                     q.add(i);
            }
               
            
        }
        //System.out.println(course);
        res[n++]=course;
        
    }
    //System.out.println(n);
   
    if(n==numCourses)
        return res;
    else
        return new int[0];
    
    
}

//https://leetcode.com/problems/reconstruct-itinerary/
LinkedList<String> q = new LinkedList<>();

public List<String> findItinerary(List<List<String>> tickets) {
 
    HashMap<String,PriorityQueue<String>> map = 
        new HashMap<String,PriorityQueue<String>>();
    
    for(List<String> s: tickets){
     PriorityQueue<String> list = map.getOrDefault(s.get(0),new PriorityQueue<String>());
        list.add(s.get(1));
        map.put(s.get(0),list);
    }
    
    
   // q.add("JFK");
    doDFS(map,"JFK");
    
    return q;
}


public void doDFS(HashMap<String,PriorityQueue<String>> map,String src){
    
    while(map.containsKey(src) && !map.get(src).isEmpty()){
        doDFS(map,map.get(src).poll());
    }
    q.addFirst(src);
}




}
