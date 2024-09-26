import java.util.*;
import java.io.*;

public class Main {
    static int N, ans;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }

        solve(0, new ArrayList<>());

        System.out.println(ans);
    }

    static void solve(int depth, List<String> selected){
        if (depth == N) {
            if (check(selected)) ans = Math.max(ans, selected.size());
            return;
        }

        selected.add(list.get(depth));
        solve(depth+1, selected);

        selected.remove(selected.size()-1);
        solve(depth+1, selected);
    }

    static boolean check(List<String> selected){ 
        int maxLength = 0;
        
        for (String num : selected) {
            maxLength = Math.max(maxLength, num.length());
        }
        
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int sum = 0;
            for (String num : selected) {
                if (num.length() > i) {
                    sum += num.charAt(num.length() - 1 - i) - '0';
                }
            }
            if (sum >= 10) return false;
        }
        return true;
    }
}