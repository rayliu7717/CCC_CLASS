import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CCC_DS_LINKEDLIST {
    /*
    A linked list is a linear data structure, in which the elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers
    Advantages :
      - Dynamic size:  compared with array as fixed size.  Choose it when we need to work with a collection of items whose size can change dynamically.
      - Efficient Insertion and Deletion:  O(1)
      - Memory Efficiency: For sparse matrix, graph...
    Disadvantages:
      - Slow Access Time: need to traverse the linked list to find the element. O(n)
      - Extra memory required: for point to next node
     */

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    class SinglyLinkedList {
        Node head;

        SinglyLinkedList() {
            head = null;
        }

        void add_node(int data) {   // add new node as head.
            Node new_node = new Node(data);
            new_node.next = head;
            head = new_node;
        }
    }

    // we can use Java util ArrayList, Vector, or LinkList, they both implement ListInterface.
    public static void main(String[] args) {
        List al = new ArrayList();
        al.add("a");
        al.add("b");
        for (Iterator i = al.iterator(); i.hasNext(); ) {
            String str = (String) i.next();
            System.out.println(str);
        }

        LinkedList ll = new LinkedList();
        // add（）to add to end
        ll.add("a");
        ll.addFirst("b"); // getFirst and getLast...
    }

    /*
    Sample  Leetcode 83 Remove Duplicates from Sorted List
    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     */
     public class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
     static   public ListNode deleteDuplicates(ListNode head) {
         ListNode current = head;
         while(current!=null && current.next!=null){
             if(current.val == current.next.val) {
                 current.next = current.next.next;
                 continue;
             }
             current = current.next;
         }
         return head;
     }

     /* homework
     https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     Leetcode 19 Remove Nth Node From End of List
      */
}