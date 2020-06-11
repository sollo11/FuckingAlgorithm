import java.util.Scanner;
/**
 * @Author: Jack
 * @Date: 2020/5/30 23:24
 * @Description: 
 * @Url: 
 * @限制: 
 * @Level: 
 */
public class test {

    static class KMP{
        private String pat;
        private int[][] dfa;
        public  KMP(String pat){//由模式字符串构dfa
            this.pat = pat;
            int M = pat.length();
            int R = 256;
            dfa = new int[M][R];
            dfa[0][pat.charAt(0)] = 1;//其他的默认为0
            //推广一下有限状态自动机，上面的下一个状态正好是j+1而已，而真正的下一个状态应该是dfa[X][pat.charAt(j)]
            for(int X=0,j=1;j<M;j++){
                System.out.println(X);
                for(int c=0;c<R;c++)
                    dfa[j][c] = dfa[X][c];
                dfa[j][pat.charAt(j)] = j+1;
                X = dfa[X][pat.charAt(j)];//要好好理解这句话，

            }
        }
        public int search(String txt){
            int i,j=0,N = txt.length(),M=pat.length();
            for(i=0;i<N&&j<M;i++)
                j = dfa[j][txt.charAt(i)];
            if(j == M)
                return i-M;
            else
                return N;

        }
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        //String pat = "abacab";//0 0 1 0 1
        String pat = "ababac";//0 0 1 2 3
        KMP kmp = new KMP(pat);
        System.out.println(kmp.search("abababababababacabac"));
   }
}
