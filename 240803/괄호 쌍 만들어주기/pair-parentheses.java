import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> openPositions = new ArrayList<>();
        List<Integer> closePositions = new ArrayList<>();

        // 연속된 여는 괄호와 닫는 괄호의 위치 저장
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '(' && input.charAt(i + 1) == '(') {
                openPositions.add(i);
            } else if (input.charAt(i) == ')' && input.charAt(i + 1) == ')') {
                closePositions.add(i);
            }
        }

        int openSize = openPositions.size();
        int closeSize = closePositions.size();

        // 전처리 작업: 각 위치에서 이후에 나온 닫는 괄호의 수를 저장
        int[] closeCountFromEnd = new int[input.length() + 1];
        for (int i = closeSize - 1; i >= 0; i--) {
            closeCountFromEnd[closePositions.get(i)] = 1;
        }
        for (int i = input.length() - 2; i >= 0; i--) {
            closeCountFromEnd[i] += closeCountFromEnd[i + 1];
        }

        int result = 0;
        // 가능한 쌍 찾기: 여는 괄호 위치에서 이후의 닫는 괄호의 수를 더함
        for (int openPos : openPositions) {
            if (openPos + 2 < input.length()) {
                result += closeCountFromEnd[openPos + 2];
            }
        }

        System.out.println(result);
    }
}