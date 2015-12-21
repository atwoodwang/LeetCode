//This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

//Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

//Given word1 = “coding”, word2 = “practice”, return 3.
//Given word1 = "makes", word2 = "coding", return 1.

//Note:
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


public class WordDistance {
    Map<String,List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
	    for(int i=0;i<words.length;i++){
		    String s = words[i];
		    if(map.containsKey(s)){
			    map.get(s).add(i);
		    }else{
			    List<Integer> list = new ArrayList<>();
			    list.add(i);
			    map.put(s,list);
		    }
	    }
    }

    public int shortest(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        int offset = Integer.MAX_VALUE;
        for(int i=0,j=0;i<a.size()&&j<b.size();){
	        int m = a.get(i);
	        int n = b.get(j);
	        if(m<n){
		        offset = Math.min(offset,n-m);
		        i++;
	        }else{
		        offset = Math.min(offset,m-n);
		        j++;
	        }
        }
        return offset;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");