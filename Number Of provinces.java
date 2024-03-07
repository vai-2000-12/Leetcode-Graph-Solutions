class Solution {
    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        int n = isConnected.length;
        visit[node] = true;
        for (int i = 0; i < n; i++) {
            if (isConnected[node][i] == 1 && !visit[i]) { 
                dfs(i, isConnected, visit); 
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; 
        boolean[] visit = new boolean[n];
        int comp = 0;
        for (int i = 0; i < n; i++) { 
            if (!visit[i]) {
                comp++;
                dfs(i, isConnected, visit); 
            }
        }
        return comp;
    }
}