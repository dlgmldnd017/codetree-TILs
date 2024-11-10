import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, T, k;
    static String map[], str;
    static Map<String, Integer> mapping = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
            mapping.put(map[i], i + 1);
        }

        Arrays.sort(map);

//        System.out.println(Arrays.toString(map));

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken()) - 1;
            str = st.nextToken();

            solve();
        }

        System.out.println(sb);
    }

    static void solve() {
        int low = getLowerBoundary();
        int high = getHigherBoundary();

        low += k;

        if (low > high) sb.append("-1\n");
        else sb.append(mapping.get(map[low]) + "\n");
    }

    static int getLowerBoundary() {
        int low = 0, high = N - 1, idx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (map[mid].startsWith(str)) {
                high = mid - 1;
                idx = mid;
            } else if (map[mid].compareTo(str) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }

    static int getHigherBoundary() {
        int low = 0, high = N - 1, idx = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (map[mid].startsWith(str)) {
                low = mid + 1;
                idx = mid;
            } else if (map[mid].compareTo(str) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }
}