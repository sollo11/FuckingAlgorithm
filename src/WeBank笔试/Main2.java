package WeBank笔试;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/5/11 18:52
 * @Description:
 * @Url:
 * @限制:
 * @Level:
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while ((t--)!=0){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int x=scanner.nextInt();
            if (a == b && b == x) {
                System.out.println(0);continue;
            }
            if (a==x||b==x){
                int cnt=(a==x?Math.abs(b-x):Math.abs(a-x));
                System.out.println(cnt);continue;
            }
            else if (a<x&&b<x||a>x&&b>x){
                int max=Math.max(a,b);
                int min=Math.min(a,b);
                if (a>x&&b>x) {
                    System.out.println(min - x + (max - min + x) - x);
                    continue;
                }else if (a<x&&b<x){
                    System.out.println(x-max+(x-(min+x-max)));
                    continue;
                }
            }
            else {
                System.out.println(Math.abs(x-a)+Math.abs(x-b));
            }
        }
    }
}
