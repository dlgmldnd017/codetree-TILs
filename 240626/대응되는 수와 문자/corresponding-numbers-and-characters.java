import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> sMap = new HashMap<>();
        HashMap<String, String> iMap = new HashMap<>();

        for(int i=0; i<n; i++){
            String input = br.readLine();

            sMap.put(input, (i+1)+"");
            iMap.put((i+1)+"", input);
        }

        for(int i=0; i<m; i++){
            String input = br.readLine();

            if(sMap.containsKey(input)){
                System.out.println(sMap.get(input));
            }else{
                System.out.println(iMap.get(input));
            }
        }
    }
}