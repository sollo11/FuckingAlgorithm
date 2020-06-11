package 计蒜客;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/5/24 14:29
 * @Description: 超时
 * @Url: https://www.jisuanke.com/contest/9032/516229
 * @限制:
 * @Level:
 */
public class Main2 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++)
//            arr[i] = scanner.nextInt();
//        int c = scanner.nextInt();
//        int[] arrCopy = Arrays.copyOf(arr, n);
//        Arrays.sort(arrCopy);
//        int max = arrCopy[n - 1];
//        for (int i = 0; i < c; i++){
//            int sum = scanner.nextInt();
//            if (max > sum) {
//                System.out.println("Impossible");
//                continue;
//            }
//
//            int cnt = 0;
//            int ptr = 0;
//            int curSum = 0;
//
//            while (ptr < n) {
//                while (ptr<n && curSum < sum) {
//                    curSum += arr[ptr++];
//                }
//                cnt++;
//                if (curSum > sum) ptr--;
//                curSum = 0;
//            }
//            System.out.println(cnt);
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int c = scanner.nextInt();
        dp[0] = arr[0];
        int[] arrCopy = Arrays.copyOf(arr, n);
        Arrays.sort(arrCopy);
        int max = arrCopy[n - 1];
        for (int i = 0; i < c; i++) {
            int sum = scanner.nextInt();
            if (max > sum) {
                System.out.println("Impossible");
                continue;
            }
            int res = 1;
            for (int m = 1; m < n; m++){
                if (dp[m - 1] == sum) {
                    dp[m] = arr[m]; res++;continue;
                }
                if (arr[m] + dp[m - 1] < sum){
                    dp[m] = dp[m - 1] +arr[m];
                }
                else if(arr[m] + dp[m - 1] == sum){
                    dp[m] = sum;
                }
                else {
                    res++;
                    dp[m] = arr[m];
                }
            }
            System.out.println(res);
        }
    }
}
