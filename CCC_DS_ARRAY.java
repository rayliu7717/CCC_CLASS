public class CCC_DS_ARRAY {
    /*
    - An array is a collection of items stored at contiguous memory locations.
    Advantages:
      - Efficient access to elements  O(1) to access element
      - Memory efficiency :  memory can be allocated for the entire array in one block, reducing memory fragmentation.
      - Easy to implement
    Disadvantages:
      - Fixed size :  increasing the array size needs to re-allocate memory and copy the entire data
      - Insertion and deletion issues:  need to move the elements
      - Wasted space: If an array is not fully populated. like sparse matrix or sparse graph

     */
    public static void main(String[] args) {
        // both are valid declarations
        int intArray[];
        int[] intArray1;

        // Declaring array literal
        int[] intArray2 = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        int[] intArray3 = { 1,2,3,4,5,6,7,8,9,10 };
        // accessing the elements of the specified array
        for (int i = 0; i < intArray3.length; i++)
            System.out.println("Element at index " + i
                    + " : " + intArray3[i]);

        //a 2D array or matrix
        int[][] _2DArray = new int[10][20];  // fixed size

        // dynamic array
        int n = 2, m = 3;  // or read from console
        int [][] dynamic2dArray = new int[n][m];
        System.out.println("Size of  dynamic2dArray " + dynamic2dArray.length);
        System.out.println("Size of  dynamic2dArray[0] " + dynamic2dArray[0].length);


        // declaring and initializing 2D array
        int arr[][] = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };
    }

    /* sample
    Leetcode 26. Remove Duplicates from Sorted Array
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    * */
    static public int removeDuplicates(int[] nums) {
        int k = 1;
        for(int i=1;i< nums.length; ++i){
            if(nums[i-1] == nums[i]) continue;
            nums[k] = nums[i];
            k++;
        }
        return k;
    }

    /* homework
    Leetcode 674. Longest Continuous Increasing Subsequence
    https://leetcode.com/problems/longest-continuous-increasing-subsequence/
    LeetCode 167  two sum
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    LeetCode 15   three sum
    https://leetcode.com/problems/3sum/
     */
}
