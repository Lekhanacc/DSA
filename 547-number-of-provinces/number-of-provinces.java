// Directly from matrix 

// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 count++;
//                 dfs(i, isConnected, visited);
//             }
//         }

//         return count;
//     }

//     private void dfs(int node, int[][] isConnected, boolean[] visited) {
//         visited[node] = true;

//         for (int j = 0; j < isConnected.length; j++) {
//             if (isConnected[node][j] == 1 && !visited[j]) {
//                 dfs(j, isConnected, visited);
//             }
//         }
//     }
// }


// converting it to adjacency list 
import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Convert matrix to adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}