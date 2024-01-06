    public int[] topKFrequent(int []nums, int k)
    {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n: nums)
            map.put(n, map.getOrDefault(n,0) + 1);
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>( (a,b)-> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer,Integer> e: map.entrySet())
            q.offer(e);
        int res[] = new int[k];
        for(int i = 0;i<k;++k)
            res[i] = q.poll().getKey();
        return res;
    }
