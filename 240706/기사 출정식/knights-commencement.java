import java.util.*;
import java.io.*;

class Node {
    int num;
    Node prev, next;

    public Node(int num) {
        this.num = num;
    }
}

class Gisa {
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Gisa g = new Gisa();
        Map<Integer, Node> nodeMap = new HashMap<>();

        int[] number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            nodeMap.put(number[i], new Node(number[i]));
        }

        g.head = nodeMap.get(number[0]);
        g.head.next = nodeMap.get(number[1]);

        g.tail = nodeMap.get(number[N - 1]);
        g.tail.prev = nodeMap.get(number[N - 2]);

        for (int i = 1; i < N - 1; i++) {
            nodeMap.get(number[i]).prev = nodeMap.get(number[i - 1]);
            nodeMap.get(number[i]).next = nodeMap.get(number[i + 1]);
        }

        for (int m = 0; m < M; m++) {
            int x = Integer.parseInt(br.readLine());
            Node currentNode = nodeMap.get(x);

            if (currentNode == g.head) {
                sb.append(currentNode.next.num).append(" ").append(g.tail.num).append("\n");

                g.head = currentNode.next;
                g.head.prev = null;
                currentNode.next = null;
            } else if (currentNode == g.tail) {
                sb.append(g.head.num).append(" ").append(currentNode.prev.num).append("\n");

                g.tail = currentNode.prev;
                g.tail.next = null;
                currentNode.prev = null;
            } else {
                sb.append(currentNode.next.num).append(" ").append(currentNode.prev.num).append("\n");

                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;

                currentNode.next = currentNode.prev = null;
            }
        }

        System.out.println(sb);
    }
}