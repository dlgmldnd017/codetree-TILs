import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        String initial = scanner.next();
        String target = scanner.next();

        // 초기 변수 설정
        int count = 0;
        boolean inSegment = false;

        // 초기 문자열과 목표 문자열을 비교하면서 구간 계산
        for (int i = 0; i < N; i++) {
            if (initial.charAt(i) != target.charAt(i)) {
                if (!inSegment) {
                    count++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}