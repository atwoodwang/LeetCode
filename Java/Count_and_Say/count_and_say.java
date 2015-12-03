//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...

//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

//Note: The sequence of integers will be represented as a string.


public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        int count = 0;
        char say =' ' ;
        for(int i = 1;i<n;i++){
            StringBuilder temp = new StringBuilder("");
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                if(count==0){
                    say = c;
                    count++;
                    continue;
                }else if(c!=say){
                    temp.append(count).append(say);
                    count = 0;
                    say = c;
                }
                count++;
            }
            temp.append(count).append(say);
            count = 0;
            say = ' ';
            s = temp.toString();
        }
        return s;
    }
}