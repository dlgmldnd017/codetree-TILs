import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        // 이벤트 리스트를 만듭니다
        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(new int[]{intervals[i][0], 1});  // 시작점
            events.add(new int[]{intervals[i][1], -1}); // 끝점
        }

        // 이벤트를 정렬합니다. 시간이 같다면 끝점을 먼저 처리합니다.
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int maxOverlap = 0;
        int currentOverlap = 0;

        // 이벤트를 따라가면서 겹치는 구간의 수를 계산합니다
        for (int[] event : events) {
            currentOverlap += event[1];
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }

        System.out.println(maxOverlap);
    }
}