import java.util.*;
import java.io.*;

class Node {
    int num;
    Node prev, next;

    public Node(int num) {
        this.num = num;
    }
}

class Line {
    Node head, tail;

    public Line() {
        head = null;
        tail = null;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Node> map = new HashMap<>();
    static Line[] lines;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        lines = new Line[M];

        for (int i = 0; i < M; i++) {
            lines[i] = new Line();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n > 0) {
                int first = Integer.parseInt(st.nextToken());
                Node headNode = new Node(first);
                map.put(first, headNode);
                lines[i].head = headNode;
                Node current = headNode;

                for (int j = 1; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    Node newNode = new Node(num);
                    map.put(num, newNode);
                    current.next = newNode;
                    newNode.prev = current;
                    current = newNode;
                }

                lines[i].tail = current;
            }
        }

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                handleCommand1(a, b);
            } else if (command == 2) {
                int a = Integer.parseInt(st.nextToken());
                handleCommand2(a);
            } else if (command == 3) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                handleCommand3(a, b, c);
            }
        }

        for (Line line : lines) {
            if (line.head == null) {
                sb.append("-1\n");
            } else {
                Node current = line.head;
                while (current != null) {
                    sb.append(current.num).append(" ");
                    current = current.next;
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void handleCommand1(int a, int b) {
        Node nodeA = map.get(a);
        Node nodeB = map.get(b);

        if (nodeA == nodeB.prev) return; // If already in position

        // Remove nodeA from its current position
        if (nodeA.prev != null) {
            nodeA.prev.next = nodeA.next;
        } else {
            for (Line line : lines) {
                if (line.head == nodeA) {
                    line.head = nodeA.next;
                    break;
                }
            }
        }

        if (nodeA.next != null) {
            nodeA.next.prev = nodeA.prev;
        } else {
            for (Line line : lines) {
                if (line.tail == nodeA) {
                    line.tail = nodeA.prev;
                    break;
                }
            }
        }

        // Insert nodeA before nodeB
        nodeA.next = nodeB;
        nodeA.prev = nodeB.prev;

        if (nodeB.prev != null) {
            nodeB.prev.next = nodeA;
        } else {
            for (Line line : lines) {
                if (line.head == nodeB) {
                    line.head = nodeA;
                    break;
                }
            }
        }
        nodeB.prev = nodeA;
    }

    static void handleCommand2(int a) {
        Node nodeA = map.get(a);

        // Remove nodeA from its current position
        if (nodeA.prev != null) {
            nodeA.prev.next = nodeA.next;
        } else {
            for (Line line : lines) {
                if (line.head == nodeA) {
                    line.head = nodeA.next;
                    break;
                }
            }
        }

        if (nodeA.next != null) {
            nodeA.next.prev = nodeA.prev;
        } else {
            for (Line line : lines) {
                if (line.tail == nodeA) {
                    line.tail = nodeA.prev;
                    break;
                }
            }
        }

        map.remove(a);
    }

    static void handleCommand3(int a, int b, int c) {
        Node start = map.get(a);
        Node end = map.get(b);
        Node target = map.get(c);

        // Remove the segment from the current line
        if (start.prev != null) {
            start.prev.next = end.next;
        } else {
            for (Line line : lines) {
                if (line.head == start) {
                    line.head = end.next;
                    break;
                }
            }
        }

        if (end.next != null) {
            end.next.prev = start.prev;
        } else {
            for (Line line : lines) {
                if (line.tail == end) {
                    line.tail = start.prev;
                    break;
                }
            }
        }

        // Insert the segment before the target
        if (target.prev != null) {
            target.prev.next = start;
        } else {
            for (Line line : lines) {
                if (line.head == target) {
                    line.head = start;
                    break;
                }
            }
        }

        start.prev = target.prev;
        end.next = target;
        target.prev = end;
    }
}