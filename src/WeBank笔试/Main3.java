package WeBank笔试;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/5/11 18:52
 * @Description: 27%
 * @Url:
 * @限制:
 * @Level:
 */
public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n, m, x;
            n = scanner.nextInt(); //n
            m = scanner.nextInt(); //m
            x = scanner.nextInt(); //x
            if (n == m) {
                System.out.println(1);
            } else {
                int tmp = m / n;
                int left = m % n;
                System.out.println("left=" + left);
                if (left == 0) {
                    System.out.println(tmp + 1);
                } else {
                    if (left <= 3) {
                        System.out.println(tmp + 1);
                        continue;
                    }
                    int tmp1 = left / 3;
                    int r = left % 3 == 0 ? tmp1 : tmp1 + 1;
                    System.out.println(r + tmp);
                }
            }
        }
    }
}
