package 数论系列.快速幂模板;import java.util.Scanner;
/**
 * @Author: Jack
 * @Date: 2020/6/11 10:59
 * @Description:
 * 矩阵快速幂
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class FastPow {

    private static final int MOD = 1_000_000_00_7;

    /**
     * 求a^k
     * @param a
     * @param k
     * @return
     */
    long fastPow(int a, int k) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) != 0) //如果k的二进制最后一位是1的话（k是奇数）就乘以一份a，化成a * a^(k-1),k-1此时为偶数
                res = res * a % MOD;
            /**
             * 例如3^23 = 3^1 * 3^2 * 3^4 * 3^16...，这里是根据幂的二进制进行分解的
             * 23=(10111)=1+2+4+16
             * a和k的演化是
             * a: 3       3^2       3^4       3^8                                    3^16  3^32
             * k: 10111   1011      101       10(此时不会进入前面的条件，a不会乘以res)      1     0
             */
            a = a * a % MOD;
            k >>= 1;  //消去最后一位二进制
        }
        return res;
    }
    public static void main(String[] args){
         Scanner scanner=new Scanner(System.in);
         long res = new FastPow().fastPow(3,23);
         System.out.println(res);
    }
}
