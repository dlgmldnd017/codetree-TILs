import java.util.*;
import java.io.*;

class Node{
    int num;
    Node prev, next;

    public Node(int num){
        this.num = num;
    }
}

class Line{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static Map<Integer, Node> map = new HashMap<>();
    static List<Line> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())+1;
        int Q = Integer.parseInt(st.nextToken());

        for(int i=1; i<M; i++){
            Line l = new Line();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y;

            map.put(x, new Node(x));
            l.head = map.get(x);

            for(int j=1; j<n; j++){
                y = Integer.parseInt(st.nextToken());
                map.put(y, new Node(y));

                map.get(x).next = map.get(y);
                map.get(y).prev = map.get(x);

                x = y;
            }

            l.tail = map.get(x);
            l.head.prev = l.tail;
            l.tail.next = l.head;

            list.add(l);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int A, B;

            switch(command){
                case 1:
                    A = Integer.parseInt(st.nextToken());
                    B = Integer.parseInt(st.nextToken());

                    handleCommand1(A, B);
                    break;

                case 2:
                    A = Integer.parseInt(st.nextToken());
                    B = Integer.parseInt(st.nextToken());

                    handleCommand2(A, B);
                    break;

                case 3:
                    A = Integer.parseInt(st.nextToken());

                    handleCommand3(A);
                    break;
            }
        }
        System.out.println(sb);
    }

    static void handleCommand1(int A, int B){
        Node nodeA = map.get(A);
        Node nodeB = map.get(B);

        nodeA.next.prev = nodeB.prev;
        nodeB.prev.next = nodeA.next;

        nodeA.next = nodeB;
        nodeB.prev = nodeA;

        Line lineA = findLine(nodeA);
        Line lineB = findLine(nodeB);

        list.remove(lineA);
        list.remove(lineB);

        Line l = new Line();
        l.head = nodeB;
        l.tail = nodeA;

        list.add(l);
    }

    static void handleCommand2(int A, int B){
        Node nodeA = map.get(A);
        Node nodeB = map.get(B);
        Node prevB = map.get(B).prev;

        Line l = findLine(nodeA);
        list.remove(l);

        // 라인 B
        Line lineB = new Line();
        nodeA.prev.next = nodeB;
        nodeB.prev = nodeA.prev;

        lineB.head = nodeB;
        lineB.tail = nodeB.prev;
        list.add(lineB);

        // 라인 A
        Line lineA = new Line();
        nodeA.prev = prevB;
        prevB.next = nodeA;

        lineA.head = nodeA;
        lineA.tail = nodeA.prev;
        list.add(lineA);
    }

    static void handleCommand3(int A){
        Node nodeA = map.get(A);

        Line lineA = findLine(nodeA);
        
        int min = Integer.MAX_VALUE;

        Node cur = lineA.head;
            
        do{
            min = Math.min(min, cur.num);
            cur = cur.next;
        } while(cur != lineA.head);

        cur = map.get(min);
            
        do{
            sb.append(cur.num+" ");
            cur = cur.prev;
        } while(cur != map.get(min));
    }

    static Line findLine(Node node){
        for(Line line : list){
            Node cur = line.head;

            do{
                if(cur == node) return line;
                cur = cur.next;
            } while(cur != line.head);
        }

        return null;
    }
}