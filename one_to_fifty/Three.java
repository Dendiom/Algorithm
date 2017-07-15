package TestOne.one_to_fifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Three {


    public int maxLen(String s) {
        int len = s.length();
        int ans = 0;
        Set<Character> now = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            now.clear();
            for (int j = i; j < len; j++) {

                if (now.contains(s.charAt(j))) {
                    ans = Math.max(ans, j - i);
                    break;
                } else {
                    if (j == len - 1) {
                        ans = Math.max(ans, len - i);
                    } else {
                        now.add(s.charAt(j));
                    }
                }
            }
        }
        return ans;
    }


    public int maxLen2(String s) {
        int len = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> container = new HashSet<Character>();
        while (i < len && j < len) {
            if (container.contains(s.charAt(j))) {
                container.remove(s.charAt(i));
                i++;
            } else {
                ans = Math.max(ans, j - i + 1);
                container.add(s.charAt(j));
                j++;
            }
        }
        return ans;

    }

    public int maxLen3(String s) {
        int len = s.length();
        int ans = 0;
        Map<Character, Integer> container = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < len; j++) {
            if (container.containsKey(s.charAt(j))) {
                i = Math.max(i, container.get(s.charAt(j)));
            }
            container.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.maxLen3("hjhksh"));

    }
}
