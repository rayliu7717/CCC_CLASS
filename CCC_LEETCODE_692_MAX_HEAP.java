import java.util.*; 
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s: words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>( 
            (a,b)-> {
                if( b.getValue() == a.getValue())
                    return a.getKey().compareTo( b.getKey() );
                else
                    return (b.getValue() - a.getValue());
            }
        );
        for(Map.Entry<String, Integer> e: map.entrySet())
            q.offer(e);
        List<String> res = new ArrayList<String>(k);
        for(int i = 0;i<k;++i){
            res.add(q.poll().getKey());
        }
        return res;
    }
}