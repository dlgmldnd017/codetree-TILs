import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple>{
    int len, start, end;

    public Tuple(int len, int start, int end){
        this.len = len;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Tuple t){
        if(t.len != this.len) return t.len - this.len;
        else if(this.start != this.start) return this.start - t.start;
        else return this.end - t.end;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static TreeSet<Integer> sNum = new TreeSet<>();
    static TreeSet<Tuple> set = new TreeSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        sNum.add(-1);
        sNum.add(n+1);

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int y = Integer.parseInt(st.nextToken());
            
            sNum.add(y);

            int x = sNum.lower(y);
            int z = sNum.higher(y);

            set.remove(new Tuple(z-x-1, x, z));
            set.add(new Tuple(y-x-1, x, y));
            set.add(new Tuple(z-y-1, y, z));

            sb.append(set.first().len+"\n");
        }
        
        System.out.println(sb);
    }
}