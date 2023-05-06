public class FirstOccurenceInString {
    // iterate approach, using substring
    // time complexity: O(n)
    // space complexity: O(n)
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length())
            return -1;
        // iterate through characters in haystack
        // if first character matches first character in needle,
        // then attempt to do a substring (if possible) and compare
        for(int currentIndex = 0; currentIndex < haystack.length(); currentIndex++)
            if(haystack.charAt(currentIndex) == needle.charAt(0)) {
                int maxIndex = currentIndex + needle.length();
                if(maxIndex <= haystack.length()
                && needle.equals(haystack.substring(currentIndex, maxIndex))){
                    return currentIndex;
                }
            }
        return -1;
    }   
}