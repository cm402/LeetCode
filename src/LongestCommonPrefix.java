import java.util.*;
public class LongestCommonPrefix {

    // second attempt: Sorting list and comparing first/last element
    // time complexity: O(n log(n) + m)
    // space complexity: O(1)
    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int charIndex = 0;
        while(charIndex < first.length() && charIndex < last.length()){
            if(first.charAt(charIndex) != last.charAt(charIndex))
                break;
            charIndex++;
        }
        return first.substring(0, charIndex);
    }

    // first attempt: Comparing each value against shortest String
    // time complexity: O(n m)
    // space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        // find shortest input String in list
        // loop over the characters in the shortest input
        // for each character, iterate through each of the input strings checking that the characters are the same
        // if character is not the same, break loop
        // otherwise, increment character index
        Arrays.sort(strs, Comparator.comparingInt(x -> x.length()));
        String shortestString = strs[0];
        int charIndex = 0;
        ShortestStringLoop: while(charIndex < shortestString.length()){
            for (int strsIndex = 0; strsIndex < strs.length; strsIndex++)
                if (shortestString.charAt(charIndex) != strs[strsIndex].charAt(charIndex))
                    break ShortestStringLoop;
            charIndex++;
        }
        return charIndex > 0 ? shortestString.substring(0, charIndex) : "";
    }
}