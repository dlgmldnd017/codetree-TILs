import java.util.*;
import java.io.*;

class ComePerson implements Comparable<ComePerson>{
    int num, a, t;

    public ComePerson(int num, int a, int t){
        this.num = num;
        this.a = a;
        this.t = t;
    }

    public int compareTo(ComePerson cp){
        if(this.a == cp.a) return this.num - cp.num;
        return this.a - cp.a;
    }
}

class WaitPerson implements Comparable<WaitPerson>{
    int num, a, t;

    public WaitPerson(int num, int a, int t){
        this.num = num;
        this.a = a;
        this.t = t;
    }

    public int compareTo(WaitPerson wp){
        return this.num - wp.num;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 오는 손님들 리스트
        ComePerson cp[] = new ComePerson[N+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            cp[i] = new ComePerson(i, a, t);
        }

        cp[N] = new ComePerson(N, Integer.MAX_VALUE, 0);

        Arrays.sort(cp);

        // 대기하는 손님들 리스트
        PriorityQueue<WaitPerson> pq = new PriorityQueue<>();

        int ans = Integer.MIN_VALUE;
        int exitTime = 0;

        for(int i=0; i<=N; i++){
            int num = cp[i].num;
            int a = cp[i].a;
            int t = cp[i].t;

            while(a >= exitTime && !pq.isEmpty()){
                WaitPerson wp = pq.poll();
                
                ans = Math.max(ans, exitTime-wp.a);

                exitTime += wp.t;

            }

            if(a >= exitTime){
                exitTime = a + t;
            }

            else{
                pq.add(new WaitPerson(num, a, t));
            }
        }

        System.out.println(ans);
    }
}