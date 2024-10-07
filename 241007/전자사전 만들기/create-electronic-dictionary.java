import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Word implements Comparable<Word> {
    String word;
    int idx;

    public Word(String word, int idx) {
        this.word = word;
        this.idx = idx;
    }

    public int compareTo(Word w) {
        return this.word.compareTo(w.word);
    }
}

public class Main {
    static int N, T;
    static List<Word> list = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            list.add(new Word(str, i));
        }

        Collections.sort(list);

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String query = st.nextToken();

            solve(k, query);
        }

        System.out.println(sb);
    }

    static void solve(int k, String query) {
        int start = lowerBound(query);
        int end = upperBound(query);

        if (start + k - 1 < end) sb.append(list.get(start + k - 1).idx + "\n");
        else sb.append(-1 + "\n");
    }

    static int lowerBound(String query) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid).word.startsWith(query)) high = mid;
            else if (list.get(mid).word.compareTo(query) < 0) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    static int upperBound(String query) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid).word.startsWith(query)) low = mid + 1;
            else if (list.get(mid).word.compareTo(query) > 0) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}