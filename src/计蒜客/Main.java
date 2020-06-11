package 计蒜客;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/5/24 14:11
 * @Description:
 * @Url: https://www.jisuanke.com/contest/9032/521755
 * @限制:
 * @Level:
 */
public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int n = s.nextInt();
        int cnt = 0;
        int r_a = a;
        int r_b = b;
        if(b == n){
            System.out.println(1);
            return;
        }
        while(true){
            if(r_b == n && r_a == n) break;
            r_a = r_b;
            cnt++;
            if((n - r_b) < (b - a)) {
                if (n - r_b != 0) {
                    cnt += 2;
                }
                else{
                    cnt+=1;
                }
                break;
            }
            r_b = r_b + (b - a);
            cnt++;
            if((n - r_b) < (b - a)) {
                if (n - r_b != 0) {
                    cnt += 3;
                }
                else{
                    cnt+=1;
                }
                break;
            }
        }
        System.out.println(cnt);
    }
}