package LeetCode.hundred_to_two;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EightySeven {

    /**
     * Time Limit Exceed.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 11) {
            return ans;
        }

        for (int i = 0; i + 10 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (s.indexOf(temp, i + 1) > -1) {
                if (!ans.contains(temp)) {
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    /**
     * Approach from LeetCode.
     * Use HashSet & bits manipulation.
     */
    public static List<String> findRepeatedDnaSequencesTwo(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 11) {
            return ans;
        }

        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        Set<Integer> code = new HashSet<>();
        Set<Integer> doubleCode = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            int bit = 0;
            for (int j = i; j < i + 10; j++) {
                bit = bit << 2;
                bit = bit | map[s.charAt(j) - 'A'];
            }

            if (!code.add(bit) && doubleCode.add(bit)) {
                ans.add(s.substring(i, i + 10));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequencesTwo("AAAAAAAAAAAAAAAAAAAAACCCCTT"));
    }
}
