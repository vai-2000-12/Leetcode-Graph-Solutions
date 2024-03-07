import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj, visited, source, destination);
    }

    public boolean dfs(List<List<Integer>> adj, boolean[] visited, int source, int destination) {
        Stack<Integer> st = new Stack<Integer>();
        visited[source] = true;
        st.push(source);

        while (!st.isEmpty()) {
            int u = st.pop();
            if (u == destination)
                return true;
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    st.push(v);
                }
            }
        }
        return false;
    }
}