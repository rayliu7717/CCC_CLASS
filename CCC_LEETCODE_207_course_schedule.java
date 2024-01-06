class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> adj[] = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; ++i)
            adj[i] = new LinkedList();
        int[] indegree = new int[numCourses];
        for(int i = 0;i< prerequisites.length; ++i){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            adj[start].add(end);
            indegree[end] ++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<indegree.length;++i)
            if(indegree[i] == 0 ) q.add(i);
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count ++;
            for(int nei: adj[cur]){
                if(--indegree[nei] == 0) q.offer(nei);
            }
        }
        return count == numCourses;

    }
}