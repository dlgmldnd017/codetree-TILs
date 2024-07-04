import java.util.*;
import java.io.*;

class Node{
    int data;
    Node prev, next;

    public Node(int data){
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int Q = Integer.parseInt(br.readLine());

        Node n[] = new Node[N];

        for(int k=0; k<Q; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            int i, j;

            switch(x){
                case 1:
                    i = Integer.parseInt(st.nextToken());

                    if(n[i] != null) doSingleton(n[i]);
                    break;
                
                case 2:
                    i = Integer.parseInt(st.nextToken());
                    j = Integer.parseInt(st.nextToken());
                    
                    insertPrev(n[i], n[j]);
                    break;

                case 3:
                    i = Integer.parseInt(st.nextToken());
                    j = Integer.parseInt(st.nextToken());

                    insertNext(n[i], n[j]);
                    break;

                case 4:
                    i = Integer.parseInt(st.nextToken());

                    if(n[i] == null){
                        sb.append("0 0\n");
                    }

                    else{
                        if(n[i].prev != null) sb.append(n[i].prev);
                        else sb.append("0 ");

                        if(n[i].next != null) sb.append(n[i].next);
                        else sb.append("0\n");
                    }
                    
                    break;    
            }
        }

        for(int i=0; i<N; i++){
            if(n[i] != null && n[i].next != null) sb.append(n[i].next + " ");
            else sb.append("0 ");
        }
        
        System.out.println(sb);
    }

    static void doSingleton(Node n){
        // (1) 양쪽에 노드가 존재할 경우
        if(n.prev != null && n.next != null){
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        
        // (2) 왼쪽에만 노드가 존재할 경우
        else if(n.prev != null){
            n.prev.next = null;
        }

        // (3) 오른쪽에만 노드가 존재할 경우
        else if(n.next != null){
            n.next.prev = null;
        }

        n.next = n.prev = null;
    }

    static void insertPrev(Node n1, Node n2){
        n2.prev = n1.prev;
        n2.next = n1;

        if(n2.prev != null){
            n2.prev.next = n2;
        }

        if(n2.next != null){
            n2.next.prev = n2;
        }
    }

    static void insertNext(Node n1, Node n2){
        n2.prev = n1;
        n2.next = n1.next;

        if(n2.prev != null){
            n2.prev.next = n2;
        }

        if(n2.next != null){
            n2.next.prev = n2;
        }
    }
}