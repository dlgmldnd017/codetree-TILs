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
        if(this.len != p.len) return this.len - p.len;
        else if(this.x != p.x) return this.x - p.x;
        else return this.y - p.y;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken())+1;
        int m = Integer.parseInt(st.nextToken())+1;
        int k = Integer.parseInt(st.nextToken());

        int arr1[] = new int[n];
        int arr2[] = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=1; i<n; i++){
            pq.add(new Point(i,1,arr1[i]+arr2[1]));
        }

        for(int i=0; i<k-1; i++){
            Point p = pq.poll();

            int x = p.x;
            int y = p.y+1;

            if(y < m) pq.add(new Point(x, y, arr1[x] + arr2[y]));
        }
        
        System.out.println(pq.peek().len);
    }
}