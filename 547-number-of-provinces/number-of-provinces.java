// class Solution {

//     public void dfs(int node, int[][] isConnected, boolean[] visited) {

//         visited[node] = true;

//         for (int j = 0; j < isConnected.length; j++) {

//             if (isConnected[node][j] == 1 && !visited[j]) {
//                 dfs(j, isConnected, visited);
//             }
//         }
//     }

//     public int findCircleNum(int[][] isConnected) {

//         int n = isConnected.length;
//         boolean[] visited = new boolean[n];

//         int provinces = 0;

//         for (int i = 0; i < n; i++) {

//             if (!visited[i]) {
//                 provinces++;
//                 dfs(i, isConnected, visited);
//             }
//         }

//         return provinces;
//     }
// }


class Solution {

    // DFS
    public void dfs(int node,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited) {

        visited[node] = true;

        for (Integer neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj =
                new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Convert matrix → adjacency list
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        // Step 3: Find provinces using DFS
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                dfs(i, adj, visited);
            }
        }

        return provinces;
    }
}