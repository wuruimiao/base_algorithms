import java.util.HashMap;
import java.util.Map;

/*
* 76. 最小覆盖子串
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。
* */
public class MinimumWindowSubstring76 {
    private String minWindowForce(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int num, minLen = Integer.MAX_VALUE;
        String str = "";
        for (int i = 0; i < s.length(); i++) {

            num = t.length();
            for (int k = 0; k < t.length(); k++) {
                map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
            }

            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) > 0) {
                    num--;
                    map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                }
                if (num == 0) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        str = s.substring(i, j + 1);
                    }
                    ;
                    break;
                }
            }
        }
        return str;
    }

    private void initMap(String t, Map<Character, Integer> map, boolean count) {
        for (int k = 0; k < t.length(); k++) {
            if (count) {
                map.put(t.charAt(k), map.getOrDefault(t.charAt(k), 0) + 1);
            } else {
                map.put(t.charAt(k), 0);
            }
        }
    }

    private String minWindowSliceWindow1(String s, String t) {
//        System.out.println("s长度 " + s.length() + " t长度 " + t.length());
        int left = 0, right = 0;
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();

        int num = t.length(), minLen = Integer.MAX_VALUE;
        String str = "";

        initMap(t, mapT, true);
        initMap(t, mapS, false);
        while (left < s.length() && !mapT.containsKey(s.charAt(left))) {
            left++;
            right++;
        }
        Character a;
        while (left < s.length() && right < s.length()) {
//            System.out.println("000" + " " + left + " " + right + " " + minLen + " " + num);
            while (right < s.length() && num > 0) {
//                System.out.println(right + " " + num);
                a = s.charAt(right);
                if (mapT.containsKey(a)) {
                    if (mapT.get(a) > mapS.get(a)) num--;
                    mapS.put(a, mapS.get(a) + 1);
                }
                if (num == 0) break;
                right++;
            }
            if (num > 0) break;
//            System.out.println(111 + " " + left + " " + right + " " + minLen);
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                str = s.substring(left, right + 1);
            }

            a = s.charAt(left);
            mapS.put(a, mapS.get(a) - 1);
            if (mapS.get(a) < mapT.get(a)) num++;
            left++;
            if (num > 0) right++;
            while (left < s.length()) {
                if (mapT.containsKey(s.charAt(left))) break;
                left++;
            }
//            System.out.println(222 + " " + left + " " + right + " " + minLen);
        }
        return str;
    }

    private String minWindowSliceWindow(String s, String t) {
        System.out.println(s + " " + t);

        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++)
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);

        Character a;
        // valid对标t的长度，也可以是t不重复的长度
        int valid = 0, maxLen = Integer.MAX_VALUE;
        int start = 0, left = 0, right = 0;

        while (right < s.length()) {
            a = s.charAt(right);
            right++;
            window.put(a, window.getOrDefault(a, 0) + 1);
            if (need.containsKey(a) && window.get(a) <= need.get(a)) valid++;
            while (valid == t.length()) {
                if (right-left < maxLen) {
                    start = left;
                    maxLen = right - left;
                }

                a = s.charAt(left);
                left++;
                window.put(a, window.get(a) - 1);
                if (need.containsKey(a) && window.get(a) < (need.get(a)))
                    valid--;
            }
        }
        return maxLen == Integer.MAX_VALUE ? "" : s.substring(start, start + maxLen);
    }

    public String minWindow(String s, String t) {
        return minWindowSliceWindow(s, t);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring76 t = new MinimumWindowSubstring76();
        System.out.println(t.minWindow("ADOBECODEBANC", "ABC") + " == BANC");
        System.out.println(t.minWindow("aa", "aa") + " == aa");
        System.out.println(t.minWindow("cabwefgewcwaefgcf", "cae") + " == cwae");
        System.out.println(t.minWindow("a", "b") + " == ");
    }
}
