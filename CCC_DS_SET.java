import java.util.*;

public class CCC_DS_SET {
    /*
    Set data structure is defined as a data structure that stores a collection of distinct elements.
    TreeSet :  Sorted Set, it uses binary search tree ( balanced BSTs ) it supports O(log n) lookups
    HashSet :  Unordered Set, it uses hash table,  it supports O(1) lookups
    Java has not multiset(like c++), the duplicated elements are removed in the set container.
     */
    public static void main(String[] args) {
        // Creating an empty Set
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();

        // Use add() method to add elements into the Set
        for(int i = 5;i>0; i--){
            hashSet.add(i);
            treeSet.add(i + 3);
        }
        // Displaying the Set
        System.out.println("hashSet: " + hashSet);
        System.out.println("treeSet: " + treeSet);
        // Creating an iterator
        Iterator value = hashSet.iterator();
        System.out.println("The hash iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
        value = treeSet.iterator();
        System.out.println("The treeset iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());
        }
        System.out.println(hashSet.contains(5));
        System.out.println(hashSet.contains(6));
        hashSet.retainAll(treeSet);  // intersection
        System.out.println(hashSet);
        hashSet.addAll(treeSet);  // union
        System.out.println(hashSet);

        TreeSet setPairs = new TreeSet<Pair>();
        setPairs.add( new Pair(1, 10.0));
        setPairs.add( new Pair(2, 9.0));
        setPairs.add( new Pair(3, 8.0));
        System.out.println(setPairs);

        TreeSet<Pair> setPairs1 = new TreeSet<>((o1, o2) -> {
            if(o1.distance < o2.distance)
                return 1;
            if(o1.distance > o2.distance)
                return -1;
            return 0;
        });

        setPairs1.add( new Pair(1, 10.0));
        setPairs1.add( new Pair(2, 9.0));
        setPairs1.add( new Pair(3, 8.0));
        System.out.println(setPairs1);
    }

    // Implement  Comparable interface
    static class Pair implements Comparable<Pair>{
        int nodeId;
        double distance;
        public Pair(int id, double distance){
            this.nodeId = id;
            this.distance = distance;
        }
        public String toString()
        {
            return "(" + nodeId + "," + distance + ")";
        }
        @Override
        public int compareTo(Pair pair) {
            if(this.distance < pair.distance)
                return -1;
            if(this.distance > pair.distance)
                return 1;
            return 0;
        }
    }

    static public int singleNumber(int[] nums) {
        TreeSet<Integer> numbers = new TreeSet();
        for (int key : nums) {
            if (!numbers.contains(key)) {
                numbers.add(key);
            } else {
                numbers.remove(key);
            }
        }
        if(numbers.size() > 0)
            return numbers.first();
        return 0;
    }


    /*
    leetcode 136 Single number
    https://leetcode.com/problems/single-number/description/

    leetcode 414 Third Maximum Number
    https://leetcode.com/problems/third-maximum-number/description/
     */


}