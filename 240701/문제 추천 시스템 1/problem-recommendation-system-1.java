import java.util.*;
import java.io.*;

class Question implements Comparable<Question>{
    int P, L;

    public Question(int P, int L){
        this.P = P;
        this.L = L;
    }

    @Override
    public int compareTo(Question q){
        if(this.L != q.L) return this.L - q.L;
        else return this.P - q.P;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeSet<Question> set = new TreeSet<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            set.add(new Question(P, L));
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int x=0, p=0, l=0;
        
            switch(command){
                case "rc":
                    x = Integer.parseInt(st.nextToken());

                    Question q = null;

                    if(x==1) q = set.last();
                    else q = set.first();

                    sb.append(q.P + "\n");
                    break;

                case "ad":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    set.add(new Question(p, l));
                    break;

                case "sv":
                    p = Integer.parseInt(st.nextToken());
                    l = Integer.parseInt(st.nextToken());

                    set.remove(new Question(p, l));
                    break;
            }
        }
        
        System.out.println(sb);
    }
}