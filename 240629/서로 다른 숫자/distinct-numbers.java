import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(set.size());
    }
}