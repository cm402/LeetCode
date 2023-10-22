import java.util.*;
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num: nums){
            if(seen.contains(num))
                seen.remove(num);
            else
                seen.add(num);
        }
        return seen.iterator().next();
    }
}
