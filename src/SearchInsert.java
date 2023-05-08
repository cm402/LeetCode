public class SearchInsert {
    /*
     * Using binary search algorithm.
     * time complexity: O(log(n))
     * space complexity: O(1)
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        do {
            int middle = (low + high) / 2;
            if(nums[middle] == target)
                return middle;
            if(target < nums[middle])
                high = middle - 1;
            else 
                low = middle + 1;
        } while (low <= high);
        return low;
    }
}
