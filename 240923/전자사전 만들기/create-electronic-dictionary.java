import java.util.*;
import java.io.*;

class Word implements Comparable<Word>{
    String word;
    int idx;

    public Word(String word, int idx){
        this.word = word;
        this.idx = idx;
    }

    public int compareTo(Word w){
        return this.word.compareTo(w.word);
    }
}

public class Main{
    static int N, T;
    static List<Word> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            String str = br.readLine();
            list.add(new Word(str, i+1));
        }

        Collections.sort(list);

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String query = st.nextToken();

            int start = lowerBound(query);
            int end = upperBound(query);

            if(start+k-1 < end) sb.append(list.get(start+k-1).idx + "\n");
            else sb.append(-1+"\n");
        }

        System.out.println(sb);
    }

    static int lowerBound(String query){
        int low=0, high=list.size();

        while(low<high){
            int mid = (low+high)/2;

            if(list.get(mid).word.startsWith(query)) high = mid;
            else if(list.get(mid).word.compareTo(query) < 0) low = mid+1;
            else high = mid;
        }

        return low;
    }

    static int upperBound(String query){
        int low=0, high=list.size();

        while(low<high){
            int mid = (low+high)/2;

            if(list.get(mid).word.startsWith(query)) low = mid+1;
            else if(list.get(mid).word.compareTo(query) > 0) high = mid;
            else low = mid+1;
        }

        return low;
    }
}