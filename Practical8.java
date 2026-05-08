import java.util.Scanner;
class KruskalMST {
    static int[] parent = new int[10];
    static int find(int i) {
        while (parent[i] != 0)
            i = parent[i];
        return i;
    }
    static void union(int i, int j) {
        parent[j] = i;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, mincost = 0;
        int[][] cost = new int[10][10];

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

        int ne = 1;

        while (ne < n) {
            int min = 999;
            int a = 0, b = 0, u = 0, v = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }

            u = find(u);
            v = find(v);

            if (u != v) {
                System.out.println(ne + " Edge (" + a + "," + b + ") = " + min);
                mincost += min;
                union(u, v);
                ne++;
            }

            cost[a][b] = cost[b][a] = 999;
        }

        System.out.println("Minimum cost = " + mincost);
    }
}
