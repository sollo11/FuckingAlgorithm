package 思迈特笔试;
import java.util.*;

/**
 * @Author: Jack
 * @Date: 2020/8/5 20:35
 * @Description: 
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class Main3 {

    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String str = scanner.next();
        HashSet<Character> select = new HashSet<>();
        HashSet<Character> has = new HashSet<>();
        for (char ch : str.toCharArray()) {
            select.add(ch);
        }
        backtrace("", has, str.length(), select);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : list) System.out.println(s);
    }
    private static void backtrace(String curStr,HashSet<Character> has, int maxLen, HashSet<Character> select) {
        if (curStr.length() == maxLen) {
            list.add(curStr); return;
        }
        for (Character ch : select) {
            if (has.contains(ch)) continue;
            has.add(ch);
            backtrace(curStr + ch, has, maxLen, select);
            has.remove(ch);
        }

    }
}
