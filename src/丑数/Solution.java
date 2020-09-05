package 丑数;

/**
 * @description：动态规划求解:
 * 丑数的排列肯定是1,2,3,4,5,6,8,10.... 然后有一个特点是，任意一个丑数都是由小于它的某一个丑数*2，*3或者*5得到的
 * 假设有3个数组，分别是：
 * A：{1*2，2*2，3*2，4*2，5*2，6*2，8*2，10*2......}
 * B：{1*3，2*3，3*3，4*3，5*3，6*3，8*3，10*3......}
 * C：{1*5，2*5，3*5，4*5，5*5，6*5，8*5，10*5......}
 * 那么所有丑数的排列，必定就是上面ABC3个数组的合并结果然后去重得到的
 * 合并有序数组的一个比较好的方法，就是每个数组都对应一个指针，然后比较这些指针所指的数中哪个最小，
 * 就将这个数放到结果数组中，然后该指针向后挪一位。
 * 假设初始化三个数组
 * A ：{1*2......}
 * B ：{1*3......}
 * C ：{1*5......}
 * 此时ugly=[1]
 * 此时比较这些指针所指向的2，3，5数字最小为2，那么指向A的指针右移，指向2，而B的指针还是指向1，C的指针还是指向1
 * ugly=[1,2]
 * 再进行判断更新即可。
 * 假设三个数组的指针分别是i,j,k，此时均是指向第一个元素，然后比较A[i]，B[j]和C[k]，得到的最小的数A[i]，就是ugly[1]，
 * 此时ugly就变成{1,2}了，对应的ABC数组就分别变成了：
 * 状态转换方程：第i个丑数 dp[i]=min(dp[p2]*2, dp[p3]*3, dp[p5]*5)
 *
 * @url： https://leetcode-cn.com/problems/chou-shu-lcof/
 * @限制：
 * 1 是丑数。
 * n 不超过1690。
 * @author： Jack
 * @createTime： 2020/3/5 9:02
 * @level： 中等
 */
public class Solution {
    public int nthUglyNumber(int n) {
        //dp[i]表示第i+1个丑数（i从0开始）
        int[] dp=new int[n];
        dp[0]=1;
        int p2=0,p3=0,p5=0; //指向第1个数
        //因为dp[p2], dp[p3], dp[p5]是丑数。
        // 那么dp[p2]*2, dp[p3]*3, dp[p5]*5也一定为丑数，从中选取最小的值作为下一个丑数
        for(int i=1;i<n;i++){
            // 更新数组
            dp[i]=Math.min(Math.min(2*dp[p2],3*dp[p3]),5*dp[p5]);
            // 移动指针
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }

        return dp[n-1];
    }
}
