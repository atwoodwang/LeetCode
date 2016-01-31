//For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

//Format
//The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

//Example 1:

//Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

//        0
//        |
//        1
//       / \
//      2   3
//return [1]

//Example 2:

//Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

//     0  1  2
//      \ | /
//        3
//        |
//        4
//        |
//        5
//return [3, 4]


//O(N) TIME O(N) SPACE
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new LinkedList<>();
        if(edges.length==0)  return list;
        Set<Integer>[] graph = new Set[n];
		//O(N) TIME
        for(int i=0;i<graph.length;i++) graph[i] = new HashSet<Integer>();
		//O(N) TIME
        for(int[] edge:edges){
	        graph[edge[0]].add(edge[1]);
	        graph[edge[1]].add(edge[0]);
        }
		//O(N) TIME
        for(int i=0;i<n;i++){
	        if(graph[i].size()==1) list.add(i);
        }
		//O(N) TIME
        while(n>2){
	        n-=list.size();
	        List<Integer> temp = new LinkedList<>();
	        for(int i:list){
		        int index = graph[i].iterator().next;
		        graph[index].remove(i);
		        if(graph[index].size()==1) temp.add(index);
	        }
	        list = temp;
        }
        return list;
    }
}