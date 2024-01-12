class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                for(int j = 0; j < curr.length(); j++){
                    char[] arr = curr.toCharArray();
                    for(char x = 'a'; x <= 'z'; x++){
                        arr[j] = x;
                        String temp = new String(arr);
                        if(set.contains(temp)){
                            if(temp.equals(endWord)) return level + 1;
                            queue.offer(temp);
                            set.remove(temp);
                        }
                    }
                }
            }

            level++;
        }
        return 0;
    }
}