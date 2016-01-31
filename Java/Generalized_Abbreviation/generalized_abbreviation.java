//Write a function to generate the generalized abbreviations of a word.

//Example:
//Given word = "word", return the following list (order does not matter):
//["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]



//Backtrack
//Ex: input: {1,2,3}
//    output: 3,2c,1b1,1bc,a2,a1c,ab1,abc
public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
}

//Another
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
        return res;
    }
    
    public void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();  
        if(i == c.length) {
            if(num != 0) sb.append(num);
            res.add(sb.toString());
        } else {
            DFS(res, sb, c, i + 1, num + 1);               // abbr c[i]
    
            if(num != 0) sb.append(num);                   // not abbr c[i]
            DFS(res, sb.append(c[i]), c, i + 1, 0);        
        }
        sb.setLength(len); 
    }
}
