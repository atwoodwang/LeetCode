//Given a collection of distinct numbers, return all possible permutations.

//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

//Iteration
public List<List<Integer>> permute(int[] num) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (num.length ==0) return ans;
    List<Integer> l0 = new ArrayList<Integer>();
    l0.add(num[0]);
    ans.add(l0);
    for (int i = 1; i< num.length; ++i){
        List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
        for (int j = 0; j<=i; ++j){            
           for (List<Integer> l : ans){
               List<Integer> new_l = new ArrayList<Integer>(l);
               new_l.add(j,num[i]);
               new_ans.add(new_l);
           }
        }
        ans = new_ans;
    }
    return ans;
}

//Recursion
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums.length == 0) return result;

    backtrack(result, nums, new ArrayList<Integer>(), 0);

    return result;
}

private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> currentList, int index) {
    if (currentList.size() == nums.length) {
        result.add(currentList);
        return;
    }

    int n = nums[index];
    for (int i = 0; i <= currentList.size(); i++) {
        List<Integer> copy = new ArrayList<Integer>(currentList);
        copy.add(i, n);
        backtrack(result, nums, copy, index + 1);
    }

}