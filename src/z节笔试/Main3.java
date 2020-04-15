package z节笔试;

import java.util.Scanner;

/**
 * @description：
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/12 18:47
 * @level：
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n_value=in.nextInt();
        int m_price=in.nextInt();
        int[] value=new int[n_value];
        int[] weight=new int[m_price];
        for (int i=0;i<n_value;i++)
            value[i]=in.nextInt();
        for (int i=0;i<m_price;i++)
            weight[i]=in.nextInt();
        

    }
}
