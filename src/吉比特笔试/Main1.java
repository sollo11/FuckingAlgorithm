package 吉比特笔试;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2020/4/28 20:56
 * @Description:
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
        int p_s1 = s1.length()-1, p_s2 = s2.length()-1;
        int res = 0;
        while (p_s1>=0&&p_s2>=0){
            if (s1.charAt(p_s1)==s2.charAt(p_s2)){
                p_s1--;
                p_s2--;
                if (p_s2==-1){
                    res=p_s1+2;break;
                }
            }
            else {
                p_s1--;
            }
        }
        System.out.println(res);
    }
}
