 
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
                (a, b)->{
                    if(a.getKey()!=b.getKey())
                        return b.getKey().compareTo(a.getKey());
                    else
                        return a.getValue().compareTo(b.getValue());
                }
        );
        int [] res = new int[nums.length - k + 1];
        for(int i = 0;i<nums.length;++i){
            Map.Entry<Integer,Integer> entry = Map.entry(nums[i], i);
            q.offer(entry);
            if(i + 1 >= k ){
                while(!q.isEmpty()){
                    Map.Entry<Integer, Integer> e = q.peek();
                    if(e.getValue() >= i -k + 1){
                        res [i - k+1] = e.getKey();
                        break;
                    }
                    else
                        q.poll();
                }
            }
        }
        return res;
    }
}
// naive :O(NK)
// heap: O(NlogK)