class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Use Topological Sorting for the Solution
        // Step 1: Find the Indegree of the Node
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                adj.get(it).add(i); 
                inDegree[i]++;
            }
        }

        // If the Indegree of the Node is 0, add it to the Queue first
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }
        List<Integer> count = new ArrayList<Integer>();

        while(!q.isEmpty()) {
            int node = q.poll();
            count.add(node);
            // Check for its Adjacents
            for (int v : adj.get(node)) {
                if (--inDegree[v] == 0)
                    q.add(v);
            }
        }
        Collections.sort(count);
        return count;
    }
}