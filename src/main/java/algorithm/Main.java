package algorithm;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N, M;
        String[] size = reader.readLine().split(" ");
        N = Integer.valueOf(size[0]);
        M = Integer.valueOf(size[1]);
        int[][] table = new int[N][M];
        Map<Integer, Integer> cell = new HashMap();
        for(int i = 0; i<N; i++) {
            size = reader.readLine().split(" ");
            for(int j = 0; j<M; j++) {
                table[i][j] = Integer.valueOf(size[j]);
                System.out.println("i is " + i);
                System.out.println("j is " + j);
                System.out.println("i*M+j-1 is " + (i*M+j-1));
                System.out.println("i*M+j-M is " + (i*M+j-M));
                if(i!=0 && j!=0) {
                    System.out.println("cell(i*M+j-1) is " + cell.get(i * M + j - 1));
                    System.out.println("cell(i*M+j-M) is " + cell.get(i * M + j - M));
                }
                cell.put(i*M+j, table[i][j] + (i==0 && j!=0 ? cell.get(j-1):
                        i!=0 && j==0 ? cell.get(M*i-M):
                                i!=0 && j!=0? Math.min(cell.get(i*M+j-1), cell.get(i*M+j-M)): 0));
            }
        }
        writer.write(String.valueOf(cell.get(N*M-1)));

        reader.close();
        writer.close();

//        1 1 1 1 1
//        3 100 100 100 100
//        1 1 1 1 1
//        2 2 2 2 1
//        1 1 1 1 1
    }
}