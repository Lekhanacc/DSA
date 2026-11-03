// Using DFS 

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {
                if (!dfs(graph, i, 0, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int col, int[] color) {

        color[node] = col;

        for (int adj : graph[node]) {

            if (color[adj] == -1) {

                if (!dfs(graph, adj, 1 - col, color)) {
                    return false;
                }
            }

            else if (color[adj] == col) {
                return false;
            }
        }

        return true;
    }
}

