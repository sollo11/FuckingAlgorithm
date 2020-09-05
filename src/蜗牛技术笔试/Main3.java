package 蜗牛技术笔试;
import java.util.*;

public class Main3 {

    public static void main(String[] args){
        /*
            时间复杂度：O(n)
            空间复杂度：O(n)
         */
        Scanner scanner=new Scanner(System.in);
        String s = scanner.next();
        int[] count = new int[26];

        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        TreeSet<Integer> counts = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++){
            counts.add(count[i]);
            List<Character> list;
            if (map.containsKey(count[i])) {
                list = map.get(count[i]);
            }else {
                list = new ArrayList<>();
            }
            list.add((char)('a' + i));
            map.put(count[i], list);
        }
        StringBuilder builder = new StringBuilder();
        for(Integer i : counts) {
            while (!map.get(i).isEmpty()) {
                char ch = map.get(i).get(0);
                for(int c = 0; c < i; c++) {
                    builder.append(ch);
                }
                map.get(i).remove(0);
            }
        }
        System.out.println(builder.toString());
    }
}
