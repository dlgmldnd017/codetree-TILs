import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken());

        int position[] = new int[N];

        for(int i=1; i<N; i++){
            position[i] = i;
        }

        int map[][] = new int[N][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[i][0] = a;
            map[i][1] = b;
        }

        HashSet<Integer>[] set = new HashSet[N];

        for(int i=1; i<N; i++){
            set[i] = new HashSet<>();

            set[i].add(i);
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<K; j++){
                int a = map[j][0];
                int b = map[j][1];

                int tmp = position[a];
                position[a] = position[b];
                position[b] = tmp;

                set[position[a]].add(a);
                set[position[b]].add(b);
            }
        }

        for(int i=1; i<N; i++){
            sb.append(set[i].size()+"\n");
        }

        System.out.println(sb);
    }
}