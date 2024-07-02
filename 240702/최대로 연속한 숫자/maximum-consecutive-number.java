import java.util.*;

public class Main {
    static int[] parent;
    static int[] size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] toRemove = new int[m];
        for (int i = 0; i < m; i++) {
            toRemove[i] = scanner.nextInt();
        }

        // 초기화
        parent = new int[n + 1];
        size = new int[n + 1];
        Arrays.fill(size, 1);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        TreeSet<Integer> numbers = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            numbers.add(i);
        }

        // 각 숫자를 제거하면서 최장 연속 수열 길이 계산
        for (int i = 0; i < m; i++) {
            numbers.remove(toRemove[i]);
            if (numbers.isEmpty()) {
                System.out.println(0);
                continue;
            }

            // Union-Find를 사용하여 최장 연속 수열 길이 계산
            for (int num : numbers) {
                if (numbers.contains(num - 1)) {
                    union(num - 1, num);
                }
                if (numbers.contains(num + 1)) {
                    union(num, num + 1);
                }
            }

            int maxLength = 0;
            for (int num : numbers) {
                maxLength = Math.max(maxLength, size[find(num)]);
            }
            System.out.println(maxLength);

            // 제거된 숫자를 복원
            for (int num : numbers) {
                parent[num] = num;
                size[num] = 1;
            }
        }

        scanner.close();
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}