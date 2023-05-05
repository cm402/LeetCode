import java.util.*;
public class LongestCommonPrefix {
    // first attempt
    // time complexity: O(n m), where n is size of strs and m is length the shortest String in strs
    // space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        // find shortest input String in list
        // loop over the characters in the shortest input
        // for each character, iterate through each of the input strings checking that the characters are the same
        // if character is not the same, break loop
        // otherwise, increment character index
        Arrays.sort(strs);
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