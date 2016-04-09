package leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m+1][n+1];
        result[0][0] = 0;
        for(int i=1;i<=n;i++)
        {
            result[0][i] = result[0][i-1]+1;
        }
        for(int i=1;i<=m;i++)
        {
            result[i][0] = result[i-1][0]+1;
        }
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                int x = 0;
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    x= result[i-1][j-1];
                }
                else
                {
                    x = result[i-1][j-1]+1;
                }
                result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1), x);
            }
        }
        return result[m][n];
    }
}
