class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         List<Integer> result = new ArrayList<Integer>();
      int [] Indegree = new int[n];
      for(List<Integer> e : edges)
        Indegree[e.get(1)] = 1;
       for( int i = 0 ; i < n ; i++)
          if(Indegree[i] == 0)
           result.add(i);
    
    return result;
    }
}