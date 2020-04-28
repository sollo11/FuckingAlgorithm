package 吉比特笔试;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2020/4/28 20:56
 * @Description: 过了70%
 * @Url:
 * @限制:
 * @Level:
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        if ("".equals(s1) || "".equals(s2)) {
            System.out.println(0);
            return;
        }
        if (s1.equals(s2)) {
            System.out.println(1);
            return;
        }
        if (s1.length() < s2.length()) {
            System.out.println(0);
            return;
        }
        int p_s1 = 0, p_s2 = 0;
        boolean first = false;
        int res = 0;
        TreeMap<Integer, Boolean> map = new TreeMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (; p_s1 < s1.length(); p_s1++) {
            char ch_s1 = s1.charAt(p_s1);
            char ch_s2 = s2.charAt(p_s2);
            if (ch_s1 == ch_s2) {
                if (!first) {
                    map.put(p_s1 + 1, false);
                    list.addLast(p_s1 + 1);
                    first = true;
                }
                p_s2++;
                if (p_s2 == s2.length()) {
                    Integer last = list.getLast();
                    map.put(last, true);
                    first = false;
                    p_s2 = 0;
                }
            }
        }
        int r = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i)) {
                r = Math.max(r, i);
            }
        }
        System.out.println(r);
    }
}
