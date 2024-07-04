import java.util.*;
import java.io.*;

class Node{
    String data;
    Node prev, next;

    public Node(String data){
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S_init = br.readLine();

        Node cur = new Node(S_init);

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            String S_value;

            Node n = null;

            switch(x){
                case 1:
                    S_value = st.nextToken();

                    n = new Node(S_value);
                    insertPrev(cur, n);
                    break;
                
                case 2:
                    S_value = st.nextToken();

                    n = new Node(S_value);
                    insertNext(cur, n);
                    break;
                
                case 3:
                    if(cur.prev != null){
                        cur = cur.prev;
                    }
                    break;
                
                case 4:
                    if(cur.next != null){
                        cur = cur.next;
                    }
                    break;
            }

            printNode(cur);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static void insertPrev(Node cur, Node n){
        n.prev = cur.prev;
        n.next = cur;

        if(n.prev != null){
            n.prev.next = n;
        }

        if(n.next != null){
            n.next.prev = n;
        }
    }

    static void insertNext(Node cur, Node n){
        n.prev = cur;
        n.next = cur.next;

        if(n.prev != null){
            n.prev.next = n;
        }

        if(n.next != null){
            n.next.prev = n;
        }
    }

    static void printNode(Node cur){
        if(cur.prev == null) sb.append("(Null) ");
        else sb.append(cur.prev.data + " ");

        sb.append(cur.data + " ");

        if(cur.next == null) sb.append("(Null) ");
        else sb.append(cur.next.data + " ");
    }
}