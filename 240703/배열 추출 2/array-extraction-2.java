import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num, abs;

    public Node(int num, int abs){
        this.num = num;
        this.abs = abs;
    }

    @Override
    public int compareTo(Node n){
        if(this.abs == n.abs) return this.num - n.num;

        return this.abs - n.abs;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll().num+"\n");
            }

            else{
                pq.add(new Node(x, Math.abs(x)));
            }
        }

        System.out.println(sb);
    }
}