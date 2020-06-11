package WeBank笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/5/11 18:52
 * @Description:
 * @Url:
 * @限制:
 * @Level:
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n,m,l,r;
        n=scanner.nextLong();
        m=scanner.nextLong();
        l=scanner.nextLong();
        r=scanner.nextLong();
        long[] a=new long[Math.toIntExact(n)];
        long[] b=new long[Math.toIntExact(m)];
        for (int i=0;i<n;i++){
            a[i]=scanner.nextInt();
        }
        for (int i=0;i<m;i++){
            b[i]=scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long cnt=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (a[i]+b[j]<=r&&a[i]+b[j]>=l) {
                    cnt++;
                } else if (a[i]+b[j]>r) {
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
