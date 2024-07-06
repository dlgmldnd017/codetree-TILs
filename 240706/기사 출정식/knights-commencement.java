import java.util.*;
import java.io.*;

class Node{
    int num;
    Node prev, next;

    public Node(int num){
        this.num = num;
    }
}

class Gisa{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        Gisa g = new Gisa();
        Node n[] = new Node[1000001];

        int number[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
            n[number[i]] = new Node(number[i]);
        }

        g.head = n[number[1]];
        g.head.next = n[number[2]];

        g.tail = n[number[N-1]];
        g.tail.prev = n[number[N-2]];

        for(int i=2; i<N-1; i++){
            n[number[i]].prev = n[number[i-1]];
            n[number[i]].next = n[number[i+1]];
        }

        for(int m=0; m<M; m++){
            int x = Integer.parseInt(br.readLine());

            if(n[x] == g.head){
                sb.append(n[x].next.num + " " + g.tail.num + "\n");

                g.head = n[x].next;
                g.head.prev = null;
                n[x].next = null;
            }

            else if(n[x] == g.tail){
                sb.append(g.head.num + " " + n[x].prev.num + "\n");

                g.tail = n[x].prev;
                g.tail.next = null;
                n[x].prev = null;
            }

            else{
                sb.append(n[x].next.num + " " + n[x].prev.num + "\n");

                n[x].prev.next = n[x].next;
                n[x].next.prev = n[x].prev;

                n[x].next = n[x].prev = null;
            }
        }

        System.out.println(sb);
    }
}