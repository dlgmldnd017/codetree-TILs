import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String groupA[] = new String[N];

        for(int i=0; i<N; i++){
            groupA[i] = br.readLine();
        }

        String groupB[] = new String[N];

        for(int i=0; i<N; i++){
            groupB[i] = br.readLine();
        }

        int ans = 0;

        for(int i=0; i<M; i++){
            for(int j=i+1; j<M; j++){
                for(int k=j+1; k<M; k++){
                    if(isVaild(groupA, groupB, i, j, k)) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean isVaild(String groupA[], String groupB[], int i, int j, int k){
        HashSet<String> setA = new HashSet<>();
        HashSet<String> setB = new HashSet<>();

        for(String str : groupA){
            setA.add("" + str.charAt(i) + str.charAt(j) + str.charAt(k));
        }

        for(String str : groupB){
            setB.add("" + str.charAt(i) + str.charAt(j) + str.charAt(k));
        }

        for(String str : setA){
            if(setB.contains(str)) return false;
        }

        return true;
    }
}