import java.util.*;

class MergeSortedArray {

    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    // Iterative approach
    // time complexity: O(n)
    // space complexity: O(n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int currentIndex = m + n - 1;
        // int[] nums1 = {1,2,6,0,0,0};
        // int[] nums2 = {2,5,3};
        List<Integer> sortedList = new ArrayList<>();
        while (nums1Index >= 0 && nums2Index >= 0) {
            if (nums2[nums2Index] >= nums1[nums1Index]) {
                nums1[currentIndex--] = nums2[nums2Index--];
            } else {
                nums1[currentIndex--] = nums1[nums1Index];
                nums1[nums1Index--] = 0;
            }
        }
        while(nums2Index >= 0){
            nums1[nums2Index] = nums1[nums2Index--];
        }
    }
    
    /* 
    // Using Arrays.sort() method
    // time complexity: O(n log(n)) (due to Arrays.sort() quicksort implementation)
    // space complexity: O(n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Adding all the elements in nums2 to nums1
        for(int i = 0; i < n; i++){
            nums1[m+i] = nums2[i];
        }
        // Sorting nums1
        Arrays.sort(nums1);
    }
    */
}
