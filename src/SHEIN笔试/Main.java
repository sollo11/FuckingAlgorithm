package SHEIN笔试;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/9/1 20:35
 * @Description:
 * @Url:
 * @限制:
 * @Level:
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 < len2) {
            System.out.println(0);
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[] money = new int[256];
        for (char item:
             ch2) {
            money[item]++;
        }
        int left = 0;
        int right = 0;
        int m = ch2.length; //str1需要匹配的总字符数(还的钱的张数)
        int ans = Integer.MAX_VALUE;
        while (right != ch1.length) {
            money[ch1[right]]--;
            if (money[ch1[right]] >= 0) m--;
            if (m == 0) { //如果都还了
                while (money[ch1[left]] < 0) {
                    money[ch1[left++]]++;
                }
                ans = Math.min(ans, right - left + 1);
                m++;
                money[ch1[left++]]++;
            }
            right++;
        }
        if (ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}
