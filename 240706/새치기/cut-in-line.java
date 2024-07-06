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

        for(int i=1; i<M; i++){
            l[i] = new Line();
            
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            int x = Integer.parseInt(st.nextToken());
            map.put(x, new Node(x, i));

            l[i].head = map.get(x);

            for(int j=1; j<n; j++){
                int y = Integer.parseInt(st.nextToken());

                map.put(y, new Node(y, i));
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

                    lineA = map.get(a).line;
                    lineB = map.get(b).line;
                    
                    // (1) 같은 라인일 경우
                    if(lineA == lineB){
                        if(map.get(a) == l[lineA].tail){
                            map.get(a).prev.next = null;
                            l[lineA].tail = map.get(a).prev;
                            map.get(a).prev = null;
                            
                            if(map.get(b) == l[lineA].head){
                                map.get(a).next = map.get(b);
                                map.get(b).prev = map.get(a);
                                l[lineA].head = map.get(a);
                            }
                        }
                        else{
                            map.get(a).prev.next = map.get(a).next;
                            map.get(a).next.prev = map.get(a).prev;
                        }

                        map.get(a).next = map.get(b);
                        map.get(a).prev = map.get(b).prev;
                        map.get(b).prev.next = map.get(a);
                        map.get(b).prev = map.get(a);
                    }

                    // (2) 다른 라인이면서, a 번이 해당 라인의 head일 경우
                    else if(l[lineA].head == map.get(a)){
                        if(map.get(a).next != null){
                            l[lineA].head = map.get(a).next;
                            map.get(a).next.prev = null;
                        }
                        else{
                            l[lineA].head = l[lineA].tail = null;
                        }

                        addFirst(a, b);
                    }

                    // (3) 다른 라인이면서, a번이 해당 라인의 tail일 경우
                    else if(l[lineA].tail == map.get(a)){
                        if(map.get(a).prev != null){
                            l[lineA].tail = map.get(a).prev;
                            map.get(a).prev.next = null;
                        }
                        else{
                            l[lineA].head = l[lineA].tail = null;
                        }
                        addFirst(a, b);
                    }
                    break;

                case 2:
                    a = Integer.parseInt(st.nextToken());
                    lineA = map.get(a).line;

                    if(l[lineA].head == map.get(a)){
                        if(l[lineA].tail == map.get(a)){
                            l[lineA].head = l[lineA].tail = null;
                        }
                        else{
                            l[lineA].head = map.get(a).next;
                            l[lineA].head.prev = null;
                        }
                    }
                    else if(l[lineA].tail == map.get(a)){
                        l[lineA].tail = map.get(a).prev;
                        l[lineA].tail.next = null;
                    }
                    else{
                        map.get(a).prev.next = map.get(a).next;
                        map.get(a).next.prev = map.get(a).prev;
                    }

                    map.remove(a);
                    break;

                case 3:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());

                    lineA = map.get(a).line;

                    if(l[lineA].head == map.get(a)){
                        if(l[lineA].tail == map.get(b)){
                            l[lineA].head = l[lineA].tail = null;
                        }
                        else{
                            l[lineA].head = map.get(b).next;
                            map.get(b).next.prev = null;
                        }
                    }
                    else{
                        if(l[lineA].tail == map.get(b)){
                            l[lineA].tail = map.get(a).prev;
                            map.get(a).prev.next = null; 
                        }
                        else{
                            map.get(a).prev.next = map.get(b).next;
                            map.get(b).next.prev = map.get(a).prev;
                        }
                    }

                    addFirstC(a, b, c);
                    break;
            }
        }

        for(int i=1; i<M; i++){
            if(l[i].head == null) sb.append("-1\n");
            else{
                if(l[i].head == l[i].tail) sb.append(l[i].head.num + "\n");
                else{
                    Node n = l[i].head;

                    while(n != null){
                        sb.append(n.num + " ");
                        n = n.next;
                    }
                    sb.append("\n");
                }
            }
        }
        
        System.out.println(sb);
    }

    static void addFirst(int a, int b){
        int lineA = map.get(a).line;
        int lineB = map.get(b).line;
        
        if(l[lineB].head == map.get(b)){
            map.get(b).prev = map.get(a);
            map.get(a).next = map.get(b);
            l[lineB].head = map.get(a);
        }
        else{
            map.get(a).next = map.get(b);
            map.get(b).prev.next = map.get(a);
            map.get(a).prev = map.get(b).prev;
            map.get(b).prev = map.get(a);
        }
    }

    static void addFirstC(int a, int b, int c){
        int lineC = map.get(c).line;

        if(l[lineC].head == map.get(c)){
            l[lineC].head = map.get(a);
            map.get(c).prev = map.get(b);
        }
        else{
            map.get(a).prev = map.get(c).prev;
            map.get(a).prev.next = map.get(a);
            map.get(b).next = map.get(c);
            map.get(c).prev = map.get(b);
        }
    }
}