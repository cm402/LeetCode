import java.util.*;
public class RomanToInteger {

    // more concise solution
    // using a map to store the values, and checking if the value ahead is greater than the current
    // value to determine if we must subtract or not. This relies on the fact that we know it's a 
    // correctly formed roman numeral, which the contstraints state it will be in all cases!
    // time complexity: O(n)
    // space complexity: O(1)
    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> numeralToValue = Map.of('I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        for (int index = 0; index < s.length(); index++) {
            if (index + 1 < s.length()
                    && numeralToValue.get(s.charAt(index)) < numeralToValue.get(s.charAt(index + 1))) {
                total -= numeralToValue.get(s.charAt(index));
            } else {
                total += numeralToValue.get(s.charAt(index));
            }
        }
        return total;
    }

    // first attempt
    /*
    public int romanToInt(String s) {
        int total = 0;
        Map<Character, Integer> numeralToValue = Map.of('I', 1, 'V', 5, 'X', 10,
         'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        List<Character> numerals = List.of('I', 'V', 'X', 'L', 'C', 'D', 'M');
        for(int index = 0; index < s.length(); index++){
            char current = s.charAt(index);
            if(index == s.length() - 1){
                total += numeralToValue.get(current);
                break;
            }
            char next = s.charAt(index + 1);
            if(numerals.indexOf(current) < numerals.indexOf(next)){
                total += numeralToValue.get(next) - numeralToValue.get(current);
                index++;
            } else {
                total += numeralToValue.get(current);
            }
        }
        return total;
    }*/
}