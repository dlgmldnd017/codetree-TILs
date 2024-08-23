import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;

        // 전체 숫자의 빈도 계산
        int[] totalCount = new int[m + 1];
        for (int num : arr) {
            totalCount[num]++;
        }

        int left = 0;
        int[] windowCount = new int[m + 1];
        int insideCount = 0; // 현재 구간 내 포함된 숫자의 종류 수

        for (int right = 0; right < n; right++) {
            int num = arr[right];

            if (windowCount[num] == 0) {
                insideCount++;
            }
            windowCount[num]++;

            // 구간 내 모든 숫자가 존재할 때까지 왼쪽 포인터 이동
            while (insideCount == m) {
                // 구간 밖에서 모든 숫자가 존재하는지 확인
                boolean isOutsideValid = true;
                for (int i = 1; i <= m; i++) {
                    if (totalCount[i] - windowCount[i] == 0) {
                        isOutsideValid = false;
                        break;
                    }
                }

                if (isOutsideValid) {
                    minLength = Math.min(minLength, right - left + 1);
                }

                // 윈도우 왼쪽 숫자를 제거하면서 왼쪽 포인터 이동
                windowCount[arr[left]]--;
                if (windowCount[arr[left]] == 0) {
                    insideCount--;
                }
                left++;
            }
        }

        // 결과 출력
        System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);
    }
}