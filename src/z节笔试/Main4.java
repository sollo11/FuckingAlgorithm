package z节笔试;

import java.util.*;

/**
 * @description：
 * @url：
 * @限制：
 * @author：Jack
 * @createTime：2020/4/12 18:47
 * @level：
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while ((t--)!=0){
            int n=in.nextInt();
            int[] a=new int[n];
            for (int i=0;i<n;i++){
                a[i]=in.nextInt();
            }
            Arrays.sort(a);
            if(n==1) {
                System.out.println(0);return;
            }
            HashMap<Integer,Integer> place=new HashMap<>();
            int[] res=new int[n];
            for (int i=1;i<n;i++){
                if(!place.containsKey(a[i]))
                    place.put(a[i],i);
                if(a[i-1]<a[i])
                    res[i]=i;
                else {
                    res[i]=place.get(a[i])-i;
                }
            }
           for (int i:res)
               System.out.print(i+" ");
            System.out.println();
        }
    }
}
