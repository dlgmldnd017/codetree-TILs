import java.util.*;

public class Main {
    private PriorityQueue<Integer> maxHeap; // 최대 힙
    private PriorityQueue<Integer> minHeap; // 최소 힙

    public Main() {
        // 최대 힙은 역순으로 정렬하여 최대값을 루트에 위치시킴
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙은 기본 정렬(오름차순)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 최대 힙에 새 숫자를 추가
        maxHeap.offer(num);
        // 최대 힙의 루트를 최소 힙으로 이동
        minHeap.offer(maxHeap.poll());

        // 최소 힙의 크기가 최대 힙보다 크면, 최소 힙의 루트를 최대 힙으로 이동
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public int findMedian() {
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            Main mf = new Main();
            List<Integer> medians = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                mf.addNum(num);

                if (j % 2 == 0) { // 홀수 번째 수 (0-indexed에서 짝수)
                    medians.add(mf.findMedian());
                }
            }

            // 중앙값 출력
            for (int k = 0; k < medians.size(); k++) {
                if (k > 0) System.out.print(" ");
                System.out.print(medians.get(k));
            }
            System.out.println();
        }

        sc.close();
    }
}