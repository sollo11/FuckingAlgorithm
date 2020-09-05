package 蜗牛技术笔试;
import java.util.*;

/**
 * @Author: Jack
 * @Date: 2020/8/10 20:02
 * @Description: 
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class Main4 {

    private static List<List<Integer>> paths = new ArrayList<>();
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        int c = 0;
        int cnt = 5;
        String[] s = new String[cnt];
        int maxL = 0;
        while (c++ != cnt) {
            s[c - 1] = scanner.nextLine();
            maxL = Math.max(s[c - 1].split(",").length, maxL);
        }
        int[][] arr = new int[cnt][maxL];
        for (int[] i : arr) Arrays.fill(i, Integer.MIN_VALUE);
        HashMap<Integer, Integer> leMap = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            String[] temp = s[i].split(",");
            leMap.put(i,temp.length);
            for (int j = 0; j < temp.length; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        List<Integer> path = new ArrayList<>();
        path.add(arr[0][0]);
        dfs(0, 0,  cnt, arr, path, leMap);
        System.out.println(paths);
    }
    private static void dfs(int i, int j, int cnt, int[][] arr, List<Integer> curPath, HashMap<Integer, Integer> leMap) {

        if (i == cnt) return;

        else {

            if (i + 1 == cnt) {
                paths.add(new ArrayList<>(curPath));return;
            }
            for (int col1 = j + 1; col1 < leMap.get(i); col1++) {

                for (int col2 = 0; col2 < leMap.get(i + 1); col2++) {
                    if (curPath.get(curPath.get(curPath.size() - 1)) < arr[i][j]) {
                        curPath.add(arr[i + 1][col2]);
                    }
                    dfs(i + 1, col2, cnt, arr, curPath, leMap);
                }
            }
        }
    }
}
