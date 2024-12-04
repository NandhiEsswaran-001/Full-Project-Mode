import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.runDistanceVectorRouting();
    }

    public void runDistanceVectorRouting() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();
        
        int[][] distance = new int[n][n];
        int[][] nextHop = new int[n][n];

        System.out.println("Enter the cost matrix (Enter 999 for infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = sc.nextInt();
                nextHop[i][j] = (i == j || distance[i][j] == 999) ? -1 : j;
            }
        }

        // Distance Vector Algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        nextHop[i][j] = nextHop[i][k];
                    }
                }
            }
        }

        System.out.println("\nDistance Vector Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((distance[i][j] == 999 ? "INF" : distance[i][j]) + "\t");
            }
            System.out.println();
        }

        System.out.println("\nNext Hop Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((nextHop[i][j] == -1 ? "-" : nextHop[i][j]) + "\t");
            }
            System.out.println();
        }

        System.out.print("\nEnter source node: ");
        int source = sc.nextInt();

        System.out.print("Enter destination node: ");
        int destination = sc.nextInt();

        if (distance[source][destination] == 999) {
            System.out.println("No path exists between node " + source + " and node " + destination);
        } else {
            System.out.println("Shortest Path Cost: " + distance[source][destination]);
            System.out.print("Path: " + source);
            int next = nextHop[source][destination];
            while (next != -1 && next != destination) {
                System.out.print(" -> " + next);
                next = nextHop[next][destination];
            }
            System.out.println(" -> " + destination);
        }

        sc.close();
    }
}
