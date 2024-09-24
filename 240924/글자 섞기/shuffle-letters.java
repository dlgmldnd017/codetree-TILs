import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class WordEntry {
    String str;
    int idx;
    boolean isRev;

    WordEntry(String str, int idx, boolean isRev) {
        this.str = str;
        this.idx = idx;
        this.isRev = isRev;
    }
}

public class Main {
    static int NMAX = 5000;
    static String[] words = new String[NMAX];
    static WordEntry[] entries = new WordEntry[NMAX * 2];
    static int[] lowest = new int[NMAX];
    static int[] highest = new int[NMAX];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        solve(N);

        for (int i = 0; i < N; i++) {
            System.out.println(lowest[i] + " " + highest[i]);
        }
    }

    static void solve(int N) {
        for (int i = 0; i < N; i++) {
            char[] sortedWord = words[i].toCharArray();
            Arrays.sort(sortedWord);
            String sortedStr = new String(sortedWord);

            entries[2 * i] = new WordEntry(sortedStr, i, false);
            entries[2 * i + 1] = new WordEntry(new StringBuilder(sortedStr).reverse().toString(), i, true);
        }

        Arrays.sort(entries, 0, 2 * N, new Comparator<WordEntry>() {
            @Override
            public int compare(WordEntry o1, WordEntry o2) {
                if (o1.str.equals(o2.str)) return Boolean.compare(o1.isRev, o2.isRev);
                return o1.str.compareTo(o2.str);
            }
        });

        int revCount = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (entries[i].isRev) {
                revCount++;
            } else {
                int idx = entries[i].idx;
                lowest[idx] = revCount + 1;
            }
        }

        int fwdCount = 0;
        for (int i = 2 * N - 1; i >= 0; i--) {
            if (!entries[i].isRev) {
                fwdCount++;
            } else {
                int idx = entries[i].idx;
                highest[idx] = N - fwdCount;
            }
        }
    }
}