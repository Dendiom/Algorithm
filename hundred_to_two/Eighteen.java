package TestOne.hundred_to_two;


import java.util.ArrayList;
import java.util.List;

public class Eighteen {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();     // record the pre row
        if (numRows == 0)
            return ans;
        pre.add(1);
        ans.add(pre);
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 1; j < pre.size(); j ++) {
                currentRow.add(pre.get(j - 1) + pre.get(j));
            }
            currentRow.add(1);
            pre = currentRow;
            ans.add(currentRow);
        }
        return ans;
    }
}
