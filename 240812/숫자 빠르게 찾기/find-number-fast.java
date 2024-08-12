import java.util.*;
import java.io.*;

public class Main {
    static int N, M, arr[], ans;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=M; i++){
            int target = Integer.parseInt(br.readLine());

            solve(target);
        }

        System.out.print(sb);
    }

    static void solve(int target){
        int left = 1, right = N, idx = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) { // 찾았다면 해당 index를 반환합니다.
                idx = mid;
                break;
            }

            if(arr[mid] > target) // 찾으려는 숫자가 더 작다면
                right = mid - 1;  // 왼쪽 구간으로 이동해야 합니다.
            else                  // 찾으려는 숫자가 더 크다면
                left = mid + 1;   // 오른쪽 구간으로 이동해야 합니다.
        }

        sb.append(idx + "\n");
    }
}