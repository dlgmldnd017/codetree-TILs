import java.util.*;
import java.io.*;

public class Main {
    static String input = "";
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        System.out.println(solve());
    }

    static String solve() {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return "No";
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? "Yes" : "No";
    }
}