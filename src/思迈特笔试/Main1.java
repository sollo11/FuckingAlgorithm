package 思迈特笔试;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2020/8/5 18:57
 * @Description:
 * @Url:
 * @限制:
 * @Level:
 */
// 本题为考试多行输入输出规范示例，无需提交，不计分。

class Node{
    int val;
    Node next;
    int index;
    Node(int val, int index) {this.val = val; this.next = null;this.index=index;}
}
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String k1 = sc.nextLine();
        int k = Integer.parseInt(k1);
        Node head = new Node(-1, -1);
        Node ptr = head;
        int cnt = 0;
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int len = arr.length;
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) arr1[i] = Integer.parseInt(arr[i]);

        for (int i = 0, k2 = k; i < len; i++) {
            int left = (i / k) * k;
            int right = Math.min(left + k - 1, len - 1);
            int index, add;
            add = k - 1 + k * (right + 1) / 3;
            if (right == len - 1)
                add = (k - 1 + k * (right - k + 1) / 3) - (right - left - 1);
            index = add - i;
            // k2 = right == len - 1 ? right - left + 1 : k2;
            // int index;
            // if (i == left) index = right;
            // else if (i == right) index = left;
            // else index = right - i == k2 - 1 ? right : left + (k - 1 - (right - i));
            Node node = new Node(arr1[i], index);
            ptr.next = node;
            ptr = node;
        }
        Node ptr1 = head.next;
        int[] res = new int[arr.length];
        while(ptr1 != null) {
            res[ptr1.index] = ptr1.val;
            ptr1 = ptr1.next;
        }
        for(int i : res) System.out.print(i + " ");
        System.out.println();
    }

}
