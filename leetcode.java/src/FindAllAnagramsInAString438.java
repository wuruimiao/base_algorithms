import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
* */
public class FindAllAnagramsInAString438 {
    private List<Integer> findAnagramsSliceWindow(String t, String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        Character a;
        for (int i = 0; i < t.length(); i++) {
            a =t.charAt(i);
            need.put(a, need.getOrDefault(a, 0) + 1);
        }
        int left =0, right =0, valid=0;
        while (right < s.length()) {
            a = s.charAt(right);
            right++;
            if (need.containsKey(a)) {
                window.put(a, window.getOrDefault(a, 0) + 1);
                if (window.get(a).equals(need.get(a))) valid++;
            }
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                a = s.charAt(left);
                left++;
                if (need.containsKey(a)) {
                    if (window.get(a).equals(need.get(a))) valid--;
                    window.put(a, window.get(a) - 1);
                }
            }
        }
        return result;
    }

    public List<Integer> findAnagrams(String s, String p) {
        return findAnagramsSliceWindow(p, s);
    }
}
