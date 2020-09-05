package 思迈特笔试;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2020/8/5 20:02
 * @Description:
 * @Url:
 * @限制:
 * @Level:
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> minIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) >= k) {
                if (list.contains(arr[i])) continue;
                minIndex.put(arr[i], i);
                list.add(arr[i]);
            }
        }
        if (list.size() == 0) {
            System.out.println("-1");
        }
        else if (list.size() == 1) {
            System.out.println(list.get(0));
        }else {
            Collections.sort(list, new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    if (! map.get(o1).equals(map.get(o2))) {
                        return map.get(o2).compareTo(map.get(o1));
                    } else {
                        return minIndex.get(o1).compareTo(o2);
                    }
                }
            });
            System.out.println(list.get(0));
        }
    }
}
