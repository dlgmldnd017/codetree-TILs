import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int x, y;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());

                    map.put(x, y);
                    break;
                
                case "find":
                    x = Integer.parseInt(st.nextToken());

                    if(map.containsKey(x)) System.out.println(map.get(x));
                    else System.out.println("None");
                    break;
                
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    map.remove(x);
                    break;

                case "print_list":
                    if(map.size() == 0){
                        System.out.println("None");
                    }
                    else{
                        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                            System.out.print(entry.getValue() + " ");
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}