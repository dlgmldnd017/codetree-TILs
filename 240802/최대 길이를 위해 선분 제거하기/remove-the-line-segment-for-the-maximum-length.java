import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, v, idx;

    public Point(int x, int v, int idx){
        this.x = x;
        this.v = v;
        this.idx = idx;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

public class Main {
    static int N, total, prevX, minLength, weight[], ans;
    static List<Point> list = new ArrayList<>();
    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weight = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            list.add(new Point(x1, +1, i));
            list.add(new Point(x2, -1, i));
        }

        Collections.sort(list);

        total=0;
        prevX=-1;
        minLength = Integer.MAX_VALUE;

        solve();

        System.out.println(ans);
    }

    static void solve(){
        for(Point p : list){
            if(set.size()>0){
                total += p.x - prevX;
            }

            if(set.size()==1){
                int targetIdx = set.first();
                weight[targetIdx] = p.x - prevX;
            }

            if(p.v == +1){
                set.add(p.idx);
            }
            else{
                set.remove(p.idx);
            }

            prevX = p.x;
        }

        for(int i=1; i<=N; i++){
            minLength = Math.min(minLength, weight[i]);
        }

        ans = total - minLength;
    }
}