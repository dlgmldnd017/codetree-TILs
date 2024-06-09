import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = "";
            int input = 0;

            if (st.countTokens() == 2) {
                command = st.nextToken();
                input = Integer.parseInt(st.nextToken());
            } else {
                command = st.nextToken();
            }

            switch (command) {
                case "push_front":
                    dq.addFirst(input);
                    break;

                case "push_back":
                    dq.addLast(input);
                    break;

                case "pop_front":
                    System.out.println(dq.pollFirst());
                    break;

                case "pop_back":
                    System.out.println(dq.pollLast());
                    break;

                case "size":
                    System.out.println(dq.size());
                    break;

                case "empty":
                    if (dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;

                case "front":
                    System.out.println(dq.peekFirst());
                    break;

                case "back":
                    System.out.println(dq.peekLast());
                    break;
            }
        }
    }
}