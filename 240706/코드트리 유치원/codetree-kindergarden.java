import java.util.*;
import java.io.*;

class Node{
    int num;
    Node prev, next;

    public Node(int num){
        this.num = num;
    }
}

class Order{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, Node> map = new HashMap<>();
        map.put(1, new Node(1));

        Order o = new Order();
        o.head = map.get(1);
        o.tail = map.get(1);

        int Q = Integer.parseInt(br.readLine());

        int cnt = 2;

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a, b;

            Node tmp;

            switch(command){
                case 1:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());

                    if(o.tail == map.get(a)){
                        for(int i=0; i<b; i++){
                            map.put(cnt, new Node(cnt));
                            o.tail.next = map.get(cnt);
                            map.get(cnt).prev = o.tail;
                            o.tail = map.get(cnt);

                            cnt++;
                        }
                    }
                    else{
                        tmp = map.get(a).next;

                        map.put(cnt, new Node(cnt));
                        map.get(a).next = map.get(cnt);
                        map.get(cnt).prev = map.get(a);
                        cnt++;

                        for(int i=1; i<b; i++){
                            map.put(cnt, new Node(cnt));
                            map.get(cnt-1).next = map.get(cnt);
                            map.get(cnt).prev = map.get(cnt-1);

                            cnt++;
                        }

                        map.get(cnt-1).next = tmp;
                        map.get(cnt-1).next.prev = map.get(cnt-1);
                    }

                    break;

                case 2:
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());

                    if(o.head == map.get(a)){
                        tmp = o.head;

                        map.put(cnt, new Node(cnt));
                        o.head = map.get(cnt);
                        cnt++;

                        for(int i=1; i<b; i++){
                            map.put(cnt, new Node(cnt));
                            map.get(cnt-1).next = map.get(cnt);
                            map.get(cnt).prev = map.get(cnt-1);
                            cnt++;
                        }

                        map.get(cnt-1).next = tmp;
                        map.get(cnt-1).next.prev = map.get(cnt-1);
                    }
                    else{
                        map.put(cnt, new Node(cnt));
                        map.get(cnt).prev = map.get(a).prev;
                        map.get(a).prev.next = map.get(cnt);
                        cnt++;

                        for(int i=1; i<b; i++){
                            map.put(cnt, new Node(cnt));
                            map.get(cnt-1).next = map.get(cnt);
                            map.get(cnt).prev = map.get(cnt-1);
                            cnt++;
                        }

                        map.get(a).prev = map.get(cnt-1);
                        map.get(cnt-1).next = map.get(a);
                    }
                    break;

                case 3:
                    a = Integer.parseInt(st.nextToken());

                    if(map.get(a).prev==null || map.get(a).next==null) sb.append("-1\n");
                    else sb.append(map.get(a).prev.num + " " + map.get(a).next.num + " \n");

                    break;
            }
        }

        System.out.println(sb);
    }
}