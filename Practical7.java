import java.util.Scanner;
class PrimMST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, min, a = 0, b = 0, u = 0, v = 0;
        int mincost = 0;
        int[][] cost = new int[10][10];
        int[] visited = new int[10];
        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();
        System.out.println("Enter cost matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();

                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }

        visited[1] = 1;

        for (int ne = 1; ne < n; ) {
            min = 999;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        if (visited[i] != 0) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if (visited[u] == 0 || visited[v] == 0) {
                System.out.println(ne + " Edge (" + a + "," + b + ") = " + min);
                mincost += min;
                visited[b] = 1;
                ne++;
            }

            cost[a][b] = cost[b][a] = 999;
        }

        System.out.println("Minimum cost = " + mincost);
    }
}
