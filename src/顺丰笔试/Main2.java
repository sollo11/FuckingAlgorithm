package 顺丰笔试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    static HashMap<Integer, Long> index_maxMoney = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] tasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                tasks[i][j] = scanner.nextInt();
            }
        }
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(o2[2], o1[2]);
            }
        });
        long ans = 0;
        for(int start = 0; start < n; start++) {
            ans = Math.max(ans, dfs(start, tasks, n));
        }
        System.out.println(ans);
    }

    private static long dfs(int start, int[][] tasks, int len) {
        if (index_maxMoney.containsKey(start)) return index_maxMoney.get(start);
        long sum = tasks[start][2];
        int j = tasks[start][1];
        for (int i = start + 1; i < len; i++) {
            if (tasks[i][0] > j) {
                sum += dfs(i, tasks, len);
                break;
            }
        }
        index_maxMoney.put(start, sum);
        return sum;
    }
}
