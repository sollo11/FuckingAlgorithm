package 蜗牛技术笔试;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        /*
            时间复杂度：O(n)
            空间复杂度：O(n)
         */
        Scanner scanner=new Scanner(System.in);
        String s = scanner.next();
        char[] chs = s.toCharArray();
        int cnt = 0;
        for(char ch : chs) {
            if (ch == 'a') cnt++;
        }
        System.out.println(cnt);
        
    }
}
