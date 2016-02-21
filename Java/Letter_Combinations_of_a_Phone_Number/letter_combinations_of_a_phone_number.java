public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if(digits==null||digits.length()==0) return res;
        String[] dic = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res.offer("");
        for(int i=0;i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
	        int size = res.size();
	        while(size-->0){
		        String s = res.poll();
		     	for(char c:dic[x].toCharArray()){
			     	res.offer(s+c);
		     	}		        
	        }
        }
        return res;
    }
}