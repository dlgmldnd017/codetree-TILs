import java.util.*;

class Node implements Comparable<Node> {
    int index, arrivalTime, stayTime;

    public Node(int index, int arrivalTime, int stayTime) {
        this.index = index;
        this.arrivalTime = arrivalTime;
        this.stayTime = stayTime;
    }

    @Override
    public int compareTo(Node n) {
        if (this.arrivalTime != n.arrivalTime) {
            return this.arrivalTime - n.arrivalTime;
        }
        return this.index - n.index;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Node> pQue = new PriorityQueue<>(); // 도착시간 기준 우선순위 큐
        PriorityQueue<Node> temppQue = new PriorityQueue<>(Comparator.comparingInt(n -> n.index)); // 번호 순 우선순위 큐
        int[] timearr = new int[N];
        int maxtime = 0;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int t = sc.nextInt();
            timearr[i] = t;
            pQue.add(new Node(i, a, t));
        }

        int maxWaitTime = 0;

        while (!pQue.isEmpty()) {
            // 정원에 입장하기 위해서 기다려야 할 사람들
            while (!pQue.isEmpty()) {
                int arrivalTime = pQue.peek().arrivalTime;
                if (arrivalTime > maxtime) break;

                // 번호, 도착시간
                Node node = pQue.poll();
                temppQue.add(node);
            }

            int a, t;

            // 기다려야할 사람이 있다면
            if (!temppQue.isEmpty()) {
                Node node = temppQue.poll();
                a = node.arrivalTime;
                t = node.stayTime;
            }
            // 없다면
            else {
                Node node = pQue.poll();
                a = node.arrivalTime;
                t = node.stayTime;
            }

            // 최초 입장인 경우
            if (maxtime == 0) {
                maxtime = a + t;
            } else {
                // 입장하기 위해 기다린 경우
                if (maxtime > a) {
                    maxWaitTime = Math.max(maxWaitTime, maxtime - a);
                    maxtime += t;
                }
                // 안기다린 경우
                else {
                    maxtime = a + t;
                }
            }
        }

        System.out.println(maxWaitTime);

        sc.close();
    }
}