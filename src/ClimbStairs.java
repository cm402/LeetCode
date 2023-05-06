import java.util.*;
public class ClimbStairs {
    /*
     * Initial thoughts.
     * n = 1, 1 way (1)
     * n = 2, 2 ways (1,1), (2)
     * n = 3, 3 ways (1,1,1), (1,2), (2,1)
     * n = 4, 5 ways (1,1,1,1), (1,2,1), (2,1,1), (1,1,2), (2,2)
     * n = 5, 8 ways (1,1,1,1,1), (1,1,1,2), (1,1,2,1), (2,1,1,1), (1,2,1,1), (2,2,1), (2,1,2), (1,2,2)
     * fibonacci sequence! so f(n) = f(n-1) + f(n-2)
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> storedResults = new HashMap<>(Map.of(0, 0, 1, 1, 2, 2));
        if(storedResults.containsKey(n))
            return storedResults.get(n);
        for(int x = 3; x <= n; x++)
            storedResults.put(x, storedResults.get(x - 1) + storedResults.get(x - 2));
        return storedResults.get(n);
    }
}
