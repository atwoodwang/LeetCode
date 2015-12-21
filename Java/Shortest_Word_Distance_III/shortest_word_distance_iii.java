//This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

//word1 and word2 may be the same and they represent two individual words in the list.

//For example,
//Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

//Given word1 = “makes”, word2 = “coding”, return 1.
//Given word1 = "makes", word2 = "makes", return 3.

//Note:
//You may assume word1 and word2 are both in the list.


public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
		int a = -1;
		int b = -1;
		int min = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
	        String s = words[i];
	        if(s.equals(word1)){
		        if(word1.equals(word2)){
					a = b;
					b = i;
		        }else{
		        	a=i;			        
		        }
	        }else if(s.equals(word2)){
		        b=i;
	        }

	        if(a!=-1&&b!=-1){
		        min = Math.min(min,Math.abs(b-a));
	        }
        }
        return min;
    }
}