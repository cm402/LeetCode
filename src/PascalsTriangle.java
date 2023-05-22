import java.util.*;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        // set first and last values in list to 1
        // set every other value to be the sum of the same index and
        // the index before it, in the previous row
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(1));
        if(numRows == 1)
            return triangle;
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int valueIndex = 1; valueIndex < rowIndex; valueIndex++){
                List<Integer> previousRow = triangle.get(rowIndex - 1);
                currentRow.add(previousRow.get(valueIndex) + previousRow.get(valueIndex - 1));
            }
            currentRow.add(1);
            triangle.add(currentRow);
        }
        return triangle;
    }
}
