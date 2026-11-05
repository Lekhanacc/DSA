class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] state = new int[n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (dfs(graph, i, state)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {

        if (state[node] == 1) {
            return false;
        }

        if (state[node] == 2) {
            return true;
        }

        state[node] = 1;

        for (int adj : graph[node]) {

            if (!dfs(graph, adj, state)) {
                return false;
            }
        }

        state[node] = 2;

        return true;
    }
}