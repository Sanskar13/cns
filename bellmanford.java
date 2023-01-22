import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == src)
                dist[i] = 0;
            else
                dist[i] = 999;
        }

        for (int k = 0; k < n - 1; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] != 999 && dist[i] + cost[i][j] < dist[j]) {
                        dist[j] = cost[i][j] + dist[i];
                    }
                }
            }
        }
        for (int val : dist)
            System.out.print(val + " ");
        System.out.println();

    }
}
