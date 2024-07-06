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
    static Line l[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())+1;
        int Q = Integer.parseInt(st.nextToken());

        l = new Line[M];
        l[0] = new Line();

        for(int i=1; i<M; i++){
            l[i] = new Line();
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            int x = Integer.parseInt(st.nextToken());
            map.put(x, new Node(x));

            l[i].head = map.get(x);

            for(int j=1; j<n; j++){
                int y = Integer.parseInt(st.nextToken());

                map.put(y, new Node(y));
                map.get(x).next = map.get(y);
                map.get(y).prev = map.get(x);
                x = y;
            }

            l[i].tail = map.get(x);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            int a, b, c;
            int lineA, lineB;

            switch(command){
                case 1:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken()); 

                    command1(a, b);
                    break;

                case 2:
                    a = Integer.parseInt(st.nextToken());

                    command2(a);
                    break;

                case 3:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());

                    command3(a, b, c);
                    break;
            }
        }

        for(int i=1; i<M; i++){
            Line line = l[i];

            if(line.head == null) sb.append("-1\n");
            else{
                Node n = line.head;

                while(n != null){
                    sb.append(n.num + " ");
                    n = n.next;
                }
                sb.append("\n");
            }
        }


        System.out.println(sb);
    }

    static void command1(int a, int b){
        Node A = map.get(a);
        Node B = map.get(b);

        if(A == B.prev) return;

        // A 왼쪽 노드 확인
        if(A.prev != null){
            A.prev.next = A.next;
        }
        else{
            for(Line line : l){
                if(line.head == A) {
                    line.head = A.next;
                    break;
                }
            }
        }

        // A 오른쪽 노드 확인
        if(A.next != null){
            A.next.prev = A.prev;
        }
        else{
            for(Line line : l){
                if(line.tail == A) {
                    line.tail = A.prev;
                    break;
                }
            }
        }

        A.next = B;
        A.prev = B.prev;
        
        if(B.prev != null){
            B.prev.next = A;
        }
        else{
            for(Line line : l){
                if(line.head == B) {
                    line.head = A;
                    break;
                }
            }
        }

        B.prev = A;
    }

    static void command2(int a){
        Node A = map.get(a);

        if(A.prev != null){
            A.prev.next = A.next;
        }
        else{
            for(Line line : l){
                if(line.head==A){
                    line.head = A.next;
                    break;
                }
            }
        }

        if(A.next != null){
            A.next.prev = A.prev;
        }
        else{
            for(Line line : l){
                if(line.tail==A){
                    line.tail = A.prev;
                    break;
                }
            }
        }

        map.remove(a);
    }
    
    static void command3(int a, int b, int c){
        Node A = map.get(a);
        Node B = map.get(b);
        Node C = map.get(c);

        if(A.prev != null){
            A.prev.next = B.next;
        }
        else{
            for(Line line : l){
                if(line.head == A){
                    line.head = B.next;
                    break;
                }
            }
        }

        if(B.next != null){
            B.next.prev = A.prev;
        }
        else{
            for(Line line : l){
                if(line.tail == B){
                    line.tail = A.prev;
                    break;
                }
            }
        }

        if(C.prev != null){
            C.prev.next = A;
        }
        else{
            for(Line line : l){
                if(line.head == C){
                    line.head = A;
                    break;
                }
            }
        }

        A.prev = C.prev;
        B.next = C;
        C.prev = B;
    }
}