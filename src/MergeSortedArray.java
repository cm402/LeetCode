class MergeSortedArray {
    // Iterative approach using pointers to keep track of indexes.
    // time complexity: O(n)
    // space complexity: O(n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        int currentIndex = m + n - 1;
        while (nums1Index >= 0 && nums2Index >= 0)
            if (nums2[nums2Index] >= nums1[nums1Index]) {
                nums1[currentIndex--] = nums2[nums2Index--];
            } else {
                nums1[currentIndex--] = nums1[nums1Index];
                nums1[nums1Index--] = 0;
            }
        while (nums2Index >= 0)
            nums1[nums2Index] = nums2[nums2Index--];
    }
    /*
     * // Using Arrays.sort() method
     * // time complexity: O(n log(n)) (due to Arrays.sort() quicksort
     * implementation)
     * // space complexity: O(n)
     * public void merge(int[] nums1, int m, int[] nums2, int n) {
     * // Adding all the elements in nums2 to nums1
     * for(int i = 0; i < n; i++){
     * nums1[m+i] = nums2[i];
     * }
     * // Sorting nums1
     * Arrays.sort(nums1);
     * }
     */
}