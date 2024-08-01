import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, y, v, idx;

    public Point(int x, int y, int v, int idx){
        this.x = x;
        this.y = y;
        this.v = v;
        this.idx = idx;
    }

    public int compareTo(Point p){
        return this.x - p.x;
    }
}

class Element implements Comparable<Element> {
    int y, idx;

    public Element(int y, int idx) {
        this.y = y;
        this.idx = idx;
    }

    public int compareTo(Element e) {
        return this.y - e.y;        
    }
}

public class Main {
    static int N, ans;
    static boolean visible[];
    static List<Point> list = new ArrayList<>();
    static TreeSet<Element> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visible = new boolean[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            list.add(new Point(x1, y, +1, i));
            list.add(new Point(x2, y, -1, i));
        }

        Collections.sort(list);

        solve();

        System.out.println(ans);
    }

    static void solve(){
        // 모든 선분 체크
        for(Point p : list){

            // 삽입할 때
            if(p.v == +1){
                set.add(new Element(p.y, p.idx));
            }

            // 제거할 때
            else{
                set.remove(new Element(p.y, p.idx));
            }

            // 마지막 선분이라면
            if(set.isEmpty()) continue;

            // 보이는 선분의 idx true 체크
            visible[set.first().idx] = true;
        }

        // 보였던 선분 체크
        for(boolean i : visible){
            if(i) ans++;
        }
    }
}