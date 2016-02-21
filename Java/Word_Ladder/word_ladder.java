//Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

//Only one letter can be changed at a time
//Each intermediate word must exist in the word list
//For example,

//Given:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.

//Note:
//Return 0 if there is no such transformation sequence.
//All words have the same length.
//All words contain only lowercase alphabetic characters.


public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while(!reached.contains(endWord)){
	        Set<String> tmp = new HashSet<>();
	        for(String s:reached){
		        for(int i=0;i<s.length();i++){
		            char[] ch = s.toCharArray();
			        for(char c='a';c<='z';c++){
			            ch[i]=c;
				        String stmp = String.valueOf(ch);
				        if(wordList.contains(stmp)){
					        tmp.add(stmp);
					        wordList.remove(stmp);
				        }
			        }
		        }
	        }
	        if(tmp.size()==0) return 0;
	        distance++;
	        reached = tmp;
        }
        return distance;
    }
}