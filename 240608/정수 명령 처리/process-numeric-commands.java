import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Stack<Integer> stack = new Stack<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        solve();
    }

    static void solve() throws Exception {
        for(int i=0; i<N; i++){
            String command = "";
        int input = 0;

        st = new StringTokenizer(br.readLine());

        if(st.countTokens() == 2){
            command = st.nextToken();
            input = Integer.parseInt(st.nextToken());
        }
        
        else{
            command = st.nextToken();
        }

        switch(command){
            case "push":
                stack.push(input);
                break;
            
            case "pop":
                System.out.println(stack.pop());
                break;
            
            case "size":
                System.out.println(stack.size());
                break;

            case "empty":
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
                break;

            case "top":
                System.out.println(stack.peek());
                break;
        }
        }
    }
}