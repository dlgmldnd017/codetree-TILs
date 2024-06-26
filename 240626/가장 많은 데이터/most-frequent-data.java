import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        int max=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            String input = br.readLine();

            if(map.containsKey(input)) map.put(input, map.get(input) + 1);
            else map.put(input, 1);

            max = Math.max(max, map.get(input));
        }

        System.out.println(max);
    }
}