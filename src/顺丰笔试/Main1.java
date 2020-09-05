package 顺丰笔试;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] servers = new int[n];
        int[][] need_price = new int[m][2];
        for (int i = 0; i < n; i++)
            servers[i] = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                need_price[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(servers);
        Arrays.sort(need_price, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return Integer.compare(o2[1], o1[1]);
            }
        });
        boolean[] vis = new boolean[m];

        int cnt = 0;
        for (int server : servers) {
            for (int i = 0; i < m; i++) {
                if (!vis[i] && need_price[i][0] <= server) {
                    cnt += need_price[i][1];
                    vis[i] = true;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
