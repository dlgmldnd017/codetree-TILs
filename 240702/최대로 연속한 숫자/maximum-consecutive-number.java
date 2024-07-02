import java.util.*;

public class Main {
    static class Interval implements Comparable<Interval> {
        int start, end, length;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start + 1;
        }

        @Override
        public int compareTo(Interval other) {
            if (this.length == other.length) {
                return this.start - other.start;
            }
            return other.length - this.length; // length 내림차순, 길이가 같으면 시작값 오름차순
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] toRemove = new int[m];
        for (int i = 0; i < m; i++) {
            toRemove[i] = scanner.nextInt();
        }

        // 초기 숫자 집합 생성
        TreeSet<Integer> numbers = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            numbers.add(i);
        }

        // 구간들을 저장할 TreeSet
        TreeSet<Interval> intervals = new TreeSet<>();
        intervals.add(new Interval(0, n));

        // 각 숫자를 제거하면서 최장 연속 수열 길이 계산
        for (int i = 0; i < m; i++) {
            int removeNum = toRemove[i];
            numbers.remove(removeNum);

            // 제거된 숫자가 포함된 구간 찾기
            Interval toRemoveInterval = null;
            for (Interval interval : intervals) {
                if (interval.start <= removeNum && removeNum <= interval.end) {
                    toRemoveInterval = interval;
                    break;
                }
            }

            // 구간 분리 및 재삽입
            if (toRemoveInterval != null) {
                intervals.remove(toRemoveInterval);

                if (toRemoveInterval.start < removeNum) {
                    intervals.add(new Interval(toRemoveInterval.start, removeNum - 1));
                }
                if (removeNum < toRemoveInterval.end) {
                    intervals.add(new Interval(removeNum + 1, toRemoveInterval.end));
                }
            }

            // 최장 연속 수열 길이 계산
            int maxLength = intervals.isEmpty() ? 0 : intervals.first().length;
            System.out.println(maxLength);
        }

        scanner.close();
    }
}