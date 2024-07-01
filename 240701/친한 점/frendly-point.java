import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p){
        if(this.x != p.x) return this.x - p.x;
        else return this.y - p.y;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<Point> set = new TreeSet<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(new Point(x, y));
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Point p = set.ceiling(new Point(x, y));
            if(p==null) sb.append("-1 -1\n");
            else sb.append(p.x + " " + p.y + "\n");
        }

        System.out.println(sb);
    }
}