import java.util.*;
import java.io.*;

public class Main {
    static String input = "";
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        System.out.println(solve());
    }

    static String solve(){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
            }

            else if(input.charAt(i) == ')'){
                if(stack.isEmpty() || stack.peek() == '(') stack.pop();
                else return "No";
            }
        }

        if(stack.size() == 0) return "Yes";
        else return "No";
    }
}