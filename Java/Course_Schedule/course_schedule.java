//There are a total of n courses you have to take, labeled from 0 to n - 1.

//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

//For example:

//2, [[1,0]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

//2, [[1,0],[0,1]]
//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


// Topological sort(BFS)
// O(V+E) time O(V+E) space
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
	        if(indegree[i]==0) queue.offer(i);
        }
		int count=0;
        while(!queue.isEmpty()){
	        int i = queue.poll();// course i has no prereq which can be taken immediately.
	        count++;
	        List<Integer> list = graph[i];//get a list of courses that requires i as prereq.
	        if(list==null) continue;
	        for(int n:list){
		        indegree[n]--;//remove that edge cause i is taken.
		        if(indegree[n]==0) queue.offer(n);
	        }
        }
        return count==numCourses;
    }
}


//OOD fastest
public class Solution {
    static class Course {
        private boolean vis;
        private boolean done;
        private ArrayList<Course> pre = new ArrayList<Course>();

        void addPre(Course preCourse) {
            pre.add(preCourse);
        }

        boolean isCyclic() {
            if( done ) {
                return false;
            }
            if( vis ) {
                return true;
            }
            vis = true;

            for(Course preCourse: pre ) {
                if( preCourse.isCyclic() ) {
                    return true;
                }
            }

            vis = false;
            done = true;
            return false;
        }
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Course clist[] = new Course[numCourses];

        for(int i=0; i<numCourses; i++) {
            clist[i] = new Course();
        }

        for(int[] couple: prerequisites ) {
            Course c1 = clist[couple[0]];
            Course c2 = clist[couple[1]];
            c1.addPre(c2);
        }

        for(int i=0; i<numCourses; i++) {
            if( clist[i].isCyclic() ) {
                return false;
            }
        }

        return true;
    }
}




//DFS very slow
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];//construct the graph using adjacency list.
        boolean[] visited = new boolean[numCourses];//for each course, store whether it has been visited.
        for(int[] pre:prerequisites){
	        int course = pre[0];
	        int prereq = pre[1];
	        List<Integer> list = graph[prereq];
	        if(list==null){
		        list = new LinkedList<>();
		        graph[prereq]=list;
	        }
	        list.add(course);
        }
		
       	for(int i=0;i<numCourses;i++){
	       	if(!dfs(graph,visited,i)) return false;
       	}
       	return true;
    }

    public boolean dfs(List<Integer>[] graph,boolean[] visited,int course){
	    if(visited[course]==true) return false;
	    if(graph[course]==null) return true;
	    visited[course]=true;
	    for(int i=0;i<graph[course].size();i++){
		   	if(!dfs(graph,visited,graph[course].get(i))) return false;
	    }
	    visited[course]=false;
	    return true;
    }
}