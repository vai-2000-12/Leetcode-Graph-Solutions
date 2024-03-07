class Solution {
    public long maximumImportance(int n, int[][] roads){
   int[] Indegree = new int[n];
   for( int []a : roads){
     Indegree[a[0]]++;
     Indegree[a[1]]++;
   }
     
     Arrays.sort(Indegree);
     long res = 0;
     for( int i = 0; i < n ; i++){
        res += (long) Indegree[i] * (i+1);      
     }

return res;
    }
}