import java.util.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int sum;
        int i, j;
        
        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
        
        public int compareTo(Pair other) {
            return this.sum - other.sum;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Pair(arr1[i] + arr2[0], i, 0));
        }
        
        Pair current = null;
        for (int count = 0; count < k; count++) {
            current = minHeap.poll();
            int i = current.i;
            int j = current.j;
            
            if (j + 1 < m) {
                minHeap.offer(new Pair(arr1[i] + arr2[j + 1], i, j + 1));
            }
        }
        
        System.out.println(current.sum);
        
        sc.close();
    }
}