class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T==null && T.length==0) return T;
        int n = T.length;
        Stack<Integer> q = new Stack<>();
        int[] res = new int[n];
        for (int i=0;i<n;i++) {
            while (!q.isEmpty() && T[i]>T[q.peek()]) {

                int pre = q.pop();
                res[pre] = i - pre;
            }
            q.push(i);
        }
        return res;
       
    }
}