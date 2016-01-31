public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] mask = new int[words.length];
        Arrays.sort(words,new Comparator<String>(){
	        @Override
	        public int compare(String a,String b){
		        return b.length()-a.length();
	        }
        });
        for(int i=0;i<words.length;i++){
	        for(char ch:words[i].toCharArray()){
		        mask[i]|=1<<(ch-'a');
	        }
        }
        for(int i=0;i<words.length;i++){
			if(words[i].length()*words[i].length()<=max) break;
	        for(int j=i+1;j<words.length;j++){
		        if((mask[i] & mask[j])==0){
			        max = Math.max(max,words[i].length()*words[j].length());
			        break;
		        }
	        }
        }
        return max;
    }
}