//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

//Example 1:
//     0          3
//     |          |
//     1 --- 2    4
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

//Example 2:
//     0           4
//     |           |
//     1 --- 2 --- 3
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

//Note:
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] result = new int[n];
        int[] size = new int[n];
        int count = n;
        
        for(int i=0;i<n;i++){
            result[i]=i;
            size[i]=1;
        }
        for(int[] edge:edges){
            int a = root(result,edge[0]);
            int b = root(result,edge[1]);
            if(a==b) continue;
            if(size[a]<size[b]){
	            result[a]=b;
	            size[b] +=size[a];
            }else{
	            result[b]=a;
	            size[a]+=size[b];
            }
            count--; 
        }
        return count;
    }


    public int root(int[] result,int n){
        while(result[n]!=n) n=result[n];
        return n;
    }
}