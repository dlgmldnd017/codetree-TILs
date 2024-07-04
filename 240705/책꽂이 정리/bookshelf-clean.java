import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 책의 개수 N과 책꽂이의 개수 K를 입력 받음
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각 책꽂이를 저장할 리스트 배열 생성
        List<Deque<Integer>> bookshelves = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bookshelves.add(new LinkedList<>());
        }

        // 처음에 모든 책이 1번 책꽂이에 순서대로 꽂혀 있음
        for (int i = 1; i <= N; i++) {
            bookshelves.get(0).add(i);
        }

        // 연산 횟수 Q를 입력 받음
        int Q = Integer.parseInt(br.readLine());

        // 각 연산을 처리
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            switch (operation) {
                case 1:
                    // i번 책꽂이의 맨 앞 책을 j번 책꽂이의 맨 뒤에 꽂음
                    if (!bookshelves.get(i).isEmpty()) {
                        bookshelves.get(j).addLast(bookshelves.get(i).removeFirst());
                    }
                    break;
                case 2:
                    // i번 책꽂이의 맨 뒷 책을 j번 책꽂이의 맨 앞에 꽂음
                    if (!bookshelves.get(i).isEmpty()) {
                        bookshelves.get(j).addFirst(bookshelves.get(i).removeLast());
                    }
                    break;
                case 3:
                    // i번 책꽂이의 책을 모두 j번 책꽂이의 맨 앞으로 옮김
                    if (!bookshelves.get(i).isEmpty()) {
                        Deque<Integer> temp = new LinkedList<>();
                        while (!bookshelves.get(i).isEmpty()) {
                            temp.addFirst(bookshelves.get(i).removeLast());
                        }
                        while (!temp.isEmpty()) {
                            bookshelves.get(j).addFirst(temp.removeFirst());
                        }
                    }
                    break;
                case 4:
                    // i번 책꽂이의 책을 모두 j번 책꽂이의 맨 뒤로 옮김
                    if (!bookshelves.get(i).isEmpty()) {
                        while (!bookshelves.get(i).isEmpty()) {
                            bookshelves.get(j).addLast(bookshelves.get(i).removeFirst());
                        }
                    }
                    break;
            }
        }

        // 최종 상태 출력
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            sb.append(bookshelves.get(k).size());
            for (int book : bookshelves.get(k)) {
                sb.append(" ").append(book);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}