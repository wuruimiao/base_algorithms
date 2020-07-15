package DP;


/*
* 5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
* */
public class LongestPalindromicSubstring5 {
    // 检查s[left,right]是否是回文串
    private boolean check(char[] chars, int left, int right) {
//        System.out.println("check " + left + " " + right);
        if (left == right) return true;
        boolean flag = chars[left] == chars[right];
        if (left + 1 == right) return flag;
        return flag && check(chars, left + 1, right - 1);
    }

    private String longestPalindromeForce(String s) {
        int maxStart = 0, maxEnd = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                // 过滤掉一些情况，能让代码通过
                if (j - i < maxEnd - maxStart) break;
                if (check(chars, i, j)) {
                    maxStart = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private String longestPalindromeDP(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
        }
        int maxStart = 0, maxEnd = 0;
        char[] chars = s.toCharArray();
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j > i; j--) {
                dp[i][j] = chars[i] == chars[j];
                if (i + 1 < j - 1) {
                    dp[i][j] &= dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i   > maxEnd - maxStart) {
                    maxEnd = j;
                    maxStart = i;
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
//        return longestPalindromeForce(s);
        return longestPalindromeDP(s);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 t;
        t = new LongestPalindromicSubstring5();
        System.out.println(t.longestPalindrome("babad") + "==bab");
        t = new LongestPalindromicSubstring5();
        System.out.println(t.longestPalindrome("cbbd") + "==bb");
        t = new LongestPalindromicSubstring5();
        System.out.println(t.longestPalindrome("a") + "==a");
        t = new LongestPalindromicSubstring5();
        System.out.println(t.longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy") + "==fklkf");
    }
}

