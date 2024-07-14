import java.util.*;
import java.io.*;

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static int preifxSum[][];

    static Point p[];

    static TreeSet<Integer> set = new TreeSet<>();
    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        p = new Point[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            set.add(x);
            set.add(y);

            p[i] = new Point(x, y);
        }

        int cnt=1;
        for(Integer i : set){
            map.put(i, cnt++);
        }

        preifxSum = new int[5002][5002];

        for(Point i : p){
            int x = map.get(i.x);
            int y = map.get(i.y);

            preifxSum[x][y]++;
        }

        for(int i=1; i<=cnt; i++){
            for(int j=1; j<=cnt; j++){
                preifxSum[i][j] += preifxSum[i][j-1] + preifxSum[i-1][j] - preifxSum[i-1][j-1];
            }
        }

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            x1 = getCeilingValue(x1);
            y1 = getCeilingValue(y1);
            x2 = getFlooringValue(x2);
            y2 = getFlooringValue(y2);

            sb.append(getSum(x1, y1, x2, y2)+"\n");
        }

        System.out.println(sb);
    }

    static int getCeilingValue(int x){
        if(set.ceiling(x) != null){
            int newX = set.ceiling(x);
            return map.get(newX);
        } 
        
        return set.size()+1;
    }

    static int getFlooringValue(int x){
        if(set.floor(x) != null) {
            int newX = set.floor(x);
            return map.get(newX);
        }

        return 0;
    }

    static int getSum(int x1, int y1, int x2, int y2){
        return preifxSum[x2][y2] - preifxSum[x1-1][y2] - preifxSum[x2][y1-1] + preifxSum[x1-1][y1-1];
    }
}