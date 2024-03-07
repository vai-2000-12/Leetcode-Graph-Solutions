class Solution {
    public int minScore(int n, int[][] roads) {
      List<int[]>[] adj = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            adj[r[0]].add(new int[] {r[1], r[2]});
            adj[r[1]].add(new int[] {r[0], r[2]});
        }

        boolean[] vis = new boolean[n + 1];
        vis[1] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        int score = 10001;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int[] nei : adj[curr]) {
                int next = nei[0], dist = nei[1];
                score = Math.min(score, dist);
                if (!vis[next]) {
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
        return score;       
    }
}