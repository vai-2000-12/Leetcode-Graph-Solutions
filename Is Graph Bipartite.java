import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        // Initialize color array to -1 (unvisited)
        for (int i = 0; i < n; i++) {
            color[i] = -1;
        }
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!isCheck(i, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isCheck(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
      
        while (!q.isEmpty()) {
            int node = q.poll(); 

            // Iterate through adjacent nodes
            for (int it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}