import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 선분의 개수
        int K = scanner.nextInt(); // 최소 겹침 수
        List<Event> events = new ArrayList<>();

        int currentPos = 0;
        for (int i = 0; i < N; i++) {
            int length = scanner.nextInt();
            String direction = scanner.next();
            int start = currentPos;
            int end = (direction.equals("R")) ? currentPos + length : currentPos - length;

            // 각 선분의 시작과 끝 기록 (시작을 1로, 끝을 -1로)
            if (start < end) {
                events.add(new Event(start, 1));
                events.add(new Event(end, -1));
            } else {
                events.add(new Event(end, 1));
                events.add(new Event(start, -1));
            }
            currentPos = end;
        }

        // 이벤트를 위치 순서대로 정렬
        Collections.sort(events, (a, b) -> (a.position != b.position) ? a.position - b.position : a.type - b.type);

        int overlapCount = 0;
        int previousPos = Integer.MIN_VALUE;
        int result = 0;

        // 스위핑을 통해 겹치는 구간 계산
        for (Event event : events) {
            if (overlapCount >= K) {
                result += event.position - previousPos;
            }
            overlapCount += event.type;
            previousPos = event.position;
        }

        System.out.println(result);
    }

    static class Event {
        int position;
        int type; // 시작은 1, 끝은 -1

        Event(int position, int type) {
            this.position = position;
            this.type = type;
        }
    }
}