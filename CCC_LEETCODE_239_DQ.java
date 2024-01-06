class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> q = new ArrayDeque<>();
		int [] res = new int[nums.length - k + 1];
        for(int i = 0;i<nums.length;++i){
			while(q.size() > 0 && nums[q.peekLast()] <= nums[i])
				q.removeLast();
			q.addLast(i);
			while(q.size() > 0 && q.peekFirst() <= i-k)
				q.removeFirst();
			if(i>= k -1)
				res [i + 1 -k] = nums[q.peekFirst()];
        }
        return res;
    }
}
// 7 -1 -3 5
// 1. maintain a mono-decreasing queue
// 2. check if the queue head is out dated
// 3. the max of sliding window is the queue head
// heap: O(NlogK)