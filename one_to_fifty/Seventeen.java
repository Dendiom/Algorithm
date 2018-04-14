package LeetCode.one_to_fifty;

import java.util.ArrayList;
import java.util.List;

public class Seventeen {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits == null || "".equals(digits)) {
            return ans;
        }

        recursive(digits, ans, new StringBuilder(""), map, 0);
        return ans;
    }

    private void recursive(String digits, List<String> ans, StringBuilder temp, String[] map, int index) {
        if (temp.length() == digits.length()) {
            ans.add(new String(temp));
        }

        if (index < digits.length()) {
            int number = digits.charAt(index) - '0';
            String letter = map[number];
            for (int j = 0; j < letter.length(); j++) {
                temp.append(letter.charAt(j));
                recursive(digits, ans, temp, map, index + 1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
