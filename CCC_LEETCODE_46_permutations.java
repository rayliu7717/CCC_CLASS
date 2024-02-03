class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0,res);
        return res;
    }

    // nums[0..i-1] positions are confirmed
    // nums[i...] all char can swap to the i position
    // until i to end position, str current permutation is one result.
    private void dfs( int[] nums,int i, List<List<Integer>> res){
        if(i == nums.length) res.add(Arrays.stream(nums).boxed().toList());
        else{
            for(int j = i;j<nums.length;++j){ // j,  from i to end all value can come to i position.
                swap(nums,i, j);
                dfs(nums,i+1, res);
                swap(nums,i, j); 
            }        
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j] = tmp;
    }
}