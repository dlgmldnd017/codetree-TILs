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
        
        // 전처리 작업: 각 위치에서 이전에 나온 닫는 괄호의 수를 저장
        int[] closeCount = new int[input.length()];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (i > 0) {
                closeCount[i] = closeCount[i - 1];
            }
            if (i < input.length() - 1 && input.charAt(i) == ')' && input.charAt(i + 1) == ')') {
                closeCount[i]++;
            }
        }
        
        int result = 0;
        // 가능한 쌍 찾기: 여는 괄호 위치에서 이후의 닫는 괄호의 수를 더함
        for (int openPos : openPositions) {
            result += closeCount[input.length() - 1] - closeCount[openPos + 1];
        }
        
        System.out.println(result);
    }
}