import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
            queries[i][3] = sc.nextInt();
        }

        int[] results = new int[q];
        for (int i = 0; i < q; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (isInRange(points[j], queries[i])) {
                    count++;
                }
            }
            results[i] = count;
        }

        for (int result : results) {
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }

    private static boolean isInRange(int[] point, int[] query) {
        int x = point[0];
        int y = point[1];
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        return x1 <= x && x <= x2 && y1 <= y && y <= y2;
    }
}