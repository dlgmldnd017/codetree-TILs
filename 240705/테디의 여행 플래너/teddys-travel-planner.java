import java.util.*;
import java.io.*;

class Node{
    String data;
    Node prev, next;

    public Node(String data){
        this.data = data;
    }
}

class City{
    Node head, tail;
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        City cities = new City();

        st = new StringTokenizer(br.readLine());
        cities.head = cities.tail = new Node(st.nextToken());

        for(int i=1; i<N; i++){
            Node newTailNode = new Node(st.nextToken());
            Node originalTailNode = cities.tail;

            cities.tail.next = newTailNode;
            cities.tail = newTailNode;

            cities.tail.prev = originalTailNode;
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            String str;

            Node head, tail;

            switch(command){
                case 1:
                    // head 변경
                    head = cities.head;
                    cities.head.next.prev = null;
                    cities.head = cities.head.next;

                    // tail 변경
                    tail = cities.tail;
                    head.next = null;
                    cities.tail.next = head;
                    cities.tail = head;
                    cities.tail.prev = tail;
                    break;

                case 2:
                    // tail 변경
                    tail = cities.tail;
                    cities.tail.prev.next = null;
                    cities.tail = cities.tail.prev;

                    // head 변경
                    head = cities.head;
                    tail.prev = null;
                    cities.head.prev = tail;
                    cities.head = tail;
                    cities.head.next = head;
                    break;

                case 3:
                    if(cities.head.next.next == cities.tail){
                        cities.head.next.next.prev = cities.head;
                        cities.head.next = cities.tail;
                    }

                    else{
                        cities.head.next = cities.head.next.next;
                        cities.head.next.next.prev = cities.head;
                    }

                    break;

                case 4:
                    str = st.nextToken();
                    Node newCity = new Node(str);

                    cities.head.next.prev = newCity;
                    newCity.next = cities.head.next;
                    newCity.prev = cities.head;
                    cities.head.next = newCity;
                    break;
            }

            if((cities.head.next.data.equals(cities.tail.data)) || (cities.tail == null) || (cities.head.next == null)) sb.append("-1\n");
            else sb.append(cities.tail.data + " " + cities.head.next.data + "\n");
        }

        System.out.println(sb);
    }
}