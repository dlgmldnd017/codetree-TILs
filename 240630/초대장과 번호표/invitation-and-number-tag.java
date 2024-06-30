import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int G = Integer.parseInt(st.nextToken());

        List<Set<Integer>> groups = new ArrayList<>();

        for(int i=0; i<G; i++){
            st = new StringTokenizer(br.readLine());
            int groupSize = Integer.parseInt(st.nextToken());

            Set<Integer> group = new HashSet<>();

            for(int j=0; j<groupSize; j++){
                group.add(Integer.parseInt(st.nextToken()));
            }

            groups.add(group);
        }

        Set<Integer> invited = new HashSet<>();
        invited.add(1);

        boolean changed;

        do{
            changed = false;

            for(Set<Integer> group : groups){
                long count = group.stream().filter(invited::contains).count();
                
                
                if (count == group.size() - 1) {
                    for (int person : group) {
                        if (!invited.contains(person)) {
                            invited.add(person);
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);
        
        System.out.println(invited.size());
    }
}