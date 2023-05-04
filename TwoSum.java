import java.util.*;
class TwoSum {
    // HashMap method
    // time complexity: O(n)
    // space complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int requiredDifference = target - nums[i];
            if(numsMap.containsKey(requiredDifference)){
                return new int[] {i, numsMap.get(requiredDifference)};
            }
            numsMap.put(nums[i], i);
        }
        return new int[]{};
    }

    // Brute force method
    // time complexity: O(n^2)
    // space complexity: O(1)
    /*
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }
    */
}