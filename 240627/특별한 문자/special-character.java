import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char ans = ' ';
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }

        if(ans == ' ') System.out.println("None");
        else System.out.println(ans);
    }
}