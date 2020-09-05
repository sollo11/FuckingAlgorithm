package 网易互娱笔试;
import java.util.Scanner;
/**
 * @Author: Jack
 * @Date: 2020/8/8 14:45
 * @Description: 
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class Main1 {
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long res = 0;
        for(int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            res += f(num);
        }
        System.out.println(res);
    }
    public static long f(int num) {
        if(num % 2 == 0) return num / 2;
        if (num == 1) return 0;
        return f(num / 2) + f(num - num / 2);
    }
}
