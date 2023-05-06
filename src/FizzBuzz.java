import java.util.*;
public class FizzBuzz {
    /*
     * first attempt, just using plain conditionals.
     * storing conditions so they aren't checked multiple times.
     * time complexity: O(n)
     * space complexity: O(n)
     */
    public List<String> fizzBuzz(int n) {
        List<String> values = new ArrayList<>();
        for(int index = 1; index <= n; index++){
            boolean isFizz = index % 3 == 0;
            boolean isBuzz = index % 5 == 0;
            if(isFizz && isBuzz){
                values.add("FizzBuzz");
            } else if(isFizz){
                values.add("Fizz");
            } else if(isBuzz){
                values.add("Buzz");
            } else {
                values.add(String.valueOf(index));
            }
        }
        return values;
    }
}
