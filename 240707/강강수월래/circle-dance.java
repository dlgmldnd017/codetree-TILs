import java.util.*;
import java.io.*;

class Node{
    int num, line;
    Node prev, next;

    public Node(int num, int line){
        this.num = num;
        this.line = line;
    }
}

class Circle{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static Circle c[];
    static Map<Integer, Node> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())+1;
        int Q = Integer.parseInt(st.nextToken());

        c = new Circle[M];
        c[0] = new Circle();

        for(int i=1; i<M; i++){
            c[i] = new Circle();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y;

            map.put(x, new Node(x, i));
            c[i].head = map.get(x);

            for(int j=1; j<n; j++){
                y = Integer.parseInt(st.nextToken());
                map.put(y, new Node(y, i));

                map.get(x).next = map.get(y);
                map.get(y).prev = map.get(x);

                x = y;
            }

            c[i].tail = map.get(x);

            c[i].head.prev = c[i].tail;
            c[i].tail.next = c[i].head;
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

        c[nodeB.line].head = c[nodeB.line].tail = null;
    }

    static void handleCommand2(int A, int B){
        Node nodeA = map.get(A);
        Node nodeB = map.get(B);

        Node prevB = map.get(B).prev;

        nodeA.prev.next = nodeB;
        nodeB.prev = nodeA.prev;

        int idx=0;
        for(Circle circle : c){
            if(circle.head == null) break;
            idx++;
        }

        nodeA.prev = null;
        prevB.next = null;

        c[idx].head = nodeA;
        c[idx].tail = prevB;

    }

    static void handleCommand3(int A){
        Node nodeA = map.get(A);

        int min = Integer.MAX_VALUE;

        Node head = c[nodeA.line].head;
        while(head!=c[nodeA.line].tail){
            min = Math.min(min, head.num);
            head = head.next;
        }

        if(min>c[nodeA.line].tail.num) min = c[nodeA.line].tail.num;

        Node n = map.get(min);
        do{
            sb.append(n.num + " ");
            n = n.prev;
        } while(n != map.get(min));
    }
}