import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int y, x;

    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    
    static TreeSet<Point> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Point(y, x));
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            NavigableSet<Point> ns = set.subSet(new Point(y1, x1), true, new Point(y2, x2), true);

            int cnt=0;
            for(Point p : ns){
                if(p.y>=y1 && p.y<=y2) cnt++;
            }

            sb.append(cnt+"\n");
        }

        System.out.println(sb);
    }
}