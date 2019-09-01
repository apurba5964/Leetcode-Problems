package edu.ub.leetcode.trees;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Arrays;
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



//https://leetcode.com/problems/shortest-path-with-alternating-colors/
public int[] shortestAlternatingPaths(int n, int[][] r, int[][] b) {
    
    Queue<Integer> q = new LinkedList<>();
   
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    
    
    for(int i=0;i<r.length;i++){
        List<Integer> list = map.getOrDefault(r[i][0],new ArrayList<Integer>());
        list.add(r[i][1]);
        map.put(r[i][0],list);
    }
    
    for(int i=0;i<b.length;i++){
        List<Integer> list = map.getOrDefault(b[i][0],new ArrayList<Integer>());
        list.add(-b[i][1]);
        map.put(b[i][0],list);
    }
    
    int[] res=new int[n];
    Arrays.fill(res, -1);
    res[0]=0;
    if(!map.containsKey(0))
        return res;
    
    
    HashSet<Integer> visit=new HashSet<>();
    q.add(0);
    int count=0; 
    while(!q.isEmpty()){
        int size = q.size();
        
        for(int i=0;i<size;i++){
            int poll= q.poll();
            if(res[Math.abs(poll)]==-1)
                res[Math.abs(poll)]=count;
            
            if(visit.contains(poll))
                continue;
            
            visit.add(poll);    
            List<Integer> list = map.get(Math.abs(poll));
            if(list!=null){
            for(int j:list){
            if (poll > 0 && j > 0 || poll < 0 && j < 0)
                continue;   
            q.add(j);
            }
            }
            
        }
        
        
        ++count;
    }
    
    
   
    return res;
}



int max=Integer.MIN_VALUE;
int[][] dirs1 = {{1,0},{0,1}};
public int calculateMinimumHP(int[][] dungeon) {
   
    int m = dungeon.length;
    int n = dungeon[0].length;
    
   // int[][] visit = new int[m][n];
    doDFS(0,0,m,n,dungeon,0,0);
    return max;
}


public void doDFS(int x,int y,int m,int n,int[][] dungeon,int neg,int pos){
    
    if(x<0 || y<0 || x>=m || y>=n )
        return;

    
    if(x==m-1 && y==n-1){
         max = Math.max(max,neg);
    }
    
    if(dungeon[x][y]<0 && pos==0){
        neg+=dungeon[x][y];
    }else if(dungeon[x][y]<0 && pos>0){
        pos-= dungeon[x][y];
    }else{
        pos+=dungeon[x][y];
    }
    

for(int[] dir:dirs1){
    doDFS(x+dir[0],y+dir[1],m,n,dungeon,neg,pos);
}    
    
    
}


// Treasure Islands


public int TreasureIslands(char[][] map) {
	if(map[0][0]=='X')
		return 0;
	if(map.length==0 || map[0].length==0 || map[0][0]=='D')
		return -1;
	int m = map.length,n=map[0].length;
	Queue<int[]> q = new LinkedList();
	
	q.add(new int[] {0,0});
	int step=0;
	while(!q.isEmpty()) {
		int size = q.size();
		for(int i=0;i<size;i++) {
			int[] point = q.poll();
			for(int[] dir:dirs) {
				int x = point[0]+dir[0];
				int y = point[1]+dir[1];
				if(x<0 || y<0 || x>=m || y>=n || map[x][y]=='D')
					continue;
				
				if(map[x][y]=='X')
					return step;
				
				q.add(new int[] {x,y});
				map[x][y]='D';
			}
		}
		step++;
	}
	
	
	return -1;
	
}



//public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
public int cutOffTree(List<List<Integer>> forest) {
 
    if(forest.get(0).get(0)==0)
        return -1;
    
    if(forest.size()==0 || forest.get(0).size()==0)
        return 0;
    
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
    for(int i=0;i<forest.size();i++){
        for(int j=0;j<forest.get(0).size();j++){
            if(forest.get(i).get(j)>1)
                pq.add(new int[] {i,j,forest.get(i).get(j)});
        }
    }
    int[] start = {0,0};
    int sum = 0;
    
    while(!pq.isEmpty()){
        
        int[] point = pq.poll();
        
        System.out.println(point[2]);
        int step = getStepCount(start,point,forest);
        System.out.println(step);
        if(step<0)
            return -1;
        start[0]=point[0];
        start[1]=point[1];
        //start[2]=point[2];
        sum+=step;
    }
    
    
    return sum;
}


public int getStepCount(int[] start,int[] target,List<List<Integer>> forest){
    int m = forest.size(),n=forest.get(0).size();
     boolean[][] visited = new boolean[m+1][n+1]; 
     visited[start[0]][start[1]] = true;
    Queue<int[]> q = new LinkedList();
    q.add(start);
    
    int walk = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0;i<size;i++){
            int[] point = q.poll();
            if(point[0]==target[0] && point[1]==target[1])
                    return walk;
            for(int[] dir : dirs){
                int x = point[0]+dir[0];
                int y = point[1]+dir[1];
                //int val = point[2];
                
                if(x<0 || y<0 || x>=m || y>=n || forest.get(x).get(y)==0
                  || visited[x][y])
				    continue;
                
                q.add(new int[] {x,y});
                //forest.get(x).set(y,0);
                visited[x][y]=true;
            }
        }
        walk++;
    }
    return -1;
}




public List<String> invalidTransactions(String[] transactions) {
    
    HashSet<String> res = new HashSet<>();
    HashMap<String,String[]> map = new HashMap<>();
    for(String s : transactions){
        String[] curr = s.split(",");
        if(Integer.valueOf(curr[2])>1000)
        	res.add(s);
        else {
        	if(map.containsKey(curr[0])) {
        		if(map.get(curr[0])[3]!=curr[3] && 
        				Math.abs(Integer.valueOf(curr[1])- Integer.valueOf(map.get(curr[0])[1])) <60) {
        			res.add(s);
        			String s1 = "";
        			for(String k : map.get(curr[0]))
        				s1+=k+",";
        			
        			res.add(s1.substring(0, s1.length()-1));
        			
        		}
        		
        	}
        	
        	
        	
        }
        map.put(curr[0], curr);
    }
 
    return new ArrayList<>(res);
}


public int minimumCost(int N, int[][] connections) {
    
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer,List<int[]>> map = new HashMap<>();
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
    
    for(int[] con : connections){
       int node = con[0], child= con[1],cost=con[2];	
       map.computeIfAbsent(node, (k) -> new ArrayList<int[]>());
       map.get(node).add(new int[] {child,cost});
       map.get(child).add(new int[] {node,cost});
       
    }
    pq.add(new int[] {1,1,0});
    int cost=0;
    while(!pq.isEmpty()) {
    	int[] poll = pq.poll();
    	
    	List<int[]> childs = map.get(poll[0]);
    	
    	for(int i=0;i<childs.size();i++) {
    		if(!set.contains(childs.get(i)[1])) {
    			cost+=childs.get(i)[2];
    			pq.addAll(map.get(childs.get(i)));
    			set.add(childs.get(i)[1]);
    			
    		}
    	}
    	
    	
    }
    
    return set.size()==N ? cost : -1;
    
}

}
