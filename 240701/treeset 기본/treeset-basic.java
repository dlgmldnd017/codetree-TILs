import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x;

            switch(command){
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    set.add(x);
                    break;

                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    set.remove(x);
                    break;   
                
                case "find":
                    x = Integer.parseInt(st.nextToken());
                    if(set.contains(x)) sb.append("true\n");
                    else sb.append("false\n");
                    break;

                case "lower_bound":
                    x = Integer.parseInt(st.nextToken());
                    if(set.ceiling(x) == null) sb.append("None\n");
                    else sb.append(set.ceiling(x)+"\n");
                    break;

                case "upper_bound":
                    x = Integer.parseInt(st.nextToken());
                    if(set.higher(x) == null) sb.append("None\n");
                    else sb.append(set.higher(x)+"\n");
                    break;

                case "largest":
                    if(set.isEmpty()) sb.append("None\n");
                    else sb.append(set.last()+"\n");
                    break;

                case "smallest":
                    if(set.isEmpty()) sb.append("None\n");
                    else sb.append(set.first()+"\n");
                    break;
            }
        }
        
        System.out.println(sb);
    }
}