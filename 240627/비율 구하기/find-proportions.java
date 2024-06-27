import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double n = Double.parseDouble(br.readLine());
        
        TreeMap<String, Double> map = new TreeMap<>();

        double defaultValue = (1.0/n) * 100;

        for(int i=0; i<n; i++){
            String input = br.readLine();

            map.put(input, map.getOrDefault(input, 0.0) + defaultValue);
        }

        for(Map.Entry<String, Double> entry : map.entrySet()){
            System.out.printf("%s %.4f\n", entry.getKey(), entry.getValue());
        }
    }
}