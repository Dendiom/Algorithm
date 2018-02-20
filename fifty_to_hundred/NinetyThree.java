package LeetCode.fifty_to_hundred;

import java.util.ArrayList;
import java.util.List;

public class NinetyThree {


    private List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {   // can be commented out.
            return ans;
        }
        //backtrack(ans, s, new ArrayList<>(), 0);
        backtrackTwo(ans, s, new StringBuilder(), 0, 0);
        return ans;
    }

    /**
     * Use List<Integer> as a temp container.
     */
    private void backtrack(List<String> ans, String s, List<Integer> temp, int start) {
        if (temp.size() == 4) {
            String ip = transfer(temp);
            if (ip.length() == s.length() + 3) {
                ans.add(ip);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {  // avoid IndexOutOfBounds
                int segment = Integer.valueOf(s.substring(start, start + i));
                if (segment == 0) {
                    temp.add(segment);
                    backtrack(ans, s, temp, start + 1);
                    temp.remove(temp.size() - 1);
                    break;
                } else if (segment >= 1 && segment <= 255) {
                    temp.add(segment);
                    backtrack(ans, s, temp, start + i);
                    temp.remove(temp.size() - 1);
                }
            }
        }

    }

    private String transfer(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int s : list) {
            builder.append(".").append(s);
        }

        return builder.substring(1);
    }

    /**
     * Use StringBuilder as temp container.
     */
    private void backtrackTwo(List<String> ans, String s, StringBuilder temp, int start, int count) {
        if (count == 4 && temp.length() == s.length() + 4) {
            ans.add(temp.substring(1));
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i <= s.length()) {  // avoid IndexOutOfBounds
                int segment = Integer.valueOf(s.substring(start, start + i));
                if (segment == 0) {
                    temp.append(".").append(segment);
                    backtrackTwo(ans, s, temp, start + 1, count + 1);
                    temp.delete(temp.lastIndexOf("."), temp.length());
                    break;
                } else if (segment >= 1 && segment <= 255) {
                    temp.append(".").append(segment);
                    backtrackTwo(ans, s, temp, start + i, count + 1);
                    temp.delete(temp.lastIndexOf("."), temp.length());
                }
            }
        }
    }
}
