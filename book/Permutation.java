package LeetCode.book;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba
 */
public class Permutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);   // 按字典序排序
        backtrack(result, chars, new StringBuilder(), new boolean[chars.length]);
        return result;
    }

    private void backtrack(ArrayList<String> result, char[] chars, StringBuilder temp, boolean[] used) {
        if (temp.length() == chars.length) {
            result.add(temp.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) { // 一个元素只能使用一次
                continue;
            }

            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {  // 回溯的时候不能重复
                continue;
            }

            temp.append(chars[i]);
            used[i] = true;
            backtrack(result, chars, temp, used);
            temp.deleteCharAt(temp.length() - 1);
            used[i] = false;
        }
    }
}
