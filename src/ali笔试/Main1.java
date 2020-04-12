package ali笔试;

import java.util.Scanner;

/**
 * @description：
 * 你有一次特训时间为n秒，木头人个数为m，血量为a，你的攻击范围为b，每次最多攻击b个木头人，每次攻击持续1s
 * 问：经过n秒的特训木头人血量为0的最多个数是多少
 * 样例:
 * 输入：
 * 1
 * 5 5 2 2
 * 输出：
 * 5
 * 时间n*每次最多扣的血量b(一次最多打几个)=在时间n内最多打的总血量
 * 然后除以每个开始的初始血量a，向小取整得到时间n内最多能达到多少怪，总共有m个怪，
 * 取它们的最小值就是结果
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/8 9:26
 * @level：
 */
public class Main1 {
    public static void main(String[] args) {
        int t;
        Scanner scanner=new Scanner(System.in);
        t=scanner.nextInt();

        for(int i=1;i<=t;i++){
            int time=scanner.nextInt();
            int num=scanner.nextInt();
            int first_blood=scanner.nextInt();
            int max_attack=scanner.nextInt();
            if(time<first_blood){
                System.out.println(0);
                continue;
            }
            if(time==first_blood){
                System.out.println(max_attack);
                continue;
            }
            if(time*max_attack>=num*first_blood){  //大于了总血量
                System.out.println(num);
            }
            else
                System.out.println((int) Math.floor((double) time*max_attack/(double) first_blood));
        }
    }
}
