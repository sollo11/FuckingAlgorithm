package 蜗牛技术笔试;
import java.util.Scanner;
/**
 * @Author: Jack
 * @Date: 2020/8/10 19:19
 * @Description: 
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class Main2 {

    public static void main(String[] args) {
        /*
            时间复杂度：O(n)
            空间复杂度：O(1)
         */
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++){
            ans = Math.max(ans, count[i]);
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == ans) {
                System.out.println((char)('a' + i));break;
            }
        }
    }
}
