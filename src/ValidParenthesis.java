import java.util.*;
public class ValidParenthesis {

    // Stack method
    // time complexity: O(n)
    // space complexity: O(n)
    public boolean isValid(String s) {
    Map<Character, Character> openToClose = Map.of('(', ')', '[', ']', '{', '}');
    Stack<Character> seen = new Stack<>();
    for(int characterIndex = 0; characterIndex < s.length(); characterIndex++){
        char current = s.charAt(characterIndex);
        if(openToClose.keySet().contains(current)){
            seen.push(current);
        } else if(!seen.isEmpty() && openToClose.get(seen.peek()) == current){
            seen.pop();
        } else {
            return false;
        }
    }
    return seen.isEmpty() ? true : false;
    }
}
