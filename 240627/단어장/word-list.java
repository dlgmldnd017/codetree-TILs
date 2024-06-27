import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i=0; i<n; i++){
            String input = br.readLine();

            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            sb.append(entry.getKey() + " " + entry.getValue()+"\n");
        }

        System.out.print(sb);
    }
}