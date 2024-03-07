class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1; // Not enough connections to connect all components
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] connect : connections) {
            adj.get(connect[0]).add(connect[1]);
            adj.get(connect[1]).add(connect[0]);
        }

        int NumberOfComponents = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(adj, visited, i);
                NumberOfComponents++;
            }
        }

        return NumberOfComponents - 1;
    }

    public void DFS(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        for (int v : adj.get(node)) {
            if (!visited[v]) {
                DFS(adj, visited, v); 
            }
        }
    }
}