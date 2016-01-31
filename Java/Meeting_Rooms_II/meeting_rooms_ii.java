//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

//For example,
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// Use Greedy Algorithm O(nlgn)
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null) return 0;
        if(intervals.length<=1) return intervals.length;
 		Arrays.sort(intervals,new Comparator<Interval>(){
	 		@Override
	 		public int compare(Interval a,Interval b){
		 		return a.start-b.start;
	 		}
 		});
 		return helper(Arrays.asList(intervals));
    }

    public int helper(List<Interval> list){
	    if(list.size()==0) return 0;
	    List<Interval> temp = new ArrayList<>();
	    Interval pre = list.get(0);
	    for(int i=1;i<list.size();i++){
		    Interval post = list.get(i);
		    if(post.start>=pre.end) pre = post;
		    else temp.add(post);
	    }
	    return 1+helper(temp);
    }
}


// Use PriorityQueue O(nlgn)
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null) return 0;
        if(intervals.length<=1) return intervals.length;
 		Arrays.sort(intervals,new Comparator<Interval>(){
	 		@Override
	 		public int compare(Interval a,Interval b){
		 		return a.start-b.start;
	 		}
 		});
 		PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length,new Comparator<Interval>(){
	 		@Override
	 		public int compare(Interval a,Interval b){
		 		return a.end-b.end;
	 		}
 		});
 		pq.offer(intervals[0]);
 		for(int i=1;i<intervals.length;i++){
	 		Interval a = pq.poll();
	 		if(intervals[i].start>=a.end) a.end = intervals[i].end;
	 		else pq.offer(intervals[i]);
	 		pq.offer(a);
 		}
 		return pq.size();
    }
}