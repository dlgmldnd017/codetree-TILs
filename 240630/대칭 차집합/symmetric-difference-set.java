import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<aSize; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<bSize; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        int countA = 0, countB = 0;

        for(int a : A){
            if(B.contains(a)) countB++;
        }

        for(int b : B){
            if(A.contains(b)) countA++;
        }

        System.out.println((A.size()-countA) + (B.size()-countB));
    }
}