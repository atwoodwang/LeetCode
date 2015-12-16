//Implement strStr().

//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


public class Solution {
    public int strStr(String haystack, String needle) {
    	int l1 = haystack.length();
    	int l2 = needle.length();
    	if(l2==0){
	    	return 0;
    	}

    	for(int i=0;i<=l1-l2;i++){
	    	if(haystack.substring(i,i+l2).equals(needle)){
		    	return i;
	    	}
    	}
    	return -1;
    }
}


//A correct but also wrong answer,just for fun LOL
//public class Solution {
//    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
//    }
//}