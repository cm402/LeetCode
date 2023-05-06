public class PlusOne {

    // better solution, takes advantage of the fact that if we're 
    // at the first digit, then every value must have been 9 so
    // we just need a new number with 1 at the start and the rest
    // of the values as 0.
    // time complexity: O(n)
    // space complexity: O(n)
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    // first attempt
    // time complexity: O(n)
    // space complexity: O(n)
    public int[] plusOne(int[] digits) {
        // check last digit, if not equal to 9 then increment and return
        // otherwise, set current digit to 0, iterate to previous digit.
        // special case, first digit is incremented, then need to shuffle all values along one
        // and add a 1 to the start.
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                break;
            }
            digits[i] = 0;
            if(i == 0){
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1;
                for(int j = 0; j < digits.length; j++){
                    newDigits[j + 1] = digits[j];
                }
                return newDigits;
            }
        }
        return digits;
    }
}
