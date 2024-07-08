import java.util.*;
import java.io.*;

class Node{
    String name;
    Node prev, next;

    public Node(String name){
        this.name = name;
    }
}

class Line{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static Map<String, Node> map = new HashMap<>();
    static Line line[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken())+1;
        int Q = Integer.parseInt(st.nextToken());

        line = new Line[M];

        for(int i=0; i<M; i++){
            line[i] = new Line();
        }

        double X = N/(M-1);
        int x1 = (int) X;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<M; i++){
            String cur = st.nextToken();

            map.put(cur, new Node(cur));
            line[i].head = map.get(cur);

            for(int j=2; j<=x1; j++){
                String next = st.nextToken();
                map.put(next, new Node(next));

                map.get(cur).next = map.get(next);
                map.get(next).prev = map.get(cur);

                cur = next;
            }
            line[i].tail = map.get(cur);
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            String a, b, c;

            switch(command){
                case 1:
                    a = st.nextToken();
                    b = st.nextToken();
                    handleCommand1(a, b);
                    break;

                case 2:
                    a = st.nextToken();
                    handleCommand2(a);
                    break;

                case 3:
                    a = st.nextToken();
                    b = st.nextToken();
                    c = st.nextToken();
                    handleCommand3(a, b, c);
                    break;
            }
        }

        for(int i=1; i<M; i++){
            if(line[i].head == null) sb.append("-1\n");
            else{
                Node cur = line[i].head;
                do{
                    sb.append(cur.name + " ");
                    cur = cur.next;
                } while(cur != null);
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void handleCommand1(String a, String b){
        Node A = map.get(a);
        Node B = map.get(b);

        if(A.prev != null){
            A.prev.next = A.next;
        }
        else{
            for(Line l : line){
                if(l.head == A){
                    l.head = A.next;
                    break;
                }
            }
        }

        if(A.next != null){
            A.next.prev = A.prev;
        }
        else{
            for(Line l : line){
                if(l.tail == A){
                    l.tail = A.prev;
                    break;
                }
            }
        }

        A.prev = B.prev;
        
        if(B.prev != null){
            B.prev.next = A;
        }
        else{
            for(Line l : line){
                if(l.head == B){
                    l.head = A;
                    break;
                }
            }
        }

        map.get(a).next = map.get(b);
        map.get(b).prev = map.get(a);
    }

    static void handleCommand2(String a){
        Node A = map.get(a);

        if(A.prev != null){
            A.prev.next = A.next;
        }
        else{
            for(Line l : line){
                if(l.head == A){
                    l.head = A.next;
                    break;
                }
            }
        }

        if(A.next != null){
            A.next.prev = A.prev;
        }
        else{
            for(Line l : line){
                if(l.tail == A){
                    l.tail = A.prev;
                    break;
                }
            }
        }

        map.remove(a);
    }

    static void handleCommand3(String a, String b, String c){
        Node A = map.get(a);
        Node B = map.get(b);
        Node C = map.get(c);

        if(A.prev != null){
            A.prev.next = B.next;
        }
        else{
            for(Line l : line){
                if(l.head == A){
                    l.head = B.next;
                    break;
                }
            }
        }

        if(B.next != null){
            B.next.prev = A.prev;
        }
        else{
            for(Line l : line){
                if(l.tail == B){
                    l.tail = A.prev;
                    break;
                }
            }
        }

        if(C.prev != null){
            C.prev.next = A;
        }
        else{
            for(Line l : line){
                if(l.head == C){
                    l.head = A;
                    break;
                }
            }
        }

        A.prev = C.prev;
        B.next = C;
        C.prev = B;
    }
}