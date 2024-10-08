import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Word implements Comparable<Word> {
    String word;
    int idx;

    Word(String word, int idx) {
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();

            list.add(new Word(input, i));
        }

        Collections.sort(list);

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            solve(k - 1, str);
        }

        System.out.println(sb);
    }

    static void solve(int k, String str) {
        int start = lowBoundary(str);
        int end = highBoundary(str);

        // System.out.println(start + " : " + end);

        if (start + k < end) sb.append(list.get(start + k).idx);
        else sb.append(-1);

        sb.append("\n");
    }

    static int lowBoundary(String str) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid).word.startsWith(str)) high = mid;
            else if (list.get(mid).word.compareTo(str) < 0) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    static int highBoundary(String str) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;

            if (list.get(mid).word.startsWith(str)) low = mid + 1;
            else if (list.get(mid).word.compareTo(str) > 0) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}