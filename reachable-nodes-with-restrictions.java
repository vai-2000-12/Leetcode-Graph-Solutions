class Solution {
       List<List<Integer>> adj = new ArrayList<>();
       int count  = 0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
      boolean[] visited = new boolean[n];

      for( int i = 0 ; i < n ; i++){
           adj.add(new ArrayList<>());
      }
      for( int i : restricted){
           visited[i] = true; 
      }
      for(int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
           adj.get(edge[1]).add(edge[0]);
      }

      DFS(0, visited);
      return count;
    }
    private void DFS(int s , boolean[]visited){
        visited[s] = true;
         count++;
       for( int v : adj.get(s)){
           if(!visited[v]){
           DFS( v , visited);
           }
       } 
    }
}