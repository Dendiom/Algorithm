package LeetCode.one_to_fifty;

import java.util.*;

public class FortyNine {

    /**
     * Approach 1:
     *  sort string first, then use str.equal.
     *  Time Limit Exceeded.!!! Every time needs to sort two string.
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs.length == 0) {
            return ans;
        }

        List<String> group = new ArrayList<>();
        group.add(strs[0]);
        ans.add(group);

        for (int i = 1; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < ans.size(); j++) {         // cause time cost
                if (isAnagram(strs[i], ans.get(j).get(0))) {
                    ans.get(j).add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                ans.add(newGroup);
            }
        }

        return ans;
    }

    private boolean isAnagram(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }

    /**
     * Approach 2：
     *  use hashMap<String, List> to store info.
     */
    private List<List<String>> groupAnagramsTwo(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String newStr = String.valueOf(temp);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                map.put(newStr, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }
}
