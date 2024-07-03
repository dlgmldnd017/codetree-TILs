import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num, a, t;

    public Node(int num, int a, int t){
        this.num = num;
        this.a = a;
        this.t = t;
    }

    @Override
    public int compareTo(Node n){
        if(this.a != n.a) return this.a - n.a;
        return this.num - n.num;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        PriorityQueue<Node> pq2 = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq1.add(new Node(i, a, t));
        }

        int ans = Integer.MIN_VALUE;
        int curTime = pq1.peek().a;

        while(!pq1.isEmpty()){

            // 먼저, curTime 아래에 도착한 사람들을 뽑는다.
            while(!pq1.isEmpty() && pq1.peek().a <= curTime){
                pq2.add(pq1.poll());
            }

            if(!pq1.isEmpty() && pq2.size()==0){
                pq2.add(pq1.poll());
            }

            if(pq2.size()==1){
                Node n = pq2.poll();

                ans = Math.max(ans, curTime-n.a);
                if(curTime - n.a > 0) curTime = n.a + n.t;
                else curTime += n.t;
            }

            else{
                while(pq2.size() > 1){
                    Node n1 = pq2.poll();
                    Node n2 = pq2.poll();

                    if(n1.num > n2.num){
                        pq1.add(n1);
                        pq2.add(n2);
                    }

                    else{
                        pq1.add(n2);
                        pq2.add(n1);
                    }
                }

                Node cur = pq2.poll();
                ans = Math.max(ans, curTime-cur.a);
                curTime += cur.t;
            }
        }

        System.out.println(ans);
    }
}