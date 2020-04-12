package ali笔试;

import java.util.Scanner;

/**
 * @description：
 * 设dp(i, j)为从[i, j]开始走能得到的最大和值，则可以得出以下转移方程。
 * dp(i, j) = A[i][j] + max{dp(i ± k, j ± k) | A[i ± k][j ± k] > A[i][j]}
 * 样例:
 * 1
 * 3 1
 * 1 2 5
 * 10 8 6
 * 9 1 3
 * 输出：（从左上角开始走直到不能走的最大和值）
 * 32
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/8 9:27
 * @level：
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for (int i=0;i<t;i++){
            int n=scanner.nextInt();  //n阶矩阵
            int max_step=scanner.nextInt();  //每次移动的最大距离
            int[][] value=new int[n+1][n+1];
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){
                    value[j][k]=scanner.nextInt();
                }
            }
            int[][] dp=new int[n+1][n+1]; //dp[i][j]表示从value[i,j]开始走能得到的最大和值
            System.out.println(calcMaxWay(1,1,max_step,dp,value));
        }
    }
    private static int calcMaxWay(int x,int y,int max_step,int[][] dp,int[][] value){
        if (dp[x][y]>0) //如果从value[x,y]开始走能得到的最大和值已经被算过（到了不能走为止），那么就直接返回，防止重复计算
            return dp[x][y];
        int max_sum=0; //记录最大和值
        //比当前值大才可以走
        for (int step=1;step<=max_step;step++){
            //在四个方向的每个方向上的[1,max_step]步范围内求到value的最大值，更新max_sum
            //每个方向会来一次递归其四个方向，最终将这个方向的[1,max_step]的每一步四个方向的四个方向的...的最大和值
            //也就是确定了往某一方向的最大和值，其他方向同理
            if(y-step>0 && value[x][y-step]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x,y-step,max_step,dp,value));
            if(y+step<value[1].length && value[x][y+step]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x,y+step,max_step,dp,value));
            if(x-step>0 &&value[x-step][y]>value[x][y]) max_sum=Math.max(max_sum,calcMaxWay(x-step,y,max_step,dp,value));
            if(x+step<value[1].length && value[x+step][y] > value[x][y])max_sum=Math.max(max_sum,calcMaxWay(x+step,y,max_step,dp,value));
        }
        dp[x][y]=value[x][y]+max_sum;
        return dp[x][y];
    }
}
