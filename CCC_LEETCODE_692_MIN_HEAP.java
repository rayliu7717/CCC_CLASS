import java.util.*; 
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s: words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>(
                (a, b)-> {
                    if(a.getValue()==b.getValue())
                        return b.getKey().compareTo(a.getKey());
                    else
                        return a.getValue().compareTo(b.getValue());
                }
        );

        for(Map.Entry<String, Integer> e: map.entrySet()){
            q.offer(e);
            if(q.size()>k) q.poll();
        }

        List<String> res = new ArrayList<String>(k);
        while(!q.isEmpty())
            res.add(0, q.poll().getKey());
        return res;
    }
}