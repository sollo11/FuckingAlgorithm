package z节笔试;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description：
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/12 18:48
 * @level：
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++)
            a[i]=in.nextInt();
        int res=0;
        for (int i=n-2;i>=0;i--){
           if (a[i+1]>=a[i])
               continue;
           int num=(a[i]-1)/a[i+1];
           res+=num;
           a[i]/=(num+1);
        }
        System.out.println(res);
    }
}
