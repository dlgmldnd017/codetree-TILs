import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[], countingArr[], ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];

        int max=0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int input = Integer.parseInt(st.nextToken());

            arr[i] = input;

            max = Math.max(max, input);
        }

        countingArr = new int[max+1];

        solve();

        System.out.println(ans);
    }

    static void solve(){
        int j=0;

        for(int i=1; i<=N; i++){

            while(j+1<=N && countingArr[arr[j+1]] != 1){
                countingArr[arr[j+1]]++;
                j++;
            }

//            System.out.println(i + " : " + j);
            ans = Math.max(ans, j-i+1);

            countingArr[arr[i]]--;
        }
    }
}