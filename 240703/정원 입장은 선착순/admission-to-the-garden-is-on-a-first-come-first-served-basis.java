import java.util.*;
import java.io.*;

class Node1 implements Comparable<Node1>{
    int num, a, t;

    public Node1(int num, int a, int t){
        this.num = num;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(Node1 n){
        if(this.a != n.a) return this.a - n.a;
        return this.num - n.num;
    }
}

class Node2 implements Comparable<Node2>{
    int num, a, t;

    public Node2(int num, int a, int t){
        this.num = num;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(Node2 n){
        return this.num - n.num;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Node1> pq = new PriorityQueue<>();
        PriorityQueue<Node2> pq2 = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.add(new Node1(i, a, t));
        }

        int ans = Integer.MIN_VALUE;
        int curTime = 0;

        while(!pq.isEmpty()){
            Node1 n1 = pq.poll();

            while(!pq.isEmpty() && pq.peek().a <= curTime){
                Node1 n = pq.poll();

                pq2.add(new Node2(n.num, n.a, n.t));
            }

            if(pq2.size()!=0){
                pq2.add(new Node2(n1.num, n1.a, n1.t));

                Node2 cur = pq2.poll();
                ans = Math.max(ans, curTime-cur.a);
                
                curTime += cur.t;

                while(!pq2.isEmpty()){
                    Node2 n = pq2.poll();
                    pq.add(new Node1(n.num, n.a, n.t));
                }
            }

            else{
                ans = Math.max(ans, curTime-n1.a);
                curTime = n1.a + n1.t;
                if(ans<0) ans = 0;
            }
        }

        System.out.println(ans);
    }
}