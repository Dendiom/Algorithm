package LeetCode.book;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class FIrstAppearingOnce {

    /**
     * 使用LinkedHashMap可以记住数据插入的顺序
     */
    private Map<Character, Integer> map = new LinkedHashMap<>();

    public void insert(char ch) {
        if (map.get(ch) == null) {
            map.put(ch, 1);
        } else {
            map.remove(ch);
        }
    }

    public char firstAppearingOnce() {
        Iterator<Character> it = map.keySet().iterator();
        if (it.hasNext()) {
            return it.next();
        }

        return '#';
    }
}
