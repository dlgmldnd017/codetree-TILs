import java.util.*;
import java.io.*;

class Node{
    int data;
    Node prev, next;

    public Node(int data){
        this.data =data;
        prev = next = null;
    }
}

class BookShelf{
    Node head, tail;

    public BookShelf(){
        head = tail = null;
    }

    // (1) 맨 앞 삭제 후 맨 앞 노드 반환
    public Node removeFirst(){
        Node n = head;

        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }

        n.next = null;
        return n;
    }

    // (2) 맨 뒤 삭제 후 맨 뒤 노드 반환
    public Node removeLast(){
        Node n = tail;

        if(head == tail){
            head = tail = null;
        }

        else{
            tail = tail.prev;
            tail.next = null;
        }

        n.prev = null;
        return n;
    }

    // (3) 맨 앞 추가
    public void addFirst(Node n){
        if(head == null){
            head = tail = n;
        }

        else{
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    // (4) 맨 뒤 추가
    public void addLast(Node n){
        if(tail == null){
            head = tail = n;
        }

        else{
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    // (5) i번 책꽂이 -> j번 책꽂이 앞에 추가
    public void moveToFront(BookShelf target){
        if(target.head == null){
            target.head = this.head;
            target.tail = this.tail;
        }

        else{
            this.tail.next = target.head;
            target.head.prev = this.tail;
            target.head = this.head;
        }

        this.head = this.tail = null;
    }

    // (6) i번 책꽂이 -> j번 책꽂이 뒤에 추가
    public void moveToBack(BookShelf target){
        if(target.head == null){
            target.head = this.head;
            target.tail = this.tail;
        }

        else{
            target.tail.next = this.head;
            this.head.prev = target.tail;
            target.tail = this.tail;
        }

        this.head = this.tail = null;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int K = Integer.parseInt(st.nextToken())+1;

        int Q = Integer.parseInt(br.readLine());

        BookShelf bs[] = new BookShelf[K];
        for(int i=1; i<K; i++){
            bs[i] = new BookShelf();
        }

        // 1번 책꽂이에 1~N 책들이 꽂히게 함
        for(int i=1; i<N; i++){
            bs[1].addLast(new Node(i));
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            switch(command){
                case 1:
                    if(bs[i].head != null){
                        Node n = bs[i].removeFirst();
                        bs[j].addLast(n);
                    }
                    break;

                case 2:
                    if(bs[i].head != null){
                        Node n = bs[i].removeLast();
                        bs[j].addFirst(n);
                    }
                    break;

                case 3:
                    if(i!=j) bs[i].moveToFront(bs[j]);
                    break;

                case 4:
                    if(i!=j) bs[i].moveToBack(bs[j]);
                    break;
            }
        }

        for(int i=1; i<K; i++){
            Node current = bs[i].head;
            int count = 0;
            StringBuilder tmp = new StringBuilder();

            while (current != null) {
                tmp.append(" ").append(current.data);
                count++;
                current = current.next;
            }

            sb.append(count + tmp.toString() + "\n");
        }

        System.out.println(sb);
    }
}