import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        char[] B = new char[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextLine().charAt(0);
        }

        int maxWins = 0;

        // 모든 가능한 전환점을 K에 대해 계산
        for (int K = 0; K <= N; K++) {
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'H', 'S')); // 주먹 -> 가위
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'H', 'P')); // 주먹 -> 보자기
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'S', 'H')); // 가위 -> 주먹
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'S', 'P')); // 가위 -> 보자기
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'P', 'H')); // 보자기 -> 주먹
            maxWins = Math.max(maxWins, calculateWins(B, N, K, 'P', 'S')); // 보자기 -> 가위
        }

        System.out.println(maxWins);
    }

    private static int calculateWins(char[] B, int N, int K, char firstMove, char secondMove) {
        int wins = 0;
        for (int i = 0; i < K; i++) {
            wins += winCount(firstMove, B[i]);
        }
        for (int i = K; i < N; i++) {
            wins += winCount(secondMove, B[i]);
        }
        return wins;
    }

    private static int winCount(char A, char B) {
        if (A == 'H' && B == 'S') return 1;
        if (A == 'S' && B == 'P') return 1;
        if (A == 'P' && B == 'H') return 1;
        return 0;
    }
}