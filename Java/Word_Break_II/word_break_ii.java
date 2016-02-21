//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

//Return all such possible sentences.

//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].

//A solution is ["cats and dog", "cat sand dog"].


//Works, but TLE in edge case
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String>[] map = new List[s.length()+1];
        for(int i=0;i<=s.length();i++){
            map[i] = new ArrayList<>();
        }

        map[0].add("");
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(map[j].size()!=0&&dict.contains(s.substring(j,i))){
                    if(j==0){
                        map[i].add(map[j].get(0)+s.substring(j,i));
                    }else{
                        for(String str:map[j]){
                            map[i].add(str+" "+s.substring(j,i));
                        }
                    }
                }
            }
        }
        return map[s.length()];
    }
}