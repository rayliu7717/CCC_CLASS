import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CCC_DS_QUEUE {
    /*
    A queue is a linear data structure that is open at both ends and the operations are performed in "First In First Out" (FIFO) order.
     */
    public static void main(String[] args) {
        // LinkedList implements Queue interface, LinkedList can be used as Queue.
        // use offer and poll instead of add() and remove() which throw exception if fails
        Queue<String> queue = new LinkedList<String>();
        //add element
        queue.offer("a");
        queue.offer("b");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //return first element，and remove it
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //return first only, not remove
        for(String q : queue){
            System.out.println(q);
        }

        // Deque    can add or remove element on both front and end.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
		System.out.println("First: " + deque.peekFirst() + ", Last: " + deque.peekLast());
        int first = deque.removeFirst();
        int last = deque.removeLast();
        System.out.println("First: " + first + ", Last: " + last);
    }
    /* Sample
    239. Sliding Window Maximum
    https://leetcode.com/problems/sliding-window-maximum/
    862. Shortest Subarray with Sum at Least K
    https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
     */
}