import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, prefixA[][], prefixB[][], prefixC[][];
    static char arr[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken())+1;
        m = Integer.parseInt(st.nextToken())+1;
        k = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for(int i=1; i<n; i++){
            String input = br.readLine();

            for(int j=1; j<m; j++){
                arr[i][j] = input.charAt(j-1);
            }
        }

        prefixA = new int[n][m];
        calcPrefix('a');

        prefixB = new int[n][m];
        calcPrefix('b');

        prefixC = new int[n][m];
        calcPrefix('c');

        for(int q=0; q<k; q++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append(getAreaCnt(prefixA, r1, c1, r2, c2) + " ");
            sb.append(getAreaCnt(prefixB, r1, c1, r2, c2) + " ");
            sb.append(getAreaCnt(prefixC, r1, c1, r2, c2) + "\n");
        }
        
        System.out.println(sb);
    }

    static void calcPrefix(char c){
        int prefix[][] = new int[n][m];

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + (arr[i][j]==c? 1 : 0);     
            }
        }

        switch(c){
            case 'a':
                prefixA = prefix;
                break;
            
            case 'b':
                prefixB = prefix;
                break;

            case 'c':
                prefixC = prefix;
                break;
        }
    }

    static int getAreaCnt(int prefix[][], int x1, int y1, int x2, int y2){
        return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
    }
}