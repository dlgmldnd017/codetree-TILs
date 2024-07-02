import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, y, len;

    public Point(int x, int y, int len){
        this.x = x;
        this.y = y;
        this.len = len;
    }

    @Override
    public int compareTo(Point p){
        if(this.len != p.len) return this.len-p.len;
        else if(this.x != p.x) return this.x - p.x;
        else return this.y - p.y;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int len = x + y;
            
            pq.add(new Point(x, y, len));
        }

        for(int i=0; i<m; i++){
            Point p = pq.poll();

            p.x += 2;
            p.y += 2;
            p.len = p.x + p.y;

            pq.add(new Point(p.x, p.y, p.len));
        }
        
        Point p = pq.poll();
        System.out.println(p.x + " " + p.y);
    }
}