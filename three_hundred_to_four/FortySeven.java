package LeetCode.three_hundred_to_four;

import java.util.*;

public class FortySeven {

    /**
     * My Approach:
     * Use a hashMap to count element's frequency, then sort it.
     */
    private static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            if (count.containsKey(num)) {
                int now = count.get(num);
                count.put(num, ++now);
            } else {
                count.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> temp = new ArrayList<>();
        temp.addAll(count.entrySet());
        temp.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < k; i++) {
            ans.add(temp.get(i).getKey());
        }

        return ans;
    }

    /**
     * New Approach:
     * Bucket sort. O(n), use extra space to reduce time.
     */
    private static List<Integer> topKFrequentTwo(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int key: count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int size = 0;
        for (int i = bucket.length - 1; i >=0; i--) {
            if (bucket[i] != null) {
                for(int key: bucket[i]) {
                    if (size < k) {
                        ans.add(key);
                        size++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 4, 6, 8, 4, 1}, 2));
        System.out.println(topKFrequent(new int[]{1, 1, 1, 8, 4, 1}, 2));
        System.out.println(topKFrequentTwo(new int[]{1}, 1));
    }
}
