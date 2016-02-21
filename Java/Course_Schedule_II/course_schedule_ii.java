//There are a total of n courses you have to take, labeled from 0 to n - 1.

//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

//For example:

//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

//4, [[1,0],[2,0],[3,1],[3,2]]
//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

// Topological sort O(V+E) time O(V+E) space
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];//construct the graph using adjacency list.
        int[] indegree = new int[numCourses];//store nums of indegrees for each course.
        for(int[] pre:prerequisites){
	        int course = pre[0];
	        int prereq = pre[1];
	        List<Integer> list = graph[prereq];
	        if(list==null){
		        list = new LinkedList<>();
		        graph[prereq]=list;
	        }
	        list.add(course);
	        indegree[course]++;
        }
        int[] res = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
	        if(indegree[i]==0) queue.offer(i);
        }
		int count=0;
        while(!queue.isEmpty()){
	        int i = queue.poll();// course i has no prereq which can be taken immediately.
	        res[count++]=i;
	        List<Integer> list = graph[i];//get a list of courses that requires i as prereq.
	        if(list==null) continue;//means this course is not any class's prereq
	        for(int n:list){
		        indegree[n]--;//remove that edge cause i is taken.
		        if(indegree[n]==0) queue.offer(n);
	        }
        }
        return count==numCourses?res:new int[0];
    }
}