package z节笔试;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @description：
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/12 18:47
 * @level：
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while ((t--)!=0) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int len=in.nextInt();
            int[] a =new int[len];
            int[] b=new int[len];
            for(int i=0;i<len;i++)
                a[i]=in.nextInt();
            List<Integer> list=new ArrayList<>();
            HashSet<Integer> set=new HashSet<>();
            boolean m=true;
            int res=0;
            for(int i=0;i<len;i++) {
                b[i] = in.nextInt();
                res^=(a[i]-b[i]);
            }
                System.out.println("YES");
            System.out.println("NO");
        }
    }
}
