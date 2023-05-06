import java.util.*;
public class RemoveDuplicates {

    // Using slow/fast pointers.
    // time complexity: O(n)
    // space complexity: O(1)
    public int removeDuplicates2(int[] nums) {
        // use a slow pointer that keeps track of last unique element,
        // and a fast pointer which keeps incrementing through the list.
        int slowPointer = 0;
        int fastPointer = 1;
        while (fastPointer < nums.length) {
            if (nums[slowPointer] == nums[fastPointer]) {
                fastPointer++;
            } else {
                nums[slowPointer + 1] = nums[fastPointer++];
                slowPointer++;
            }
        }
        return slowPointer + 1;
    }

    // Using a sorted set to remove duplicates
    // time complexity: O(n)
    // space complexity: O(n)
    public int removeDuplicates(int[] nums) {
        // populate an ordered Set with nums (this will remove duplicates)
        // populate nums with sets values
        Set<Integer> numsSet = new TreeSet<>();
        for(int num: nums){
            numsSet.add(num);
        }
        List<Integer> numsList = new ArrayList<>(numsSet);
        for(int x = 0; x < numsList.size(); x++){
            nums[x] = numsList.get(x);
        }
        return numsList.size();
    }
}
